package exceptions;
/**
 * 追溯调用的方法！！
 * Backtrack (look back upon) method name!
 * @author 建苍
 *
 */
public class WhoCalled {
	public static void main(String[] args) {
		f();
		System.out.println("------------------");
		g();
		System.out.println("------------------");
		h();
	}
	
	
	static void f(){
		//generate an exception to fill in the stack trace
		try{
			throw new Exception();//no-para??????
		}catch(Exception e){
		/**
		 * 怎么这个可以遍历？！io中的serializable interface
		 * lang 中的iterable也行
		 * 你们全家都能遍历把 
		 */
			for(StackTraceElement st:e.getStackTrace()){
				//take it easy ,it's just a method name
				System.out.println(st.getMethodName());
			}
		}
	}
	
	static void g() {f();}
	static void h() {f();}
	
	
}
