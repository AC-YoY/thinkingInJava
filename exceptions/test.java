package exceptions;

import java.util.Arrays;

/**
 * packageName.className@hashCode()
 * 
 * @author 建苍
 *
 */
public class test {
	public static void main(String[] args) {
		try{
			int[] array = new int[3];
			for(int i=0;i<4;i++){
				array[i] = i;
			}
			System.out.println(Arrays.toString(array));
		}catch(Exception e){
			for(StackTraceElement ste:e.getStackTrace()){
				System.out.println(ste.getMethodName());
			}
		}
	}
}