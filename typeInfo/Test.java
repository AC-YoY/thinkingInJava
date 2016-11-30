package typeInfo;


public class Test {
	public static void main(String[] args) {
//		HashMap<Object,Integer> hm = new HashMap<Object,Integer>();
//		hm.put(new ToyTest(),1);
//		
//		HashMap<Class<?>, Integer> hashMap = new HashMap<Class<?>,Integer>();
//		// 1
//		hashMap.put((new ToyTest()).getClass(), 1);
//		// 2
//		hashMap.put(ToyTest.class, 1);
		System.out.println(
		ToyTest.class.isAssignableFrom(ToyTest.class));
		System.out.println("继承树");
		System.out.println(GrandPa.class.isAssignableFrom(Son.class));
		System.out.println(Son.class.getSuperclass());
		System.out.println(Son.class.getSuperclass().getSuperclass());
		System.out.println(Son.class.getSuperclass().getSuperclass().getSuperclass());
		System.out.println(Son.class.getSuperclass().getSuperclass().getSuperclass().getSuperclass());
//		
		System.out.println();
		GrandPa grandPa = new GrandPa();
		System.out.println("GrandPa"+grandPa.x);
		grandPa.x = 20;
		Father father = new Father();
		System.out.println("Father"+father.x);
		Son son = new Son();
		father.x =100;
		System.out.println("Son:"+son.x);
		System.out.println("LastGrandPa:"+grandPa.x);
		
		//然而java并不允许创建       泛型数组
//		Class<? extends GrandPa>[] gg = {Father.class,Son.class};
	}
}
class GrandPa {static int x=0;}
class Father extends GrandPa{}
class Son extends Father{}