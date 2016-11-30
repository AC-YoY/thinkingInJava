package exceptions;

public class LostException {
	public static void main(String[] args) {
		LostException le = new LostException();
		//核心在与外围不做finally！？
		try{
			try{
				//no one cares me !
				throw new A();
			}finally{
				//！if SomeThing wrong here 
				throw new B();
			}
			
		}catch(Exception b){
			b.printStackTrace();
		}
		
	}
}
class A extends Exception{
	@Override
	public String toString(){
		return "Hello i'm A";
	}
}
class B extends Exception{
	@Override
	public String toString(){
		return "Hello i'm B";
	}
}