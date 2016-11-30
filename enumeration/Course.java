package enumeration;
/**
 * 直接用enum来存放enum
 * 
 * @author 建苍
 *
 */
public enum Course {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	//前提是有一个可以统一操作的Constructor
	private Food[] values;
	private Course(Class<? extends Food> kind){
		values = kind.getEnumConstants();
	}
	/**
	 * convenience method
	 * @return
	 */
	public Food randomSelection(){
		return Enums.random(values);
	}
}
