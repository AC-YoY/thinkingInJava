package typeInfo.factory;
/**
 * 协变返回类型
 * @author 建苍
 *
 */
public class TEST {
	public static void main(String[] args) {
		
	}
}
class Father{
	A Method(){
		return new A();
	}
}
class Son extends Father{
	@Override
	B Method(){
		return new B();
	}
}
class A{
	
}
class B extends A{
	
}