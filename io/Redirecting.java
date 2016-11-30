package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class Redirecting {
	static String logFile="c:\\javajdk\\Redirecting.file";
	public static void main(String[] args) throws IOException {
		PrintStream ps = new PrintStream(logFile);
		System.setOut(ps);
		System.out.println("回家吃饭");
		System.out.println("吃饱睡觉");
		System.out.print("我没换行");
		System.out.println("看看换行没？");
		
	}
	
}
