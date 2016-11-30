package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 两种lock的方法，synchronized(entire method) & critical section
 * 性能比较(差异不大)，
 * 相对资源锁定的时间就不一样了/体现在其他线程访问的次数上
 * 
 * @author 建苍
 *
 */
public class CriticalSection {
	static void 
		testApproaches(PairManager pman1,PairManager pman2){
		ExecutorService exec = Executors.newCachedThreadPool();
	    PairManipulator
	      pm1 = new PairManipulator(pman1),
	      pm2 = new PairManipulator(pman2);
	    PairChecker
	      pcheck1 = new PairChecker(pman1),
	      pcheck2 = new PairChecker(pman2);
	    exec.execute(pm1);
	    exec.execute(pm2);
	    exec.execute(pcheck1);
	    exec.execute(pcheck2);
	    try{
	    	TimeUnit.MILLISECONDS.sleep(500);
	    }catch(InterruptedException e){
	    	System.out.println("Sleep interrupted");
	    }
	    System.out.println("pm1:"+pm1+"\npm2"+pm2);
	    System.exit(0);
	}
	public static void main(String[] args) {
		PairManager
			pman1 = new PairManager1(),
			pman2 = new PairManager2();
		testApproaches(pman1,pman2);
	}
}
/**
 * 只要x和y分别在两个方法中去自增，
 * 那么这个Pair对象无论如何都是不可能同步的
 * 无法保证x==y
 * 这个类就是为了演示如何去操作一个线程不安全的类
 * 使得其安全
 * 
 * @author 建苍
 *
 */
class Pair{
	private int x,y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Pair(){}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void incrementX(){x++;}
	public void incrementY(){y++;}
	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	public class PairValuesNotEqualException
		extends RuntimeException{
		public PairValuesNotEqualException(){
			super("Pair values not equal: "+Pair.this);
		}
	}
	public void checkState(){
		if(x!=y){throw new PairValuesNotEqualException();}
	}
}
/**
 * 这里用了模板设计模式：
 * 用 composition，一个派生类去has旧类，
 * 并增加新的设计方法，abstract
 */
abstract class PairManager{
	AtomicInteger checkCounter = new AtomicInteger(0);
	//模板设计
	protected Pair p = new Pair();
	private List<Pair> storage = 
			Collections.synchronizedList(new ArrayList());
	//然后开始对 原生类进行 方法上的 设计
	public synchronized Pair getPair(){
		return new Pair(p.getX(),p.getY());
	}
	/**
	 * 要让这个操作耗时，才能体现出资源被占用(时间长/粒度大)
	 * @param p
	 */
	protected void store(Pair p){
		storage.add(p);
		try{
			TimeUnit.MILLISECONDS.sleep(50);
		}catch(Exception IDontCare){
		}
	}
	//模板核心添加方法
	abstract void increment();
}
/**
 * Method One: 直接 锁方法，粒度大granularity
 * @author 建苍
 *
 */
class PairManager1 extends PairManager{
	public synchronized void increment(){
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
}
/**
 * Method Two: critical section ,granularity小得多
 * @author 建苍
 *
 */
class PairManager2 extends PairManager{
	public void increment(){
		Pair temp;
		synchronized(this){
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}
}
/**
 * 用来操作increment，计算性能并输出
 * @author 建苍
 *
 */
class PairManipulator implements Runnable{
	private PairManager pm;
	public PairManipulator(PairManager pm){
		this.pm = pm;
	}
	public void run(){
		while(true){
			pm.increment();
		}
	}
	public String toString(){
		return "Pair: "+pm.getPair()+
				"checkCounter = "+pm.checkCounter.get();
	}
}
/**
 * Checker主要执行的测试工作，尝试访问该对象的其他资源。
 * 并且记录访问次数
 * @author 建苍
 *
 */
class PairChecker implements Runnable{
	private PairManager pm;
	public PairChecker(PairManager pm){
		this.pm = pm;
	}
	public void run(){
		while(true){
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}
	}
}