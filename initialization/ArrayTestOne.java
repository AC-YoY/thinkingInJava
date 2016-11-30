package initialization;
/**
 * how to pass Str[] to main method
 * @author 建苍
 *
 */
public class ArrayTestOne {
	public static void main(String[] args) {
//		this is wrong!!!
//		Other.main({"fiddle","heh","checkin"});
		Other.main(new String[]{"fiddle","heh","checkin"});
		  
	}
}

class Other {
	public static void main(String[] args) {
		for(String s:args){
			System.out.println(s);
		}
	}
}