package enumeration;
/**
 * 对enum对象进行一定的描述，
 * 以便我们可以识别他们
 * 
 * @author 建苍
 *
 */
public enum EnumApple {
	//一定要先定义成员吗？！
	A("I'm Apple A"),
	B("I'm Apple B"),
	C("I'm Apple C");
	
	private String description;
	//Constructor must be invisible
	private EnumApple(String desc){
		description = desc;
	}
	//这是为了协助toString()
	public String getDescription(){
		return description;
	}
	
	public static void main(String[] args) {
		for(EnumApple ea : EnumApple.values()){
			System.out.println(ea+" : "+ea.getDescription());
		}
	}
}
