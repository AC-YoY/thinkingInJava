package concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * 用ThreadFactory创建守护线程
 * 
 * @author 建苍
 *
 */
public class DaemonThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setDaemon(true);
		return thread;
	}
	
}
