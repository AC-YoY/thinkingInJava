package enumeration;
/**
 * 测试 pragmatic Util
 * 
 * @author 建苍
 *
 */
public class TestEnums {
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.print(Enums.random(Activity.values())+" ");
		}
		System.out.println("\n --Now the next method!--");
		for(int i=0;i<10;i++){
			System.out.print(Enums.random(Activity.class)+" ");
		}
		System.out.println("\n"+Activity.class);
	}
}
enum Activity{
	//OK I'm lazy
	A,B,C,D,E,F,G,H,I,J;
}