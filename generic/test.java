package generic;

public class test<T> {
	T t;
	public test(Class<T> kind){
		try{
			t = kind.newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		test test = new test(A.class);
		test test2 = new test(B.class);
		System.out.println(test.t);
		System.out.println(test2.t);
	}
}
class A{
	private A(){}
}
class B{
	public B(){}
}
