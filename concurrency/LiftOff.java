package concurrency;
/**
 * 制造一个 线程
 * 每个火箭都有自己的倒计时，
 * 同时也不影响别的火箭的倒计时
 * 
 * @author 建苍
 *
 */
public class LiftOff implements Runnable{
	
	private int countDown = 10;
	private static int counter = 0;
	private final int id = counter++;
	
	public LiftOff(){}
	public LiftOff(int countDown){
		this.countDown = countDown;
	}
	public String status(){
		return "#"+id+"("+
			(countDown>0?countDown:"LiftOff!")+"),";
	}
	
	@Override
	public void run() {
		while(countDown-- >0){
			System.out.println(status());
			Thread.yield();
		}
	}
	
}
