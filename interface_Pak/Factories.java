package interface_Pak;

public class Factories {
	public static void serviceConsumer(ServiceFactory fact){
		Service s = fact.getService();
		s.m1();
		s.m2();
	}
	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());
		serviceConsumer(new Implementation2Factory());
	}
}
interface Service{
	void m1();
	void m2();
}
interface ServiceFactory{//工厂？提供一个服务？
	Service getService();
}
class Implementation1 implements Service{
	public Implementation1() {}
	@Override
	public void m1() {System.out.println("Implementation1 M1");}
	@Override
	public void m2() {System.out.println("Implementation1 M2");}
}
class Implementation2 implements Service{
	public Implementation2(){}
	@Override
	public void m1() {System.out.println("Implementation2 M1");}
	@Override
	public void m2() {System.out.println("Implementation2 M2");}
}
class Implementation1Factory implements ServiceFactory{
	public Service getService(){
		return new Implementation1();
	}
}
class Implementation2Factory implements ServiceFactory{
	public Service getService(){
		return new Implementation2();
	}
}