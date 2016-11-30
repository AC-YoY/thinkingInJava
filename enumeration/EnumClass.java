package enumeration;
/**
 * 对enum进行基本用法测试
 * 因为有values 使得enum更加类似于array
 * 
 * enum就像是一个类，而其中的定义的元素 就类似于composition的关系
 * 
 * @author 建苍
 *
 */
public class EnumClass {
	public static void main(String[] args) {
		//遍历的是enum本身
		for(First f : First.values()){
			//ordinal 返回定时元素的 顺序
			System.out.println(f+" ordinal:"+f.ordinal());
			//比较遵守的是  负，0，正 表示 小，等，大
			//本例中返回值正好是两者相减
			System.out.println("CompareTo:"+f.compareTo(First.B));
			System.out.println("equals："+f.equals(First.A));
			System.out.println("== ：" + (f == First.A));
			System.out.println("DeclaringClass ：" + f.getDeclaringClass());	
			System.out.println("name：" + f.name());	
			System.out.println("--------------------");
		}
	}
}
enum First{
	A,B,C;
}