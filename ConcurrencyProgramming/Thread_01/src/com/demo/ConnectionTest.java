package com.demo;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * һ���򵥵����ݿ����ӳ�ʾ��
 * @author dellpc
 *
 */
public class ConnectionTest {

	static ConnectionPool pool = new ConnectionPool(10);
	
	//��֤����ConnectionRunner�ܹ�ͬʱ��ʼ
	static CountDownLatch start = new CountDownLatch(1);
	
	static CountDownLatch end;
	
	public static void main(String[] args) throws InterruptedException {
		//�߳�����
		int threadCount = 20;
		end = new CountDownLatch(threadCount);
		
		int count = 20;
		AtomicInteger got = new AtomicInteger();
		AtomicInteger notGot = new AtomicInteger();
		for(int i=0;i<threadCount;i++) {
			Thread thread = new Thread(new ConnectionRunner(count, got, notGot),"ConnectionRunnerThread");
			thread.start();
		}
		start.countDown();
		end.await();
		System.out.println("total invoke: "+(threadCount*count));
		System.out.println("got connection: "+got);
		System.out.println("not got connection: "+notGot);
	}
	
	
	static class ConnectionRunner implements Runnable{

		int count;
		AtomicInteger got;
		AtomicInteger notGot;
		
		
		
		public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
			super();
			this.count = count;
			this.got = got;
			this.notGot = notGot;
		}



		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				start.await();
			}catch (Exception e) {
				// TODO: handle exception
			}
			while(count > 0) {
				try {
					//���̳߳��л�ȡ���ӣ����1000ms  ���޷���ȡ�������᷵��null
					//�ֱ�ͳ�����ӻ�ȡ������got��δ��ȡ��������notGot
					Connection connection = pool.fetchConnection(1000);
					if(connection != null) {
						try {
							connection.createStatement();
							connection.commit();
						}finally {
							pool.releaseConnection(connection);
							got.incrementAndGet();
						}
					}else {
						notGot.incrementAndGet();
					}
				}catch (Exception e) {
					// TODO: handle exception
				}finally {
					count--;
				}
			}
			end.countDown();
		}
		
	}
	
}