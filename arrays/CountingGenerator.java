package arrays;

import generic.Generator;

import java.util.Random;

/**
 * 自动生成一个数组
 * 
 * @author 建苍
 * 
 */
public class CountingGenerator {
	public static class Boolean implements Generator<java.lang.Boolean> {
		private boolean value = false;

		public java.lang.Boolean next() {
			return value;
		}
	}
	public static class Byte implements Generator<java.lang.Byte>{
		private byte value = 0;
		public java.lang.Byte next(){
			return value;
		}
	}
	static char[] chars="zxcvbnmZXCVBNM".toCharArray();
	public static class Character implements Generator<java.lang.Character>{
		int index = -1;
		public java.lang.Character next(){
			//666 实现了一个 常数的循环
			index = (index+1) % chars.length;
			return chars[index];
		}
	}
	public static class Integer implements Generator<java.lang.Integer>{
		Random random = new Random();
		public java.lang.Integer next(){
			return random.nextInt(100);
		}
	}
	public static void main(String[] args) {
//		CountingGenerator.Boolean
	}
	
}
