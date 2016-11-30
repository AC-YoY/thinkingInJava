package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 因为线程工作的特殊性，无法直接捕获他的异常
 * @author 建苍
 *
 */
public class ExceptionThread implements Runnable{
	public void run(){
		throw new RuntimeException("HeHe");
	}
	public static void main(String[] args) {
		try{
			ExecutorService es = Executors.newCachedThreadPool();
			es.execute(new ExceptionThread());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
