package initialization;

public class demo1 {
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		System.out.println("A.str:"+a.str+"\nB.str:"+b.str);
	}
}
class A{
	/**
	 * 构造器会在自动初始化的时候去赋值（仅仅会对于属性这么操作）
	 */
	public String str;
}
class B{
	public String str=null;
}
