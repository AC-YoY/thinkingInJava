package enumeration;
/**
 * 配合Roshambo2
 * 
 * 
 * @author 建苍
 *
 */
public class RoshamBo {
	/**
	 * 这里是第一次实际的方法调用 来分发资源。
	 * @param a
	 * @param b
	 */
	public static <T extends Competitor<T>> void match(T a,T b){
		System.out.println(
				a+" VS:"+b+": "+a.compete(b));
	}
	public static <T extends Enum<T> & Competitor<T>> 
		void play(Class<T> rsbClass,int size){
		for(int i=0;i<10;i++){
			match(Enums.random(rsbClass),Enums.random(rsbClass));
		}
	}
}
