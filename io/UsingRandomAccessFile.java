package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 什么方式存入的数据，就用什么方式读取出来
 * 这个文件用ANSI编码就打不开
 * 只能读最后一个用UTF写出来的格式
 * 
 * @author 建苍
 *
 */
public class UsingRandomAccessFile {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile(openFile,"rw");
			for(int i=0;i<7;i++){
				raf.writeDouble(i*1.414);
				
			}
			raf.writeUTF("The end of file");
			raf.close();
			
			display();
			
			raf = new RandomAccessFile(openFile,"rw");
			raf.seek(5*8);
			raf.writeDouble(47.0001);
			raf.close();
			
			display();
			
		} catch (IOException e) {
			System.err.println("IO Exception");
		}
	}
	static String openFile="C:\\workspace\\thinking in java\\src\\io\\test.file";
	
	static void display() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(openFile,"r");
		for(int i=0;i<7;i++){
			System.out.println("Value "+i+": "+raf.readDouble());
		}
		System.out.println(raf.readUTF());
		raf.close();
	}
	
	
}
