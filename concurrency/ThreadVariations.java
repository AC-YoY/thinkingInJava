package concurrency;

import java.util.concurrent.TimeUnit;
/**
 * 用 inner Class / Anonymous Inner Class
 * 的方法构造thread的例子
 * 
 * @author 建苍
 *
 */
public class ThreadVariations {
	public static void main(String[] args) {
		new InnerThread1("See Thread1");
		new InnerThread2("See Thread2");
		new InnerRunnable1("See Runable1");
		new InnerRunnable2("See Runable2");
		new ThreadMethod("See Task").runTask();
	}
}

/**
 * 在类内部 创建一个线程 自己去管理 using a named inner class
 * 
 * @author 建苍
 * 
 */
class InnerThread1 {
	private int countDown = 5;
	private Inner inner;

	private class Inner extends Thread {
		public Inner(String name) {
			super(name);
			// self managed
			start();
		}

		public String toString() {
			return getName() + "：" + countDown;
		}

		public void run() {
			try {
				while (true) {
					System.out.println(this);
					if (--countDown == 0) {
						return;
					}
					//等待是为了看得能够让其他线程也分配到时间片
					sleep(10);
				}
			} catch (Exception e) {
				System.out.println("Be interrupted");
			}
		}
	}

	public InnerThread1(String name) {
		inner = new Inner(name);
	}
}

/**
 * using a anonymous inner class
 * 
 * @author 建苍
 * 
 */
class InnerThread2 {
	private int countDown = 5;
	private Thread t;

	// 用的时候还是要去传递一个名字的
	public InnerThread2(String name) {
		t = new Thread(name) {
			public void run() {
				try {
					while (true) {
						System.out.println(this);
						if (--countDown == 0) {
							return;
						}
						sleep(10);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public String toString() {
				// getNam() 也是只有线程才有资格去使用的方法
				return getName() + ": " + countDown;
			}
		};
		t.start();
	}
}

/**
 * 使用一个Runnable接口 using a named implementation :
 */
class InnerRunnable1 {
	private int countDown = 5;
	private Inner inner;

	private class Inner implements Runnable {
		// Attention！！这里必须创建一个线程去管理,因为只有runnable接口的话
		// 只能去调用run（） 不能被os去管理
		Thread t;

		public Inner(String name) {
			// 这里的this 是Inner
			t = new Thread(this, name);
			t.start();
		}

		@Override
		public void run() {
			try {
				while (true) {
					System.out.println(this);
					if (--countDown == 0) {
						return;
					}
					TimeUnit.MILLISECONDS.sleep(10);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public String toString() {
			return t.getName() + ": " + countDown;
		}
	}

	public InnerRunnable1(String name) {
		inner = new Inner(name);
	}
}
/**
 * Using anonymous Runnable implementation:
 * @author 建苍
 *
 */
class InnerRunnable2{
	private int countDown =5;
	private Thread t;
	
	public InnerRunnable2(String name){
		t = new Thread(new Runnable(){
			public String toString(){
				return t.getName()+": "+countDown;
			}
			@Override
			public void run() {
				try{
					while(true){
						//这个this又是什么？
						//anonymous inner class
						//Runnable?
						System.out.println(this);
						if(--countDown==0){
							return;
						}
						TimeUnit.MILLISECONDS.sleep(10);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		},name);
		t.start();
	}
}
/**
 * A separate method to run some code as a task
 */
class ThreadMethod{
	private int countDown = 5;
	private Thread t;
	private String name;
	public ThreadMethod(String name){this.name = name;}
	public void runTask(){
		//单例！笑``
		if(t == null){
			t = new Thread(name){
				public void run(){
					try{
						while(true){
							System.out.println(this);
							if(--countDown == 0){
								return;
							}
							sleep(10);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				public String toString(){
					return getName()+": "+countDown;
				}
			};
			t.start();
		}
	}
}

