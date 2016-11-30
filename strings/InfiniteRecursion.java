package strings;

import java.util.ArrayList;

public class InfiniteRecursion {

	@Override
	public String toString() {
		return "InfiniteRecursion [toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		ArrayList<InfiniteRecursion> ar = new ArrayList<InfiniteRecursion>();
		for(int i=0;i<10;i++){
			ar.add(new InfiniteRecursion());
		}
		System.out.println(ar);
	}
	
}
