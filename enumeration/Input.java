package enumeration;

import java.util.Random;

/**
 * 状态机
 * @author 建苍
 *
 */
public enum Input {
	NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100), TOOTHPASTE(200), CHIPS(75), SODA(
			100), SOAP(50),

	ABORT_TRANSACTION {
		public int amount() { // Disallow
			throw new RuntimeException("ABORT.amount()");
		}
	},
	STOP { // This must be the last instance.
		public int amount() { // Disallow
			throw new RuntimeException("SHUT_DOWN.amount()");
		}
	};
	//In cents 状态机的状态
	int value; 
	Input(int value){this.value = value;}
	Input(){}
	int amount(){
		return value;
	}
	static Random random = new Random();
	public static Input randomSelection(){
		return values()
				[random.nextInt(values().length -1)];
	}
}
