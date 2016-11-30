package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {
	public static void main(String[] args) {
//		LiftOff liftOff = new LiftOff(20);
//		liftOff.run();
//		Thread thread = new Thread(new LiftOff());
//		thread.start();
//		System.out.println("Here Main Thread ends!");
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			es.execute(new LiftOff());
		}
		es.shutdown();
		System.out.println();
		
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			exec.execute(new LiftOff());	
		}
		exec.shutdown();
	}
}
