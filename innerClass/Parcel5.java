package innerClass;
/**
 * 这个类用来展示定义在
 * 方法中作用域的内部类
 * @author 建苍
 *
 */
public class Parcel5 {
	//方法     返回实现接口 的对象
	public Destination destination(String s){
		//内部类
		class PDestination implements Destination {
			private String label;
			
			private PDestination(String whereTo){
				label = whereTo;
			}
			@Override
			public String readLine() {
				return label;
			}
			
		}
		
		return new PDestination(s);
	}
	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		Destination d = p.destination("SSS");
	}
}
