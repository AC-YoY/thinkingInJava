package annotations;

import net.mindview.util.OSExecute;

/**
 * 需要去测试的方法二
 * @author 建苍
 *
 */
public class AtUnitExample1 {
	public String methodOne(){
		return "This is MethodOne";
	}
	public int methodTwo(){
		return 2;
	}
//	@Test
//	public boolean m1(){
//		return methodOne().equals("This is MethodOne");		
//	}
//	@Test
//	public boolean m2(){
//		return methodTwo() == 2;
//	}
	public static void main(String[] args) {
		OSExecute.command(
			      "java net.mindview.atunit.AtUnit AtUnitExample1");
	}
}