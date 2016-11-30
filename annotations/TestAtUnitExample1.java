package annotations;
import org.junit.Test;
/**
 * 使用继承来测试
 * AtUnitExample1的方法
 * @author 建苍
 * 
 */
public class TestAtUnitExample1 extends AtUnitExample1{
	@Test
	public void m1(){
		System.out.println(methodOne().equals("This is MethodOne"));		
	}
	@Test
	public void m2(){
		System.out.println(methodTwo() == 2);
	}
}
