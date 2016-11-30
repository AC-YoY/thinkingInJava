package innerClass;

public class Demo {
	
	private class sonDestination implements Destination{
		private String line;
		@Override
		public String readLine() {
			return line;
		}
		
		private sonDestination(String str){
			line = str;
		}
		
	}
	
	public sonDestination getSondestination(String s){
		return new sonDestination(s);
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		//本类中，所以可以用吧
		sonDestination s = demo.getSondestination("sss");
		//UpperCase 
		Destination d = demo.getSondestination("SSS");
		
	}
	
}
