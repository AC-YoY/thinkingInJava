package enumeration;
import static enumeration.Outcome.Draw;
import static enumeration.Outcome.Lose;
import static enumeration.Outcome.Win;

public enum RoshamBo2 implements Competitor<RoshamBo2>{
	/**
	 * 这里的调用的是构造器,写入Enum的顺序
	 * 直接决定了与指定对象比较的结果
	 */
	PAPER(Draw,Lose,Win),
	SCISSORS(Win,Draw,Lose),
	ROCK(Lose,Win,Draw);
	//这里设定三个参数是为了比较的结果
	private Outcome vPAPER, vSCISSORS, vROCK;
	RoshamBo2(Outcome paper, Outcome scissors,Outcome rock) {
		vPAPER = paper;
		vSCISSORS = scissors;
		vROCK = rock;
	}
	/**
	 * 这里其实是第二次分发，确定的是被比较的对象的实际类型
	 */
	public Outcome compete(RoshamBo2 it){
		switch(it){
			default:
			case PAPER: return vPAPER;
			case SCISSORS: return vSCISSORS;
			case ROCK: return vROCK;
		}
	}
	public static void main(String[] args) {
//		System.out.println(Enums.random(RoshamBo2.class));
		RoshamBo.play(RoshamBo2.class,10);
	}
	
}
