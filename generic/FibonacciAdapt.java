package generic;

import java.util.Iterator;

public class FibonacciAdapt extends Fibonacci implements Iterable<Integer>{
	//所以说这个pointer仅仅是为了让Iterator有边界
	//可以让hasNext判断结束用的
	private int pointer = 0;
	
	public FibonacciAdapt(int pointer) {
		super();
		this.pointer = pointer;
	}

	@Override
	public Iterator iterator() {
		return new Iterator(){
			@Override
			public boolean hasNext() {
				return pointer > 0;
			}
			@Override
			public Object next() {
				//adapt继承于fibonacci所有也有他的next
				pointer--;
				return FibonacciAdapt.this.next();
			}
		};
	}
	
	public static void main(String[] args) {
		int x=0;
		for(int i:new FibonacciAdapt(20)){
			System.out.println(x+++":"+i);
		}
		
	}
}
