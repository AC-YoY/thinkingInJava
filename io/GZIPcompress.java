package io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {
	static final String file = "C:\\javajdk\\Redirecting.file";
	static final String srcFile = "C:\\javajdk\\Redirecting.gz";
	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(
				new FileReader(file));
		BufferedOutputStream bos= new BufferedOutputStream(
				new GZIPOutputStream(
						new FileOutputStream(srcFile)));
		System.out.println("Writing File");
		
		int c = 0;
		//读的是两个字节
		while((c= in.read())!=0){
			//写的是一个字节
			bos.write(c);
		}
		in.close();
		bos.close();
		
		System.out.println("Reading file");
		BufferedReader in2 = new BufferedReader(
				new InputStreamReader(
						new GZIPInputStream(
								new FileInputStream(srcFile))));
		String s;
		while((s = in2.readLine())!=null){
			System.out.println(s);
		}
	}
	
}
