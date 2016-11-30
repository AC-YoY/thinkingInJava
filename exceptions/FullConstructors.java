package exceptions;

public class FullConstructors {
	public static void main(String[] args) {
		try{
			a();
		}catch(Exception e){
			//普通的out貌似有被重定向的可能性
			e.printStackTrace(System.out);
		}
		try{
			b();
		}catch(Exception e){
			//会变颜色！
			e.printStackTrace(System.err);
		}
	}
	
	
	public static void a() throws MyException{
		System.out.println("none-para constructor Exception");
		throw new MyException();
	}
	public static void b() throws MyException{
		System.out.println("String parameter Exception");
		throw new MyException("Hei judy!");
	}
}
class MyException extends Exception{
	public MyException() {}
	public MyException(String arg0) {
		super(arg0);
	}
}