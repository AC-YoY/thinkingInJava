package holding;

import java.util.ArrayList;
/**
 * 没有用泛型的继承
 * @author 建苍
 *
 */
public class CheckWithoutGeneric {

	public static void main(String[] args) {
		ArrayList<Apple> al = new ArrayList<Apple>();
		for(int i=0;i<10;i++){
			al.add(new Apple());
			al.add(new Orange());
		}
		for(Apple a:al){
			System.out.println(a.id());
		}
	}

}

class Apple{
	private static long counter;
	private final long id = counter++;
	public long id(){
		return id;
	}
}
class Orange extends Apple{
	
}

