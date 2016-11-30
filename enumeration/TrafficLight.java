package enumeration;
/**
 * switch/case 和 enum 是绝配
 * 这里是测试
 * 
 * @author 建苍
 *
 */
public class TrafficLight {
	Signal color = Signal.Red;
	public void change(){
		switch(color){
		//Attention!!! 虽然没有static import 
		//也可以直接使用元素Green/Red/Yellow
		case Green: color = Signal.Red;
			break;
		case Red: color = Signal.Yellow;
			break;
		case Yellow: color = Signal.Green;
			break;
		}
	}
	public static void main(String[] args) {
		TrafficLight tl = new TrafficLight();
		for(int i=0;i<5;i++){
			System.out.println(tl);
			tl.change();
		}
	}
	//这个是作为一个class来说的toString，与enum本身无关
	public String toString(){
		return "TraffLight：" + color;
	}
	
}
enum Signal{
	//所以其实不必 完全定义成 大写也是可以的
	//但是一般来说习惯将静态变量完全大写
	Green,Red,Yellow;
}