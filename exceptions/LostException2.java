package exceptions;

public class LostException2 {
	public static void main(String[] args) {
		try{
			throw new Exception("我是凯丁！");
		}finally{
			return;
		}
		//now wo get an unreachable code here
//		int x = 6;
//		System.out.println(x);
	}
}
