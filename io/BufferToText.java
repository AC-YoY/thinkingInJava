package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * new IO,
 * ByteBuffer读取字符，要么（char）byteBuffer.get()
 * 怎么用asCharBuffer
 * 
 * @author 建苍
 *
 */
public class BufferToText {
	private static final int BSIZE = 1024;
	private static final String file = "c:\\javajdk\\Redirecting.file";
	public static void main(String[] args) throws IOException{
		//直接向文件中写内容
		FileChannel fc = new FileOutputStream(file).getChannel();
		fc.write(ByteBuffer.wrap("Hello World!".getBytes()));
		fc.close();
		//利用一个ByteBuffer向文件中写内容
		fc = new FileInputStream("c:\\javajdk\\Redirecting.file").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
			//buff新建好，不需要去clear()
		fc.read(buff);
		buff.flip();
		//这就是用系统默认的字符集的效果
		System.out.println(buff.asCharBuffer());
		//reset buffer
		buff.rewind();
		String encoding = System.getProperty("file.encoding");
		/*
		 * 编码方式一：利用Charset对ByteBuffer进行 **解码**
		 */
		System.out.println("Decode using "+ encoding +": "
				+Charset.forName(encoding).decode(buff));
		//测试数据
		fc = new FileOutputStream(file).getChannel();
		/*
		 * 直接在getBytes()的时候**编码**
		 */
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		//now try reading again
		fc = new FileInputStream(file).getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		
		//Use a CharBuffer to write through:
		fc = new FileOutputStream(file).getChannel();
		buff = ByteBuffer.allocate(24);
		buff.asCharBuffer().put("Some text");
		fc.write(buff);
		fc.close();
		//read and display
		fc = new FileInputStream(file).getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		
	}

}
