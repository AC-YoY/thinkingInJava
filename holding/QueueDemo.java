package holding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * use LinkedList to produce a Queue
 * @author 建苍
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<10;i++){
			queue.add((int)(100*Math.random()));
		}
		printQueue(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for(char c : "Are you OK?".toCharArray()){
			qc.add(c);
		}
		printQueue(qc);
	}
	public static void printQueue(Queue queue){
		while(queue.peek()!=null){
			//also u can use remove
			System.out.print(queue.poll()+" ");
		}
		System.out.println();
	}
}
