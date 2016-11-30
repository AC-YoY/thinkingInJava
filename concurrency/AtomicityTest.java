package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 令人瞠目结舌的Concurrencey问题
 * 
 * @author 建苍
 *
 */
public class AtomicityTest implements Runnable{
	private int i = 0;
	public int getI(){return i;}
	//做成了同步方法
	public synchronized void evenIncrement(){i++;i++;}
	@Override
	public void run(){
		while(true){
			evenIncrement();
		}
	}
	
	public static void main(String[] args) {
		//就跑单线程
		AtomicityTest at = new AtomicityTest();
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(at);
		while(true){
			int val = at.getI();
			if(val%2 != 0){
				System.out.println(val);
//				这里用return已经不够返回了，要终止线程
//				return;
				System.exit(0);
			}
		}
	}
}
