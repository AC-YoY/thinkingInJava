package generic;

import java.util.ArrayList;
import java.util.List;
/**
 * 返回值 前 一定要声明 Generics!!!
 * 调用时候可以 不写，因为有 type argument inference！
 * 
 * @author 建苍
 *
 */
public class GenericVarargs {
	//generic method must declare <>before return value!!!!!
	public static <T> List<T> addT(T...t) {
		ArrayList<T> al = new ArrayList<T>();
		for(T ttt :t){
			al.add(ttt);
		}
		return al;
	}
	
	public static void main(String[] args) {
		 List al = addT("hei there!".split(" "));
		 System.out.println(al);
	}
}
