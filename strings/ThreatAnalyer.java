package strings;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreatAnalyer {

	static String threatData =
		    "58.27.82.161@02/10/2005\n" +
		    "204.45.234.40@02/11/2005\n" +
		    "58.27.82.161@02/11/2005\n" +
		    "58.27.82.161@02/12/2005\n" +
		    "58.27.82.161@02/12/2005\n" +
		    "[Next log section with different data format]";
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(threatData);
		String pattern = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})@(\\d{2}/\\d{2}/\\d{4})";
		
		while(sc.hasNext(pattern)){
			//让pointer遍历下去
			sc.next(pattern);
			// Attention Please!!!这里Scanner.match()返回的相当于Matcher.matches()
			MatchResult m = sc.match();
			System.out.print("IP:"+m.group(1)+" ");
			System.out.println("時間:"+m.group(2));
		}
		
		
	}

}
