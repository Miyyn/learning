package com.demo;

import javax.rmi.CORBA.Util;

public class OnePriviseMethod {

	
	public synchronized void add(String name) {
		
		try {
			int sum =100;
			if(name.equals("a")) {
				
				System.out.println("a input ");
				Thread.sleep(1000);
			}else if(name.equals("b")) {
				sum =200;
				System.out.println("b input");
			}
			System.out.println(Thread.currentThread().getName()+" sum = "+sum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
