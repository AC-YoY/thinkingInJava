package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 终结任务：计算通过花园们的人数
 * Count对象保存一个人数统计
 * Entrance类 保存一个人数统计
 * 
 * @author 建苍
 *
 */
public class OrnamentalGarden {
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new Entrance(i));
		}
		//Run for a while!then collect data
		TimeUnit.SECONDS.sleep(2);
		Entrance.cancel();
		exec.shutdown();
		//Blocks here! make sure outPrint is ordered
		if(exec.awaitTermination(250, TimeUnit.MILLISECONDS)){
			System.out.println("Some tasks were not terminated!");
		}
		System.out.println("Total: "+Entrance.getTotalCount());
		System.out.println("Sum of Entrances: "+Entrance.sumEntrances());
	}
}
/**
 * Class Count used for saving the number of people
 * make sure Count is thread safe
 * @author 建苍
 *
 */
class Count{
	private int count = 0;
	private Random random = new Random();
	public synchronized int increment(){
		int temp = count;
		// 
		if(random.nextBoolean()){
			Thread.yield();
		}
		return (count = ++temp);
	}
	public synchronized int value(){return count;}
}

class Entrance implements Runnable{
	//all Entrance instances share this count object
	private static Count count = new Count();
	private static List<Entrance> entrances = 
			new ArrayList<Entrance>();
	//the number of people through this Entrance
	private int number = 0;
	//unique Entrance ID
	private final int id;
	//这里的static和volatile用来给所有的全部的Entrance做标记，这样可以统一结束任务
	private static volatile boolean canceled = false;
	//对一个volatile变量做操作是原子性的，不加上synchronized也是可以的
	public static void cancel(){canceled = true;}
	public Entrance(int id){
		this.id = id;
		//Keep this task in a list,Also prevents
		//grabage collection of dead tasks
		//因为最后要全部关闭了线程之后才会进行统计人数，所以要保持对象存活
		entrances.add(this);
	}
	@Override
	public void run(){
		while(!canceled){
			synchronized(this){
				++number;
			}
			//keep printing numbers of people 
			System.out.println(this+" Total:"+count.increment());
			try{
				TimeUnit.MILLISECONDS.sleep(100);
			}catch(Exception e){
				System.out.println("Sleep interrupted!");
			}
		}
		System.out.println("Stopping "+this);
	}
	public synchronized int getValue(){return number;}
	public String toString(){
		return "Entrance " + id + ": " + getValue();
	}
	public static int getTotalCount(){
		return count.value();
	}
	public static int sumEntrances(){
		int sum = 0;
		for(Entrance entrance:entrances){
			sum += entrance.getValue();
		}
		return sum;
	}
}