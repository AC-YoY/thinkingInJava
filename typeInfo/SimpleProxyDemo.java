package typeInfo;

public class SimpleProxyDemo{
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}
/**
 * 没有接口你造什么类
 * 注意！不能降低接口中方法的可见度
 * @author 建苍
 */
interface Interface{
	void doSomething();
	void somethingElse(String args);
}
//实现了该接口的一个基本类
class RealObject implements Interface{
	@Override
	public void doSomething(){System.out.println("dosomething");}
	@Override
	public void somethingElse(String args){System.out.println("SomethingElse："+args);}
}
//这是一个基本代理方法
class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied){
		this.proxied = proxied;
	}
	@Override
	public void doSomething() {
		System.out.println("SimpelProxy.doSomething");
		// target: invoke underlying method
		proxied.doSomething();
	}
	@Override
	public void somethingElse(String args) {
		System.out.println("SimpleProxy.somethingElse"+args);
		proxied.somethingElse(args);
	}
}