package typeInfo;
/**
 * Class的方法集合
 * get类:
 * 	getName/getSimpleName/getCanonicalName
 * 	getInterface/getSuperClass
 * is类：
 * 	isInterface
 * 
 * @author 建苍
 *
 */
public class ToyTest {
	public static void main(String[] args) {
		//Part1. Class的基本get方法
		Class c = null;
		try{
			c = Class.forName("typeInfo.FToy");
		}catch(ClassNotFoundException e){
			System.out.println("Can't find FToy.class.");
			System.exit(1);
		}
		printClass(c);		System.out.println();
		
		//Part2. 接口也是一个类！,也测试一下它
		for(Class Interface:c.getInterfaces()){
			printClass(Interface);
		}
		System.out.println();
		
		//Part3. 如何在类型未知 的情况下去 new对象
		Class father = c.getSuperclass();
		Object obj = null;
		try{
			//！！！！！！！！！！！！！！！
			obj = father.newInstance();
		}catch(InstantiationException e){
			System.out.println("Can't instantiate");
			System.exit(1);
		}catch(IllegalAccessException e){
			System.out.println("Can't access");
			System.exit(1);
		}
		//!!!我们这里obj是一个Object，要打印的是类信息
		printClass(obj.getClass());
	}
	
	//把class打印出来看看呗
	static void printClass(Class cl){
		System.out.println("Class Name: "+cl.getName());
		System.out.println("Is interface? ["+cl.isInterface()+"]");
		//这是不含包的名字
		System.out.println("Simple Name: "+cl.getSimpleName());
		//完全限定名 -- 含包
		System.out.println("Canonical Name: "+cl.getCanonicalName());
	}
	
}
//三个接口一个父类
interface HasB{}
interface WaterProof{}
interface Shoots{}
class Toy{
	public Toy(){}
	public Toy(int i){}
}
//子类 继承上述全部，用来测试
class FToy extends Toy implements HasB,WaterProof,Shoots{
	FToy(){super(1);}
}