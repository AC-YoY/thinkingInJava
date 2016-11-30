package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttempLocking {
	/**
	 * 锁的本身一定要private,否则都可以操作，失去意义
	 */
	private ReentrantLock lock = new ReentrantLock();
	/**
	 * 无非就是一个non-para overwriting 方法
	 */
	public void untimed(){
		boolean capture = lock.tryLock();
		try{
			System.out.println("untimed().tryLock():"+capture);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//本来 就不一定会成功
			if(capture){
				lock.unlock();
				System.out.println("untimed unlock sucessfully");
			}
		}
	}
	/**
	 * 相较 synchronized 方法 ，
	 * Lock可以等待,这是选择lock的优势
	 * @throws 
	 * 
	 */
	public void timed() {
		boolean capture = false;
		try{
			capture = lock.tryLock(1, TimeUnit.SECONDS);
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			System.out.println("timed().tryLock(1,seconds):"+capture);
		}finally{
			if(capture){
				lock.unlock();
				System.out.println("timed unlock sucessfully");
			}
		}
	}
	
	public static void main(String[] args) {
		final AttempLocking al = new AttempLocking();
		al.untimed();
		al.timed();
		//如果我们用一个线程去占用这把锁呢？
		new Thread(){
			//设置守护的意义就是会让main 不结束
			{setDaemon(true);}
			@Override
			public void run(){
				al.lock.lock();
				System.out.println("acquired sucessfully!");
			}
		}.start();
		
		//不等待就最后执行新线程!!!!!
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//已经锁住了，再yield()也不行
		Thread.yield();
		al.untimed();
		al.timed();
	}
}
