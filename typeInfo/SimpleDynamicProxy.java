package typeInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 利用反射实现一个 类/方法 的代理
 * 
 * @author 建苍
 *
 */
public class SimpleDynamicProxy {
	/**
	 * 每个动态代理中都需要去实现一次，
	 * 以提供调用方法入口
	 * 
	 * @param iface
	 */
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		// Attention!!!!
		Interface proxy = (Interface) Proxy.newProxyInstance(
				Interface.class.getClassLoader(),
				new Class[]{Interface.class},
				new DynamicProxyHandler(real));
		consumer(proxy);
		
	}
	
}
class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;
	public DynamicProxyHandler(Object proxied){
		this.proxied = proxied;
	}
	//代理动作
	@Override
	public Object invoke(Object proxy, Method mtd, Object[] args)
			throws Throwable {
		System.out.println("**** Proxy:"+proxy.getClass()+
				",Method:"+mtd+",args:"+args);
		if(args != null){
			for(Object obj:args){
				System.out.println(" "+obj);
			}
		}
		return mtd.invoke(proxied, args);
	}
}

