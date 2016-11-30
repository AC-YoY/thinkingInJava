package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListOfInt {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add(i);
		}
		for(int x:list){
			System.out.println(x);
		}
		
		Byte[] bytes = {1,2,3,4,5,6,7,8,9};
		Collection c = Arrays.asList(bytes);
		Set<Byte> mySet = new HashSet<Byte>(c);
		System.out.println(mySet);
		
		//LoaderFactor 0.75
//		HashSet<Byte> nextSet = new HashSet<Byte>(
//				Collections.fill(c , 12));
		
	}
}
