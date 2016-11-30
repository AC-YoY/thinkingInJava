package generic;


/**
 * generics 特点 
 * infinite recursion
 *  
 * @author 建苍
 *
 */
public class BasicHolderDemo extends BasicHolder<BasicHolderDemo>{

	public static void main(String[] args) {
		BasicHolderDemo st1 = new BasicHolderDemo(), st2 = new BasicHolderDemo();
	    st1.set(st2);
	    BasicHolderDemo st3 = st1.getT();
	    st1.f();
	    
	    BasicHolder bh = new BasicHolder();
	    bh.set(new Other());
	    bh.f();
	}
	
}
//这个持有类将保存自身的泛型
class BasicHolder<T> {
	T element;
	void set(T t) {
		this.element = t;
	}
	T getT() {
		return element;
	}
	void f() {
		System.out.println(element.getClass().getSimpleName());
	}
}
class Other{}
class BasicOther extends BasicHolder<Other> {}
