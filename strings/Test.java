package strings;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		// Part One
//		Pattern p = Pattern.compile("[aeiou]");
//		Matcher m = p.matcher("SaXA");
//		if(m.find()){
//			m.group().toUpperCase();
//			System.out.println("Here");
//		}
//		System.out.println(m);
		
		// Part Two
//		Pattern pp = Pattern.compile("cat");
//		 Matcher mm = pp.matcher("one cat two cats in the yard");
//		 StringBuffer sb = new StringBuffer();
//		 while (mm.find()) {
//		     mm.appendReplacement(sb, "dog");
//		 }
//		 mm.appendTail(sb);
//		 System.out.println(sb.toString());
		// Part Three
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.delimiter());
	}
}
