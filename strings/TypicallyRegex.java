package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypicallyRegex {
	public static void main(String[] args) {
		//把你想要执行的regex编译成一个pattern
		Pattern p = Pattern.compile("\\d+");
		//用pattern生成一个 Macther比较器
		Matcher m = p.matcher("mm123456");
		//用Matcher来比较！
		System.out.println(m.matches());
	}
}