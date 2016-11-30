package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenGenerator extends IntGenerator{
	
	private int currentEvenValue = 0;
	//Method One
	//想要同步，只要在 next()上加 synchronized关键字即可
	
//	public synchronized int next(){
	public int next(){
		++currentEvenValue;
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}
	//Method Two
	/**
	 * 不用synchronized关键字而用lock机制的话
	 * Attention！要将锁设定为private，否则就失去了锁的意义了
	 * 
	 * @param x
	 * @return
	 */
//	private Lock lock = new ReentrantLock();
//	public int next(){
//		try{
//			lock.lock();
//			++currentEvenValue;
//			Thread.yield();
//			++currentEvenValue;
//			return currentEvenValue;
//		}finally{
//			lock.unlock();
//		}
//	}
	
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
	
}
