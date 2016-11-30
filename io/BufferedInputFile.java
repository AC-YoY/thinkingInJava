package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	// Throw exceptions to console:
	public static String read(String filename) throws IOException {
		// Reading input by lines:
		// 我们选择这个类是为了能够处理char[]
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null) {
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		System.out.print(read("C:\\workspace\\thinking in java\\src\\io\\test.java"));
	}
}
