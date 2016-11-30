package typeInfo.robot;

import java.util.Arrays;
import java.util.List;

public class SnowRemoveRobot implements Robot {
	private String name;

	public String name() {
		return name;
	}

	public SnowRemoveRobot(String name) {
		this.name = name;
	}

	public String model() {
		return "Sonw Remove Robot Model1";
	}

	@Override
	public List<Operation> operations() {
		// 如果要强行添加Collections.addAll()呢?
		List<Operation> list = Arrays.asList(new Operation() {
			@Override
			public String description() {
				return "clean snow";
			}

			@Override
			public void command() {
				System.out.println("Action:cleanSnow...");
			}
		}, new Operation() {
			@Override
			public String description() {
				return "clean snow2";
			}

			@Override
			public void command() {
				System.out.println("Action:cleanSnow2...");
			}
		});
		return list;
	}

	public static void main(String[] args) {
		SnowRemoveRobot sonwRemoveRobot = new SnowRemoveRobot("Type1");
		Robot.Test.test(sonwRemoveRobot);
	}

}
