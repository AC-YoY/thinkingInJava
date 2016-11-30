package reusing;

import java.util.Arrays;

public class finalDemo {
	public static void main(String[] args) {
		finalDemo finalDemo = new finalDemo();
		int[] x = finalDemo.S;
		x[0] = 1;
		x[1] = 2;
		x[2] = 3;
		
		System.out.println(Arrays.toString(S));
	}
	
	static final int[] S = new int[3]; 
}
