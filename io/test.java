package io;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class test {
	static final String openFile="C:\\workspace\\thinking in java\\src\\io\\test.java";
	public static void main(String[] args) {
//		String str = "ThinkingInJavaUtil";
//		File file = new File(".\\bin");
//		String[] list = file.list();
//		System.err.println(Arrays.toString(list));
		
//		String strs = new File(str).getName();
//		System.out.println(strs);
		
//		System.out.println(file.getName());
		//工具
//		System.out.println(Directory.walk("."));
		 
		File file = new File(".");
//		System.out.println(file.getAbsolutePath());
//		System.out.println(file.getParent());
//		System.out.println(file.getPath());
		file = new File("C:\\workspace\\thinking in java\\src\\io\\test.java");
//		if(file.exists()){
//			System.out.println(file);
//		}else{
//			file.mkdirs();
//		}
		System.out.println(file);
		
		File tempFile = new File(openFile).getAbsoluteFile();
		
//		System.out.println(Byte.MAX_VALUE);
//		byte b = 47;
//		System.out.println((char)b);
//		String str = "ADS";
//		System.out.println(Arrays.toString(str.toCharArray()));
//		System.out.println("--------------------");
//		System.out.println(Arrays.toString(str.getBytes()));
		B b = new B();
		System.out.println(b.x);
	}
}
class A{
	static int x =10;
}
class B extends A{
	static int x = 20;
} 