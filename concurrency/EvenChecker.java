package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable{
	private IntGenerator generator;
	private final int id;
	public EvenChecker(IntGenerator g,int id){
		generator = g;
		this.id = id;
	}
	@Override
	public void run() {
		while(!generator.isCannceled()){
			int val = generator.next();
			if(val%2!=0){
				System.out.println(val+"not even!");
				generator.cancel();
			}
		}
	}
	//Test any type of IntGenerator:
	public static void test(IntGenerator g,int count){
		System.out.println("Press control+c could exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<count;i++){
			exec.execute(new EvenChecker(g,i));
		}
		//在这里加一个延时，可以在 延迟线程被关闭的时间
		//就可以看到更加多的冲突
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exec.shutdown();
	}
	//Default value for count:
	public static void test(IntGenerator g){
		test(g,10);
	}
	
}
