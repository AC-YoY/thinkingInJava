package containers;

import java.util.HashMap;

public class Demo1 {
	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<Integer,String>(10);
		System.out.println(map.size());
		map.put(1, "Hehe");
		System.out.println(map.size());
		
	}
}
