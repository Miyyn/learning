package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable>  implements ThreadPool{

	
	private static final int MAX_WORKER_NUMBER = 10;
	
	private static final int DEFAULT_WORKER_NUMBERS = 5;
	
	private static final int MIN_WORKER_NUMBERS = 1;
	
	private final LinkedList<Job> jobs = new LinkedList<>();
	
	private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
	
	private int workerNum = DEFAULT_WORKER_NUMBERS;
	
	private AtomicLong threadNum = new AtomicLong();
	
	
	
	
	
	
	public DefaultThreadPool() {
		initializeWorkers(DEFAULT_WORKER_NUMBERS);
	}

	
	
	
	public DefaultThreadPool(int num) {
		workerNum = num > MAX_WORKER_NUMBER ? MAX_WORKER_NUMBER : num < MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:num;
		initializeWorkers(workerNum);
	}




	@Override
	public void execute(Runnable job1) {
		Job job = (Job)job1;
		if(job != null) {
			synchronized (jobs) {
				jobs.addLast(job);
				jobs.notify();
			}
		}
	}

	@Override
	public void shoutdown() {
		// TODO Auto-generated method stub
		for(Worker worker:workers) {
			worker.shutdown();
		}
	}

	@Override
	public void addWorkers(int num) {
		// TODO Auto-generated method stub
		synchronized (jobs) {
			if(num + this.workerNum > MAX_WORKER_NUMBER) {
				num = MAX_WORKER_NUMBER - this.workerNum;
			}
			initializeWorkers(num);
			this.workerNum += num;
		}
	}

	@Override
	public void removeWorker(int num) {
		// TODO Auto-generated method stub
		synchronized (jobs) {
			if(num >= this.workerNum) {
				throw new IllegalArgumentException("beyound workNum");
			}
			int count = 0;
			while(count < num) {
				Worker worker = workers.get(count);
				if(workers.remove(worker)) {
					worker.shutdown();
					count++;
				}
			}
			this.workerNum -= count;
		}
	}

	@Override
	public int getJobSize() {
		// TODO Auto-generated method stub
		return jobs.size();
	}


	
	private void initializeWorkers(int num) {
		for(int i=0;i<num;i++) {
			Worker worker = new Worker();
			workers.add(worker);
			Thread thread = new Thread(worker,"ThreadPool-Worker-"+threadNum.incrementAndGet());
			thread.start();
		}
	}
	
	class Worker implements Runnable{
		private volatile boolean running = true; 
		@Override
		public void run() {
			while(running) {
				Job job = null;
				synchronized (jobs) {
					while(jobs.isEmpty()) {
						try {
							jobs.wait();
						}catch (InterruptedException e) {
							// TODO: handle exception
							Thread.currentThread().interrupt();
							return;
						}
					}
					job = jobs.removeFirst();
				}
				if(job != null) {
					try {
						job.run();
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
		
		public void shutdown() {
			running = false;
		}
		
	}





}
