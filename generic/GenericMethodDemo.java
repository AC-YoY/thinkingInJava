package generic;
/**
 * how to write a generic method
 * @author 建苍
 *
 */
public class GenericMethodDemo {
	public static void main(String[] args) {
		//调用的时候不用去声明类型
		int x = getQ(3);
		String str = getQ("SSS");
		
		
	}
	//来 造个generic method
	public static <Q> Q getQ(Q q){
		//有返回值
		return q;
	}
	public static <Q> void setQ(Q q){
		//无返回值
	}
	
	
}
