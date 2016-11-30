package generic;
/**
 * 潜在类型机制
 * 提取 一个 Interface中被 其他多个 类 实现的方法
 * 做成一个  工具类  的 静态 方法
 * 
 * ** 然而 reflect可以更好地实现他
 * 
 * @author 建苍
 *
 */
public class DEMO1 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Communicate.funtion(dog);
		Communicate.funtion(cat);
	}

}
interface Animal{
	void bark();
	void sit();
}
//只能由继承来实现
class Dog implements Animal{
	public void bark(){System.out.println("Hei Here!I'm a Dog!");}
	public void sit(){}
	void MDog(){}
}
class Cat implements Animal{
	public void bark(){System.out.println("Hei There!I'm a Cat!");}
	public void sit(){}
	void MCat(){}
}
//合并两个类的方法子集，造一个工具类
class Communicate{
	public static <T extends Animal> 
		void funtion(T subAnimal){
		subAnimal.bark();
		subAnimal.sit();
	}
}