package holding;

import java.util.Iterator;

public class IterableTest implements Iterable<String>{
	protected String[] words = ("And that is how " +
		    "we know the Earth to be banana-shaped.").split(" ");

	@Override
	public Iterator<String> iterator() {
		
		return new Iterator<String>(){
			private int pointer=0;
			@Override
			public boolean hasNext() {
				return pointer<words.length;
			}
			@Override
			public String next() {
				return words[pointer++];
			}
			@Override
			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}
	
	public static void main(String[] args) {
		//这里才是关键foreach循环中后边的是能够调用Iterator()中方法的
		//所以实现了Iterable()接口的也行
		for(String s:new IterableTest()){
			System.out.print(s+",");
		}
	}
	
}
