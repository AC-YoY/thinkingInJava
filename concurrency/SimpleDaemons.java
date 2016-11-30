package concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable{
	
	public void run(){
		try {
			TimeUnit.MILLISECONDS.sleep(100);
			//在这里this是什么
			System.out.println(Thread.currentThread()+":this? "+this);
		} catch (InterruptedException e) {
			System.out.println("sleep() interrupted");
		}
	}
	
	public static void main(String[] args) throws Exception{
		for(int i=0;i<10;i++){
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("All daemons started");
		
		/**
		 * main才是真正存活着的线程,
		 * 如果main结束 全部daemon线程也就不会继续了
		 */
		TimeUnit.MILLISECONDS.sleep(175);
	}
}
