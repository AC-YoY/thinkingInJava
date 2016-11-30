package generic;

public class Holder<A,B> {
	
	//这个概念叫做元组 tuple 
	
	public final A a;
	public final B b;
	
	public Holder(A a,B b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "Holder [a=" + a + ", b=" + b + "]";
	}
	
	public static void main(String[] args) {
		Holder h = new Holder("Star", "Star".length());
		System.out.println(h);
	}
}
