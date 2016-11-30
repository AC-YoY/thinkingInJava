package strings;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Matcher
 * 
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
 * matches(): entire sequence 
 * lookingAt():first subsequence 
 * find(): next subSequence
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * Pattern.split(String s,int i)
 * i means most array parts split into  
 * 
 * @author 建苍
 * 
 */
public class MatcherDemo {
	public static void main(String[] args) {
		// Pattern p = Pattern.compile("\\{");
		// Matcher m = p.matcher("AA{Hello}");
		//
		// System.out.println(m.lookingAt());

		
		String input = "This!!unusual use!!of exclamation!!points";
		//3 times applies
		System.out.println(Arrays.toString(
				Pattern.compile("!!").split(input)));
		//if we let it split into 3 parts
		System.out.println(
				Arrays.toString(Pattern.compile("!!").split(input, 3)));
	}
}
