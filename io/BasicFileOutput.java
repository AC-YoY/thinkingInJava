package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {
	public static void main(String[] args) {
		write();
	}
	static String readFile="C:\\workspace\\thinking in java\\src\\io\\test.java";
	static String writeFile="C:\\workspace\\thinking in java\\src\\io\\test.out";
	public static void write(){
		try {
			BufferedReader br = new BufferedReader(
					new StringReader(BufferedInputFile.read(readFile)));
//			PrintWriter pw = new PrintWriter(
//					new BufferedWriter(new FileWriter(writeFile)));
			// shortcut 更加便捷
			PrintWriter pw = new PrintWriter(writeFile); 
			
			//然后要记录行号
			int lineCounter = 0;
			String s;
			while((s = br.readLine()) != null){
				 pw.println(++lineCounter +": "+s);
			}
			//记得要关闭外部高级流
			pw.close();
			//这是随便写来看看原文件的
			System.out.println(BufferedInputFile.read(readFile));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("something goes wrong when reading/Writing file");
		}
	}
	
}
