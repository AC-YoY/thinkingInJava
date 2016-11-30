package holding;

import java.util.Iterator;
/**
 * 实现了iterable接口就能使用for in 新循环了
 * 
 * !!!记得 要实现一个generic的Iterable
 * 
 * @author 建苍
 *
 */
public class IterableDemo implements Iterable<String>{
	public static void main(String[] args) {
		IterableDemo iterableDemo = new IterableDemo();
		for(String str : iterableDemo){
			System.out.print(str+", ");
		}
	}
	protected String[] str = {"FDSA","liug","jfye"};
	@Override
	public Iterator iterator() {
		/**
		 * inner class
		 */
		return new Iterator(){
			private int pointer=0; 
			@Override
			public boolean hasNext() {
				return pointer < str.length;
			}
			/**
			 * so actually i get the current one
			 */
			@Override
			public Object next() {
				return str[pointer++];
			}
			
		};
	}
}

