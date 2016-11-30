package typeInfo;

import java.util.Random;

public class ClassInitializaion {
	public static void main(String[] args)throws Exception{
		/*
		 * 在这里给了initable一个类的引用，并没有对他
		 * 进行任何的操作以及资源的调用，所以也不会引起任何一步
		 * 的初始化
		 */
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		//1 final数据类没有初始化
		System.out.println(Initable.staticFinal1);
		//2 必然要初始化
		System.out.println(Initable.staticFinal2);
		//3 和1相比，final数据是与类一同加载的，不需要初始化
		System.out.println(Initable2.staticNotFinal);
		System.out.println();
		//用class.forName()是触发初始化的
		Class initable3 = Class.forName("typeInfo.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNotFinal);
	}
	public static Random rand = new Random(47);
	
	
}

class Initable{
	// Be careful it's final
	static final int staticFinal1 = 11;
	static final int staticFinal2 = 
			ClassInitializaion.rand.nextInt(1000);
	static{
		System.out.println("Initializing Initable1");
	}
}
class Initable2{
	static int staticNotFinal = 129;
	static{
		System.out.println("Initializing Initalbe2");
	}
}
class Initable3{
	static int staticNotFinal = 29;
	static {
		System.out.println("Initializing Initable3");
	}
}

