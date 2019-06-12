package com.demo;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RunThread r = new RunThread();
		Thread thread = new Thread(r);
		thread.start();
//		Thread.sleep(1000);
		r.setRunThread(false);
	}

}
