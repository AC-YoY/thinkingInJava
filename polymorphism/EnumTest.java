package polymorphism;


public class EnumTest{
	public static void main(String[] args) {
		System.out.println("枚举类型测试");
		testEnum();
	}
	
	private static void testEnum(){
		Light[] alllight = Light.values();
		for(Light alight:alllight){
			System.out.println("当前灯.name:"+alight.name());
			System.out.println("当前灯.ordinal:"+alight.ordinal());
			System.out.println("当前灯:"+alight);

		}
	}
	
}

enum Light{
	RED(1),GREEN(2),YELLOW(3);
	
	private int nCode;
	
	private Light(int Code){
		this.nCode = Code;
	}
	
	
}
