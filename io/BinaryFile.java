package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 专门用来读取二进制文件
 * 
 * @author 建苍
 *
 */
public class BinaryFile {
	public static void main(String[] args) {
		
	}
	//读取二进制文件
	public static byte[] read(File bFile) throws IOException{
		BufferedInputStream bis = 
				new BufferedInputStream(
						new FileInputStream(bFile));
		try{
			byte[] data = new byte[bis.available()];
			bis.read(data);
			return data;
		}finally{
			bis.close();
		}
	}
	//重载一个String 类型的
	public static byte[] read(String fileName)throws IOException{
		return read(new File(fileName).getAbsoluteFile());
	}
}
