package generic;

public class TupleTest {
	static TwoTuple<String,Integer> f(){
		return Tuple.tuple("Hello", 5);
	}
	static TwoTuple f2(){
		return Tuple.tuple("ByeBye", 8);
	}
	
	public static void main(String[] args) {
		TwoTuple<String,Integer> t = f();
		System.out.println(f());
		System.out.println(f2());
		
	}
}
