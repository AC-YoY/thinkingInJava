package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class IterableDemoTwo {
	public static void main(String[] args) {
		ArrayList<String> ar = 
				new ArrayList<String>(Arrays.asList("CCC","REWGREd","DSADSa"));
		
		ABCList<String> abc = new ABCList<String>(ar);
		
		for(String s:abc){
			System.out.println(s+" ");
		}
		/**
		 * Attention！！！这里不是说把abc这个集合反转过来了，
		 * 而是说用了一个新的迭代器，只不过这个迭代器是在reverse()方法里
		 * 实现的
		 */
		for(String s:abc.reverse()){
			System.out.println(s+" ");
		}
		
	}
}

class ABCList<T> extends ArrayList<T>{
	//所以这个办法是用来解决集合使用泛型时无法UpperCase的！？
	public ABCList(Collection<? extends T> arg0) {
		super(arg0);
	}
	
	public Iterable<T> reverse(){
		return new Iterable<T>(){

			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>(){
					//Attention！！！ size() 是继承自集合的方法，本类自己特有的
					private int pointer = ABCList.this.size() -1;
					@Override
					public boolean hasNext(){
						return pointer >= 0;
					}
					@Override
					public T next(){
						return get(pointer--);
					}
				};
			}
			
		};
	}
}
















