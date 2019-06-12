package com.demo;

public class B implements Runnable{

	private OnePriviseMethod o;
	
	public B(OnePriviseMethod o) {
		this.o = o;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		o.add("b");
	}

}