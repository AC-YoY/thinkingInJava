package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 对映射文件的部分加锁
 * 
 * @author 建苍
 *
 */
public class LockingMappedFiles {
	//我数学差，你不要骗我，这是128M？？？143M左右
	static final int LENGTH = 0x8FFFFFF;
	static FileChannel fc;
	private static final String file = "C:\\javajdk\\Locking.file";
	
	public static void main(String[] args) throws IOException{
		fc = new RandomAccessFile(file,"rw").getChannel();
		//急速模式，内存mapping
		MappedByteBuffer out = 
				fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
		//用x填充 buffer||缓冲区
		for(int i=0;i<LENGTH;i++){
			out.put((byte)'x');
		}
		new LockAndModify(out,0,0+LENGTH/3);
		new LockAndModify(out,LENGTH/2,LENGTH/2+LENGTH/4);
		
	}
	/**
	 * 这个线程用来为原生ByteBuffer资源填充
	 * 再将其锁定
	 * 
	 * @author 建苍
	 *
	 */
	private static class LockAndModify extends Thread{
		private ByteBuffer buff;
		private int start,end;
		//一旦生成该线程就自动运行
		LockAndModify(ByteBuffer mbb,int start,int end){
			this.start = start;
			this.end = end;
			mbb.limit(end);
			mbb.position(start);
			//so make a copy
			buff = mbb.slice();
			start();//调用run()
		}
		@Override
		public void run() {
			try{
				//blocking invoke method
				FileLock fl = fc.lock(start,end,false);
				System.out.println("Locked: "+start+" to "+end);
				//
				while(buff.position() < buff.limit()-1){
					//注意：两个一组，用前面的填充后面的byte
					buff.put((byte) (buff.get()+1));
				}
				fl.release();
				System.out.println("Release: "+start+" to "+end);
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
	}
	
}
