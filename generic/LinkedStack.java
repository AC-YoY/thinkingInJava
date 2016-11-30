package generic;

public class LinkedStack<T> {
	//这个U是为了实现任意的top对象都可以存入？！
	private static class Node<U>{
		U item;
		Node<U> next;
		Node(){item=null;next=null;}
		Node(U item,Node<U> next){
			this.item = item;
			this.next = next;
		}
		boolean end(){return item==null&&next==null;}
	}
	//造了一个Node对象，末端哨兵，一个空对象
	private Node<T> top = new Node<T>();
	public void push(T item){
		//core！！！！！top始终是顶部栈，而底部的top始终是空的
		top = new Node<T>(item,top);
	}
	public T pop(){
		T result = top.item;
		if(!top.end()){
			top = top.next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		LinkedStack<String> ls = new LinkedStack<String>();
		for(String s:"DSAFE".split("")){
			ls.push(s);
		}
		String s;
		while((s = ls.pop()) != null){
			System.out.println(s);
		}
	}
}
