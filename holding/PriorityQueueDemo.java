package holding;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		Random rd = new Random();
		//like a treeMap/treeSet? 
		for(int i=0;i<20;i++){
			queue.add(rd.nextInt(100));
		}
		//Construct with a order/sequence?
		PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>(queue.size(),Collections.reverseOrder());
		queue2.addAll(queue);
		QueueDemo.printQueue(queue);
		QueueDemo.printQueue(queue2);
		
		//泛型就是sb，集合里面定义了之后就不能UpperCase了
//		HashSet<char[]> hashSet = new HashSet<char[]>(Arrays.asList("SAFEWasdsafw".toCharArray()));
//		System.out.println(hashSet);
		//所以只能一个个去添加。。。
		HashSet<Character> hashSet = new HashSet<Character>();
		for(char c:"dsadEGCJfirnnds".toCharArray()){
			hashSet.add(c);
		}
		System.out.println(hashSet);
		//难道又要遍历一遍？ make a copy，果然会玩
		PriorityQueue<Character> pq = new PriorityQueue<Character>(Collections.reverseOrder());
		pq.addAll(hashSet);
		QueueDemo.printQueue(pq);
		
	}
}
