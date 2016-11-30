package io;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {
	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(
				BufferedInputFile.read("C:\\workspace\\thinking in java\\src\\io\\test.java"));
		int c;
		while ((c = in.read()) != -1){
			System.out.print((char) c);
		}
	}
}