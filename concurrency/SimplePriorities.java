package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable {
	private int countDown = 5;
	// No optimization!?!?
	private volatile double d;
	private int priority;

	public SimplePriorities(int priority) {
		this.priority = priority;
	}

	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}

	public void run() {
		// 0-9?
		Thread.currentThread().setPriority(priority);
		while (true) {
			for (int i = 0; i < 100000; i++) {
				d += (Math.E + Math.PI) / (double) i;
				if (i % 1000 == 0) {
					//给OS一个去重新切换的机会
					Thread.yield();
				}
			}
			System.out.println(this);
			// 中断Thread
			if (--countDown == 0) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			es.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		}
		es.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		es.shutdown();
	}

}
