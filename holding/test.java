package holding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class test {
	public static void main(String[] args) {
		ArrayList<String> al2 = new  ArrayList<String>();
		al2.add("A");
		al2.add("B");
		ArrayList<String> al = new ArrayList<String>();
		al.addAll(al2);
		al.add("C");
		al.add("D");
		System.out.println(al.contains("A"));
		System.out.println(al.indexOf(al2));
		System.out.println(al);
		
		List<String> al3 = al.subList(0, 2);
		al3.set(0, "XX");
		System.out.println(al3);
		System.out.println(al.containsAll(al3));
		System.out.println(al);
		//定义一个排序规则
		Set<String> sss = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		//使用addAll方法并不会传递引用
		ArrayList<String> ar = new ArrayList<String>();
		ar.addAll(al2);
		System.out.println(ar);
		ar.set(1, "XXX");
		System.out.println(ar);
		System.out.println(al2);
	}
}
