package typeInfo;
/**
 * 也就是说，泛型只能检查完全相同的部分，
 * 一旦涉及到继承，就只能使用<? super&extends Class>来实现了
 * 无法对转型的类进行详细的检查
 * 
 * @author 建苍
 *
 */
public class TestToy {
	public static void main(String[] args)throws Exception {
//		FToy fToy = new FToy();
		Class<FToy> ftoy = FToy.class;
		
		FToy ft = ftoy.newInstance();
		
		Class<? super FToy> superFToy = 
				ftoy.getSuperclass();
		
		//!!!!!!!!!!
//		Class<Toy> toy = ftoy.getSuperclass();
//		Toy toy = superFToy.newInstance();
		
		Object obj = superFToy.newInstance();
		System.out.println(obj);
	}

}
