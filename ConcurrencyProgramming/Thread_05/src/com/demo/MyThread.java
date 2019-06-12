package com.demo;

public class MyThread  extends Thread{

	 volatile public static int count;
	 
	 private  synchronized static void addCount() {
	        for (int i = 0; i < 1000; i++) {
	            count = i;
	        }
	        if(count != 999) {
	        	 System.out.println(" --> count=" + count);
	        }else {
	        	 System.out.println("count=" + count);
	        }
	       

	    }

	 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		addCount();
	}

}
