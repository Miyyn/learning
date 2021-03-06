package com.demo;

public interface ThreadPool<Job extends Runnable> {
	
	void execute(Job job);
	
	void shoutdown();
	
	void addWorkers(int num);
	
	void removeWorker(int num);
	
	int getJobSize();

}
