package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * new IO 中的 FileChannel 熟悉操作
 * @author 建苍
 *
 */
public class GetChannel {
	private static final int BSIZE = 1024;
	private static final String file = "c:\\javajdk\\Redirecting.file";
	public static void main(String[] args) throws IOException{
		FileChannel fc = new FileOutputStream(file).getChannel();
		//FileChannel  write(ByteBuffer[])
		fc.write(ByteBuffer.wrap("不可以是中文".getBytes()));
		fc.close();
		//fc 可以移动位置
		fc = new RandomAccessFile("c:\\javajdk\\Redirecting.file","rw").getChannel();
		//这两步操作就相当于在文件末尾添加新的内容
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("AddEndOfFile".getBytes()));
		fc.close();
		//写完了，试试看怎么读文件
		fc = new FileInputStream("c:\\javajdk\\Redirecting.file").getChannel();
		//只能 使用 静态方法来构造ByteBuffer，它是一个抽象类，
		//无法自动初始化， allocate(int capacity)
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		//当去使用 read 来填充数组缓冲流时，
		//必须要立即调用filp方法，用来做填充的准备
		buff.flip();
		//基本遍历咯
		while(buff.hasRemaining()){
			//这里直接读char会有问题，还是要以byte为单位来读取
			System.out.println((char)buff.get());
		}
		
		
	}
	
}
