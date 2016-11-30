package holding;

import java.util.LinkedList;
/**
 * use LinkedList to produce a Stack
 * @author 建苍
 *
 * @param <T>
 */
public class Stack<T>{
	private LinkedList<T> storage = new LinkedList<T>();
	/**
	 * Stack LIFO ，所以只能用addFirst方法
	 * @param t
	 */
	public void push(T t){
		storage.addFirst(t);
	}
	public T peek(){
		//same as getFirst()
		return storage.element();
	}
	public void pop(){
		storage.removeFirst();
	}
	public boolean isEmpty(){
		return storage.isEmpty();
	}
	public String toString(){
		return storage.toString();
	}
}
