package innerClass;
/**
 * 创造一个可以内部类，使得他可以调用外部的参数
 * @author 建苍
 *
 */
public class Sequence {
	//外部类就是一个Object数组,有个add元素方法
	private Object[] items;
	private int next=0;
	public Sequence(int x){items = new Object[x];}
	public void add(Object x){
		if(next < items.length){
			items[next] = x;
			next++;
		}
	}
	
	class SequenceSelector implements Selector{
		private int i=0;
		@Override
		public boolean end() {
			return i == items.length;
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
	public Selector getSelector(){
		return new SequenceSelector();
	}
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for(int i=0;i<10;i++){
			sequence.add(i);
		}
		Selector selector = sequence.getSelector();
		while(!selector.end()){
			System.out.println(selector.current()+" ");
			selector.next();
		}
	}
	
}
interface Selector{
	boolean end();
	Object current();
	void next();
}
