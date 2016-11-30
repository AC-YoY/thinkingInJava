package concurrency;
/**
 * join() 和 interrupt
 * interrupt()的标记会在exception中被清理
 * 所以catch中总是false
 * 
 * @author 建苍
 *
 */
public class Joining {
	public static void main(String[] args) {
		Sleeper 
			A = new Sleeper("A",1500),
			B = new Sleeper("B",1500);
		Joiner
			C = new Joiner("C",A),
			D = new Joiner("D",B);
		A.interrupt();
	}
	
}

class Sleeper extends Thread{
	private long sleep;
	public Sleeper(String name,long sleep){
		super(name);
		this.sleep = sleep;
		start();
	}
	public void run(){
		try {
			sleep(sleep);
		} catch (InterruptedException e) {
			System.out.println(getName()+" is interruped,"+"this.isInterrupted()"+isInterrupted());
			//失败了他任然就继续执行！！！trycatch以外的部分！
			return;
		}
		System.out.println(getName()+" has Awaked");
	}
	
}

class Joiner extends Thread{
	private Sleeper sleeper;
	public Joiner(String name,Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	public void run(){
		try{
			sleeper.join();
		}catch(Exception e){
			System.out.println(getName()+"is interruped");
		}
		System.out.println(getName()+" is dead");
	}
}