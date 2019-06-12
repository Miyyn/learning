package com.demo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread[] mythreadArray = new MyThread[100];
		 for (int i = 0; i < 100; i++) {
	            mythreadArray[i] = new MyThread();
	        }

	        for (int i = 0; i < 100; i++) {
	            mythreadArray[i].start();
	        }
		
	}

}
