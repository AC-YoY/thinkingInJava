package arrays;

import generic.Generator;

import java.util.Random;
/**
 * 做一个随机数据生成器
 * 仅仅生成单个随机primitive parameter
 * 
 * @author 建苍
 *
 */
public class RandomGenerator {
	private static Random random = new Random(47);
	/*
	 * 需要生成的类型：boolean,byte,char,string
	 * short,integer,long,float,double
	 */
	public static class Boolean implements Generator<java.lang.Boolean>{
		@Override
		public java.lang.Boolean next() {
			return random.nextBoolean();
		}
	}
	static char[] chars = "zxcvbnmasdfghjklqwertyuiop".toCharArray();
	public static class Character implements Generator<java.lang.Character>{
		int index = -1;
		@Override
		public java.lang.Character next(){
			return chars[(++index)%chars.length];
		}
	}
	public static class String implements Generator<java.lang.String>{
		private int length = 4;
		Generator<java.lang.Character> cg = new Character();
		public String(){}
		public String(int length){this.length=length;}
		@Override
		public java.lang.String next(){
			char[] buf = new char[length];
			for(int i=0;i<length;i++){
				buf[i] = cg.next();
			}
			return new java.lang.String(buf);
		}
	}
	public static class Byte implements Generator<java.lang.Byte>{
		@Override
		public java.lang.Byte next(){
			return (byte)random.nextInt();
		}
	}
	public static class Integer implements Generator<java.lang.Integer>{
		private int mod;
		public Integer(){}
		public Integer(int mod){this.mod=mod;}
		@Override
		public java.lang.Integer next(){
			return random.nextInt(mod);
		}
	}
}
