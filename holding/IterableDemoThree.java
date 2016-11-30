package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class IterableDemoThree extends IterableTest{
	public static void main(String[] args) {
		IterableDemoThree iterableDemoThree = new IterableDemoThree();
		for(String s:iterableDemoThree){
			System.out.print(s+",");
		}
		System.out.println();
		for(String s:iterableDemoThree.reversed()){
			System.out.print(s+",");
		}
		System.out.println();
		for(String s:iterableDemoThree.randomized()){
			System.out.print(s+",");
		}
	}
	
	
	//继承类 实例化后悔返回一个实现了Ietrable的类
	
	//**如果想用不同的迭代方法，就要生产不同的Iterable
	//1.逆向
	public Iterable<String> reversed(){
		return new Iterable<String>(){
			@Override
			public Iterator<String> iterator(){
				return new Iterator<String>(){
					private int pointer = words.length-1;
					@Override
					public boolean hasNext() {
						return pointer > -1;
					}
					@Override
					public String next() {
						return words[pointer--];
					}
					
				};
			}
		};
	}
	
	//2.随缘
	public Iterable<String> randomized(){
		return new Iterable<String>(){
			@Override
			public Iterator<String> iterator(){
				//我们要去造一个迭代器
				ArrayList<String> al= 
						new ArrayList<String>(Arrays.asList(words));
				Collections.shuffle(al);
				return al.iterator();
			}
		};
	}
}
