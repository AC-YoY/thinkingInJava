package enumeration;
/**
 * how to use Food/Course?
 * 
 * @author 建苍
 *
 */
public class Meal {
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			for(Course course:Course.values()){
				//这一步是去找出enum中的enum
				Food food = course.randomSelection();
				System.out.println(food);
			}
			System.out.println("-------");
		}
	}
	
}
