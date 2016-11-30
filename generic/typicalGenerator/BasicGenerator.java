package generic.typicalGenerator;

import generic.Generator;
/**
 * 所以这个类生产的是  生产<T>对象的生产类.........
 * BasicGenerator returns instance of Generator<T> which is a interface
 * 
 * ？？？就这样？
 * 
 * @author 建苍
 *
 * @param <T>
 */
public class BasicGenerator<T> implements Generator<T>{
	//这才是 生成器 真正 生成对象的方法
	@Override
	public T next() {
		try {
			//Q1. 想要创建的类 必须有空参 Constructor
			return type.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("反正你也到不了这儿");
	}
	//造这两个无非是要去 利用ClassRef创建对象
	private Class<T> type;
	public BasicGenerator(Class<T> type){
		this.type=type;
	}
	
	// ????????????????????????????????????
	// 为什么不直接返回一个创建好的对象？有病？
	//Method One
//	public static <T> Generator<T> 
//		create(Class<T> type){
//		return new BasicGenerator<T>(type);
//	}
	//Method Two
	public T create(Class<T> type){
		return new BasicGenerator<T>(type).next();
	}
}
