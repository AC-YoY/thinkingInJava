package arrays;

public class ParameterizedArrayType {

}

class ClassParameter<T> {
	
	public T[] f(T[] array) {
		return array;
	}
	
	//这本质上是一个参数化方法，并非参数化类
	public static <D> D[] f2(D[] array) {
		return array;
	}
	//这也是一个参数化方法
	public <A> A[] f3(A[] array){
		return array;
	}
	
}
class MethodParameter{
	public static <T> T[] f(T[] array){
		return array;
	}
}