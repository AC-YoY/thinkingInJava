package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
/**
 * 演示了如何将一个输入流包装起来
 * 从读取文件到以byte形式输出
 * 
 * @author 建苍
 *
 */
public class FormattedMemoryInput {
	public static void main(String[] args) {
		
		try {
			
			DataInputStream in = new DataInputStream(
				new ByteArrayInputStream(
					BufferedInputFile.read("C:\\workspace\\thinking in java\\src\\io\\test.java").getBytes()
				)
			);
			//无法测试EOF的方法
//			while(true){
//				//
//				System.out.println((char)in.readByte());
//			}
			//来测试EOF 继承自 FilterInputStream
			while(in.available() != 0){
				System.out.println((char)in.readByte());
			}
		} catch (IOException e) {
			System.err.println("文件末尾 EOF!!");
			e.printStackTrace();
		}
		
	}
}
