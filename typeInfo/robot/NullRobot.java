package typeInfo.robot;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;
/**
 * 想要用NullRobot来自动生成新对象
 * @author 建苍
 *
 */
public class NullRobot {
	public static void main(String[] args) {
		Robot[] robots = {
				new SnowRemoveRobot("SillyB"),
				newNullRobot(SnowRemoveRobot.class)};
		for(Robot r:robots){
			Robot.Test.test(r);
		}
	}
	//为什么这个dynamic方法用来生成类？不是干别的
	public static Robot newNullRobot
			(Class<? extends Robot> type){
		return (Robot)Proxy.newProxyInstance(
				NullRobot.class.getClassLoader(), 
				//因为NRobot实现了两个interface
				new Class[]{Null.class,Robot.class}, 
				//传入什么类就生成什么类的对象
				new NullRobotProxyHandler(type));
	}
}
class NullRobotProxyHandler implements InvocationHandler{
	private String nullName;
	private Robot proxied = new NRobot();
	//这个构造器很有意思。根据计划生成的 类引用来生成名字
	NullRobotProxyHandler(Class<? extends Robot> type) {
		nullName = type.getSimpleName()+"NullRobot";
	}
	/**
	 * 这个NRobot是空对象，专门用来填空
	 * @author 建苍
	 *
	 */
	private class NRobot implements Null,Robot{
		public String name() {return nullName;}
		public String model() {	return nullName;}
		public List<Operation> operations() {
			return Collections.emptyList();
		}
	}
	//说是处理方法请求，其实什么动作都没做
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(proxy, args);
	}
}