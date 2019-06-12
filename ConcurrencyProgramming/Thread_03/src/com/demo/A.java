package com.demo;

public class A implements Runnable{

	private OnePriviseMethod o;
	
	public A(OnePriviseMethod o) {
		this.o = o;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		o.add("a");
	}

}
