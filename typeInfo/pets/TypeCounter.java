package typeInfo.pets;

import java.util.HashMap;

/**
 * 对class.Ref进行计数统计
 * TypeCounter本身由Map来表达最合适
 * 
 * @author 建苍
 *
 */
public class TypeCounter extends HashMap<Class<?>,Integer>{
	//总要有一个目标统计的基类
	private Class<?> baseType;
	public TypeCounter(Class<?> baseType){
		this.baseType = baseType;
	}
	
	/**
	 * 
	 * @param obj
	 */
	public void count(Object obj){
		Class<?> cls = obj.getClass();
		//不属于BaseType的子类我就不想去统计他
		if(!baseType.isAssignableFrom(cls)){
			throw new RuntimeException("SubClass");
		}
		countClass(cls);
	}
	/**
	 * 根据ClassRef来统计
	 * @param type
	 */
	public void countClass(Class<?> type){
		Integer quantity = get(type);
		put(type,quantity == null?1:(quantity+1));
		/*
		 * ！！！子类要一并计算在父类数量中！！！
		 */
		Class<?> superClass = type.getSuperclass();
		if(superClass!=null&&baseType.isAssignableFrom(superClass)){
			countClass(superClass);
		}
		
	}
	
	public String toString(){
		
		return null;
	}
}
