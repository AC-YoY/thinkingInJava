package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {
	public static void main(String[] args) {
		//一旦奇数就会报错了
		char[] data = "AbCdEfGhIjK".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length*2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		//你的每一个操作都会移动position
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
	}
	
	private static void symmetricScramble(CharBuffer buffer){
		while(buffer.hasRemaining()){
			buffer.mark();
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset();
			buffer.put(c2).put(c1);
		}
	}
}
