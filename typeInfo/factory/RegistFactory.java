package typeInfo.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 这个方法只是要去生产对象而已
 * @author 建苍
 *
 */
public class RegistFactory {
	public static void main(String[] args) {
		for(int i=0;i<8;i++){
			System.out.println(Part.createRandom());
		}
	}
}
/**
 * 这个类是所有类的基类
 * 内部维护一个集合，用来存放所有子类的对象
 * 
 * 
 * @author 建苍
 *
 */
class Part{
	public String toString() {
	    return getClass().getSimpleName();
	}
	/*
	 * Q1.为什么是Factory<T> : 这就是创建这个接口的目的
	 * 		实现同一个方法可以返回不同的对象 
	 */
	static List<Factory<? extends Part>> list = 
			new ArrayList<Factory<? extends Part>>();
	static{
		//为了要让所有目标子类对象都自动初始化，new一个对象
		list.add(new FuelFilter.Factory());
		list.add(new AbcBelt.Factory());
		
	}
	
	private static Random random = new Random();
	
	public static Part createRandom() {
		int n = random.nextInt(list.size());
		return list.get(n).create();
	}
}

class Filter extends Part{}

class FuelFilter extends Filter{
	//为了实现Factory，去创建了一个类，实现Factory的方法
	public static class Factory implements 
			typeInfo.factory.Factory<FuelFilter>{
		public FuelFilter create(){
			return new FuelFilter();
		}
	}
}
class Belt extends Part{}
class AbcBelt extends Belt{
	public static class Factory implements
			typeInfo.factory.Factory<AbcBelt>{
		public AbcBelt create(){
			return new AbcBelt();
		}
	}
}
