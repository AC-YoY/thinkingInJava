package typeInfo.factory.factory_extend;


public class Father {
	//不能创建泛型数组，自然也不能创建泛型集合
//	static List<? extends Father> list = 
//			new LinkedList<? extends Father>();
	//有什么区别啊
	static{
//		list.add(new Son1());
//		list.add(new Son2());
	}
}
class Son1 extends Father{
	
}
class Son2 extends Father{
	
}