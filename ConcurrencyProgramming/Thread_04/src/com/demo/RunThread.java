package com.demo;


/**
 *   ???????
 * @author dellpc
 *
 */
public class RunThread implements Runnable {

	
	private boolean idRunning = true;
	int m;
	
	   public boolean isRunning() {
	        return idRunning;
	    }
	public void  setRunThread(boolean idRunning) {
		this.idRunning = idRunning;
	}

	@Override
	public void run() {
		System.out.println("进入run了");
        while (idRunning == true) {
            int a=2;
            int b=3;
            int c=a+b;
            m=c;
        }
        System.out.println(m);
        System.out.println("线程被停止了！");
	}
	
	
	
}
