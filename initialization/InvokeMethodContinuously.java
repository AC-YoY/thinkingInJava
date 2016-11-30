package initialization;

public class InvokeMethodContinuously {

	public static void main(String[] args) {
		C c = new C();
		
		c.increase().increase().increase();
		System.out.println(c.x);
	}

}
class C{
	//  assigned 0 when initialize
	public int x;
	
	public C increase(){
		x++;
		// so u can invoke this method continuously
		return this;
	} 
}
