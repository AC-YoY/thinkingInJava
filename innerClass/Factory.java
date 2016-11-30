package innerClass;

public class Factory {

	public static void main(String[] args) {
		ServiceConsumer(new Implementation1Factory());
		ServiceConsumer(new Implementation2().serviceFactory);
	}
	public static void ServiceConsumer(ServiceFactory sf){
		Service s = sf.getService();
		s.Method1();
		s.Method2();
	}
	

}
interface Service{
	void Method1();
	void Method2();
}
interface ServiceFactory{
	Service getService();
}
////////////////////////////////////////////////////////////
class Implementation1 implements Service{
	public void Method1(){
		System.out.println("Implementation1 M1");
	}
	public void Method2(){
		System.out.println("Implementation1 M2");
	}
}
class Implementation1Factory implements ServiceFactory{
	@Override
	public Service getService() {return new Implementation1();}
}
////////////////////////////////////////////////////////////
class Implementation2 implements Service{
	public void Method1(){System.out.println("Implementation2 M1");}
	public void Method2(){System.out.println("Implementation2 M2");}
	//核心就这两句话
	public static ServiceFactory serviceFactory = new ServiceFactory(){
		public Service getService(){
			return new Implementation2();
		}
	};
}