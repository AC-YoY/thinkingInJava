package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author 建苍
 *
 */
public class DaemonFromFactory implements Runnable{
	public void run(){
		try{
			TimeUnit.MILLISECONDS.sleep(100);
			System.out.println(Thread.currentThread() + ":" + this);
		}catch(Exception e){
			System.out.println("DaemonThread Interrupted");
		}
	}
	
	public static void main(String[] args) {
		//用OverWriting的方法！！！
		ExecutorService es = 
				Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<10;i++){
			es.execute(new DaemonFromFactory());
		}
		System.out.println("All DaemonThreads start!");
		try {
			TimeUnit.MILLISECONDS.sleep(150);
			System.out.println("Main Thread Ends!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
