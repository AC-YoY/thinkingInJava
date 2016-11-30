package generic;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		//一旦被初始化，数组就被定性了，只能放置子类型
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple();
//		fruit[1] = new Fruit();
		fruit[2] = new Jonathan();
//		fruit[3] = new Orange();
		
		//我们尝试用泛型来创造一个集合
		//泛型的一大作用就是，将运行期的错误提前的编译期
//		List<Fruit> list2 = new ArrayList<Apple>();
		List<? extends Fruit> list = new ArrayList<Apple>();
//		list.add(new Apple());
//		list.add(new Fruit());
		
		//放置类型标签 更加常用
		Hold hold = new Hold(Fruit.class);
		System.out.println(hold.getT());
		//放置对象也是可以的
		Hold hold2 = new Hold(new Fruit());
		System.out.println(hold2.getT());
		
	}
}

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit{}


class Hold<T>{
	public T value;
	public Hold(){}
	public Hold(T t){value=t;}
	public void set(T val){value = val;}
	public T getT(){return value;}
	public boolean equals(Object obj){
		return value.equals(obj);
	}
	
}