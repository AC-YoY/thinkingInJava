package concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results =
			      new ArrayList<Future<String>>();
		for(int i=0;i<5;i++){
			results.add(es.submit(new TaskWithResult(i)));
		}
		//遍历结果
		for(Future<String> f :results){
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}finally{
				es.shutdown();
			}
		}
	}
}
class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id){
		this.id = id;
	}
	public String call(){
		return "TaskWithResult:"+id;
	}
}
