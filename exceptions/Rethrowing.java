package exceptions;
/**
 * 
 * @author 建苍
 *
 */
public class Rethrowing {
	public static void main(String[] args) {
		//两个同时运行会有多线程干扰，一个更加直观。
//		try{
//			g();
//		}catch(Exception e){
//			System.out.println("User errPrint call on g()");
//			e.printStackTrace();
//		}
		try{
			h();
		}catch(Exception e){
			System.out.println("User errPrint call on h()");
			e.printStackTrace();
		}
	}
	
	public static void f() throws Exception{
		System.out.println("errPrint from f()");
		throw new Exception("Exception from f()");
	}
	public static void g()throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("errPrint from g()");
			e.printStackTrace();
//			throw new Exception("Exception from g()");
			throw e;
		}
	}
	public static void h()throws Exception{
		try{
			f();
		}catch(Exception e){
			System.out.println("errPrint from h()");
			e.printStackTrace();
//			throw new Exception("Exception from h()");
			throw (Exception)e.fillInStackTrace();
		}
	}
}
