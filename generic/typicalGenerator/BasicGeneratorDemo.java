package generic.typicalGenerator;


/**
 * let's see how to use the BasicGeneric
 * 请配合BasicGenerator一起看
 * 
 * @author 建苍
 *
 */
public class BasicGeneratorDemo {
	public static void main(String[] args) {
		//Method One
		//之所以这么设计，是用一个BasicGenerator类实现了Generator的功能
		//利用UperCase，可与让所有的类都用异样的办法生产
//		Generator<CreatedObject> g = 
//				BasicGenerator.create(CreatedObject.class);
//		for(int i=0;i<10;i++){
//			System.out.println(g.next());
//		}
		
		
		//Method Two
		BasicGenerator<CreatedObject> b =
				new BasicGenerator<CreatedObject>(CreatedObject.class);
		for(int i=0;i<10;i++){
			System.out.println(b.create(CreatedObject.class));
//			System.out.println(b.next());
		}
		
	}
}
