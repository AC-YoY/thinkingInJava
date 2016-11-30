package typeInfo;
/**
 * 
 * @author 建苍
 *
 */
public class HiddenC {
	public static AA makeAA(){return new C();}
}
// let's hide c 
class C implements AA{
	public void f(){System.out.println("C.f().");};
	public void g(){System.out.println("C.g().");}
	//visible test
	void u(){
		System.out.println("normal C.u().");
	}
	protected void v(){
		System.out.println("Protected C.v().");
	}
	private void w(){
		System.out.println("private C.W().");
	}
}