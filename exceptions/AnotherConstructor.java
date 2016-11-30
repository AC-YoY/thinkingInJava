package exceptions;
/**
 * good Example
 * @author 建苍
 *
 */
public class AnotherConstructor {
	public static void main(String[] args) {
		try{
			f();
		}catch(MyException2 e){
			e.printStackTrace();
		}
		try{
			g();
		}catch(MyException2 e){
			e.printStackTrace();
		}
		try{
			h();
		}catch(MyException2 e){
			e.printStackTrace();
			System.out.println("e.val() = " + e.getVal());
		}
		
	}	
		
		
		
	public static void f() throws MyException2{
		System.out.println("see my f() Exception");
		throw new MyException2();
	}
	public static void g() throws MyException2{
		System.out.println("see my g() Exception");
		throw new MyException2("this's a String Constructor");
	}
	public static void h() throws MyException2{
		System.out.println("see my h() Exception");
		throw new MyException2("i'm g() String",88);
	}
	
}
class MyException2 extends Exception{
	private int val;
	public MyException2() {
		super();
	}
	public MyException2(String arg0) {
		super(arg0);
	}
	public MyException2(String s,int val){
		super(s);
		this.val = val;
	}
	public int getVal(){return val;}
	//used for what?  **like a toString method**
	public String getMessage(){
		return "why we need a getMessage()??? you see this"
				+ "Val-para:"+val+",super.message():"
				+super.getMessage();
	}
	
}