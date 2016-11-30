package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TEST {
	public static void main(String[] args) {
		int[][] it = new int[][]{{1,4,5},{2}};
		System.out.println(Arrays.deepToString(it));
		
		//String.valueOf相当于 toString()
		System.out.println(String.valueOf(new XXX()));
		
		XXX<String>[] whoCare;
		//根本不允许你去实例化一个 泛型数组 !!!!!
//		whoCare = new XXX<String>[10];
		List[] ls;
		ls = new List[10];
		ls[0] = new ArrayList();
		
		X[] x = new X[10];
		x[0] = new Y();
		Y[] y = new Y[10];
//		covariant Array
		x = y;

		System.out.println(TEST.class);
		System.out.println(Arrays.toString(TEST.class.getClasses()));
		
	}
	
	//Inner class 哟
	public class A{
		@Override
		public String toString() {
			return "A []";
		}
	}
	public class B{
		@Override
		public String toString() {
			return "B []";
		}
	}
}
class XXX<T> {

	public String toString() {
		return "XXX [getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
class X{}
class Y extends X{}