package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * 要从原数组中随机选择出一个真子集
 * 
 * 现实意义，随机选择 icecream的组合口味
 * 
 * @author 建苍
 *
 */
public class IceCream {
	private static Random random = new Random();
	private static final String[] FLAVORS = {
	    "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
	    "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
	    "Praline Cream", "Mud Pie"
	  };
	
	public static String[] radFlavors(int size){
		if(size>FLAVORS.length){
			throw new RuntimeException("OutOfBound");
		}
		boolean[] picked = new boolean[FLAVORS.length];
		String[] target = new String[size];
		int t;
		for(int i=0;i<size;i++){
			//如口味已经选择就另外换一个
			do{
				t = random.nextInt(FLAVORS.length);
			}
			while (picked[t]);
			
			target[i] = FLAVORS[t];
			picked[i] = true;
		}
		return target;
	}
	
	public static void main(String[] args) {
		//AS U LIKE!!!
		System.out.println(Arrays.toString(radFlavors(6)));
	}
	
}
