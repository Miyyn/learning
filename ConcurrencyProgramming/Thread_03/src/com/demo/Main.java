package com.demo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OnePriviseMethod thread1 = new OnePriviseMethod();
		OnePriviseMethod thread2 = new OnePriviseMethod();
		A a = new A(thread1);
		B b = new B(thread2);
		Thread s = new Thread(a,"A");
		Thread e = new Thread(b,"B");
		s.start();
		e.start();
	}

}
