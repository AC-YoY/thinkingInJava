package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 尝试FileChannel上的资源加锁
 * Attention please!
 * 这个锁是对整个JVM的，而不是针对一个JVM上的多线程的
 * 
 * 
 * @author 建苍
 *
 */
public class FileLocking {
	
	private static final String file = "C:\\javajdk\\Locking.file";
	public static void main(String[] args) throws IOException, InterruptedException {
		FileOutputStream fos = new FileOutputStream(file);
		
		// 现在要对整个资源加锁
		/*
		 * tryLock(long position,long size,boolean shared)
		 * non-para tryLock()用的是(0L,Long.MaxValue,false)
		 * 
		 * 
		 */
		//tryLock就一次，不阻塞
		FileLock fl = fos.getChannel().tryLock();
		//lock会阻塞到被lock上为止
//		FileLock fl2 = fos.getChannel().lock();
		
		//null返回值表示被其他JVM占用了
		if(fl != null){
			System.out.println("lock sucessfully!");
			TimeUnit.SECONDS.sleep(3);
			fl.release();
			System.out.println("Lock release!");
		}
		
		fos.close();
		
	}
	
}
