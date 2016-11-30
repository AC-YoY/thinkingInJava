package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 生成一个随机数字
 * 来测试并发问题
 * 
 * @author 建苍
 *
 */
public class SerialNumberChecker {
	//开启线程数
	private static final int SIZE = 10;
	private static CircularSet serials = new CircularSet(1000);
	private static ExecutorService es = Executors.newCachedThreadPool();
	static class SerialChecker implements Runnable{
		public void run(){
			while(true){
				int serial = SerialNumberGenerator.nextSerialNumber();
				if(serials.contains(serial)){
					System.out.println("Duplicate: " + serial);
					System.exit(0);
				}
				serials.add(serial);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<SIZE;i++){
			es.execute(new SerialChecker());
		}
		TimeUnit.SECONDS.sleep(10);
		System.out.println("No Duplicate Number");
		System.exit(0);
	}
}
class SerialNumberGenerator{
	//解决了visible问题
	private static volatile int serialNumber = 0;
	/**
	 * 没有解决 线程安全
	 * 可能的错误： 生成的数值没有被返回，返回的仍旧是上次的那个数值
	 * @return
	 */
	public static int nextSerialNumber(){
		return serialNumber++;
	}
}
/**
 * 这个类本身都是没有问题的，
 * 操作临界资源的两个方法都是同步的
 * 
 * @author 建苍
 *
 */
class CircularSet{
	private int[] array;
	private int len;
	private int index = 0;
	public CircularSet(int size) {
		array = new int[size];
		len = size;
		for(int i=0;i<size;i++){
			array[i] = -1; 
		}
	}
	public synchronized void add(int i){
		array[index] = i;
		//循环  circular
		index = ++index % len;
	}
	public synchronized boolean contains(int x){
		for(int i=0;i<len;i++){
			if(array[i]==x){
				return true;
			}
		}
		return false;
	}
}