package initialization;
/**
 * what's the difference?
 * @author 建苍
 *
 */
public class NewVarArray {
	public static void main(String[] args) {
//		printArr(12,23L,23F);
		printArr((Object[])new Integer[]{1,2,3,4,});
		printArr2((Object[])new Integer[]{1,2,3,4,});
	}
	static void printArr(Object...objects){
		for(Object obj:objects){
			System.out.print(obj+"");
			System.out.println();
		}
	}
	static void printArr2(Object[] objects){
		for(Object obj:objects){
			System.out.print(obj+"");
			System.out.println();
		}
	}
}
