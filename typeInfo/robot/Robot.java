package typeInfo.robot;

import java.util.List;

/**
 * 机器人的接口，为什么不直接用一个类来实现！？
 * @author 建苍
 *
 */
public interface Robot {
	String name();
	String model();
	
	List<Operation> operations();
	
	//为了测试，使用了inner/enclosing class
	class Test{
		//待测试方法
		public static void test(Robot r){
			//直接给个空参数
			if(r instanceof Null){
				System.out.println("Null Robot");
			}
			System.out.println("Robot.name:"+r.name());
			System.out.println("Robot.model:"+r.model());
			for(Operation operation:r.operations()){
				System.out.println(operation.description());
				operation.command();
			}
		}
	}
}
