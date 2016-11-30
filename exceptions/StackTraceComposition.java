package exceptions;

public class StackTraceComposition {
	public static void main(String[] args) {
		
		try{
			throw new Exception("HeHe!");
		}catch(Exception e){
			System.out.println("I wanna test all exception getMethods inherited from throwable");
			// getCause返回值是throwbale的对象，不是String
			System.out.println("e.getCause():"+e.getCause());
			System.out.println("e.getMessage():"+e.getMessage());
			System.out.println("e.getLocalizedMessage():"+e.getLocalizedMessage());
			System.out.println("e.toString():"+e.toString());
			e.printStackTrace();
		}
		
	}
}
