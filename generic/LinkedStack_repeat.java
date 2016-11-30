package generic;

public class LinkedStack_repeat<T> {
	private static class Node<T>{
		private T item;
		private Node<T> next;
		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
		public Node(){
			this.item = null;
			this.next = null;
		}
		//判断是否到了顶部的 哨兵
		boolean end(){
			return item==null&&next==null;
		}
	}
	//空参数constructs 作为End sentinel
	private Node<T> top = new Node<T>();
	
	public void push(T element){
		top = new Node<T>(element,top);
	}
	public T pop(){
		T result = top.item;
		if(!top.end()){
			top = top.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		LinkedStack_repeat<String> ls = new LinkedStack_repeat<String>();
		for(String s : "ASDF".split("")){
			ls.push(s);
		}
		String s;
		while((s=ls.pop())!=null){
			System.out.println(s);
		}
	}
}
