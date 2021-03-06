﻿package innerClass;


public class InnerClassDemo {
	private Object[] items;
	private int next = 0;
	public InnerClassDemo(int size){items = new Object[size];}
	public void add(Object x){
		if(next < items.length){
			items[next++] = x;
		}
	}
	//------------------------------------------------
	//------------------------------------------------
	private class SequenceSelector implements Selector{
		private int i=0;
		@Override
		public boolean end() {
			return i==items.length;
		}
		@Override
		public Object current() {
			return items[i];
		}
		@Override
		public void next() {
			if(i<items.length){i++;}
		}
	}
	public Selector selector(){
		return new SequenceSelector();
	}
	public static void main(String[] args) {
		InnerClassDemo sequence = new InnerClassDemo(10);
		for(int i=0;i<10;i++){
			sequence.add(Integer.toString(i));
		}
		Selector selector = sequence.selector();
		while(!selector.end()){
			System.out.println(selector.current()+" ");
			selector.next();
		}
	}
}

