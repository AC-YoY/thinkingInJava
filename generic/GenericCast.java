package generic;

public class GenericCast {
	public static final int SIZE = 10;
	public static void main(String[] args) {
		FixedSizeStack<String> fss = 
				new FixedSizeStack<String>(SIZE);
		for(String s:"S d D K j G M n D F".split(" ")){
			fss.push(s);
		}
		for(int i=0;i<SIZE;i++){
			System.out.println(fss.pop());
		}
	}
	
}
class FixedSizeStack<T>{
	private int index = 0;
	private Object[] storage;
	public FixedSizeStack(int size){
		storage = new Object[size];
	}
	public void push(T item){
		storage[index++] = item;
	}
	@SuppressWarnings("unchecked")
	public T pop(){
		return (T)storage[--index];
	}
}