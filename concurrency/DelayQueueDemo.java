package concurrency;

//为了方便使用 Enum TimeUnit 而导入的
import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
	public static void main(String[] args) {
		Random random = new Random();
		ExecutorService exec = Executors.newCachedThreadPool();
		DelayQueue<DelayedTask> queue = 
				new DelayQueue<DelayedTask>();
		for(int i=0;i<20;i++){
			queue.put(new DelayedTask(random.nextInt(5000)));
		}
		queue.add(new DelayedTask.EndSentinel(5000, exec));
		exec.execute(new DelayedTaskConsumer(queue));
	}
}
class DelayedTask implements Runnable,Delayed{
	private static int counter = 0;
	private final int id = counter++;
	//延时时间
	private final int delta;
	//在比较Delayed对象时 使用，用来判断哪一个是head element
	private final long trigger;
	/**
	 * 为了保存本对象不被gc？
	 */
	protected static List<DelayedTask> sequence = 
			new ArrayList<DelayedTask>();
	public DelayedTask(int delayInMilliseconds){
		delta = delayInMilliseconds;
		trigger = System.nanoTime() + //这里用nanoTime是用来计时的
				NANOSECONDS.convert(delta, NANOSECONDS);
		sequence.add(this);//这一步是为了不被gc么？
	}
	@Override
	public int compareTo(Delayed o) {
		DelayedTask dt = (DelayedTask)o;
		if(trigger > dt.trigger) return 1;
		if(trigger < dt.trigger) return -1;		
		return 0;
	}
	/**
	 * 策略设计模式：
	 * 根据你所传入的对象来决定转换成的类型，将算法的一部分作为参数传入
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(trigger-System.nanoTime(),NANOSECONDS);
	}
	/**
	 * DelayedTask设计成DelayQueue队列最后运行的元素,所以只是打印出统计结果
	 */
	@Override
	public void run() {
		System.out.println(this+" ");
	}
	@Override
	public String toString(){
		return "("+id+":"+delta+")";
	}
	/**
	 * 这个方法是纯粹为了让inner class来使用的
	 * @return
	 */
	public String summary(){
		return "("+id+":"+delta+")";
	}
	public static class EndSentinel extends DelayedTask{
		private ExecutorService exec;
		public EndSentinel(int delay,ExecutorService es){
			super(delay);
			exec = es;
		}
		public void run(){
			for(DelayedTask pt : sequence){
				System.out.println(pt.summary()+" ");
			}
			System.out.println();
			System.out.println(this + " Calling shuntdwnNow()");
			exec.shutdownNow();
		}
	}
}
class DelayedTaskConsumer implements Runnable{
	private DelayQueue<DelayedTask> q;
	public DelayedTaskConsumer(DelayQueue<DelayedTask> q){
		this.q = q;
	}
	public void run(){
		try{
			while(!Thread.interrupted()){
				//这一步的作用就是去执行DelayQueue
				q.take().run();
			}
		}catch(InterruptedException iDontCare){
		}
		System.out.println("Finished DelayedTaskConsumer");
	}
}