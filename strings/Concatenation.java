package strings;

import java.util.Random;

public class Concatenation {
	public static void main(String[] args) {
		String str="SSSshumm";
		str+="DS";
		str+='d';
		System.out.println(str);
		
		StringBuilder sb = new StringBuilder("0123456789");
		System.out.println(sb.length());
		//你为什么不越界！？
//		sb.delete(2, 4);
		sb.delete(sb.length()-1, sb.length()+10);
		System.out.println(sb);
		
		System.out.println(getString());
	}
	
	public static String getString(){
		Random random = new Random();
		StringBuilder sb = new StringBuilder("[");
		for(int i=0;i<20;i++){
			sb.append(random.nextInt(100));
			sb.append(",");
		}
		sb.delete(sb.length()-1, sb.length());
		sb.append("]");
		return sb.toString();
	}
	
}
