package reusing;

public class FinalDemo3 {
	public static void main(String[] args) {
		FinalDemo3 finalDemo3 = new FinalDemo3();
		finalDemo3.test(new AAA());
	}
	
	void test(final AAA a){
		a.u="aaa";
		a.x=12;
		a.setV("i'm V");
		a.setY(32);
		System.out.println(a);
	}
}
class AAA{
	//constant
	public int x =1;
	private int y = 1;
	//reference
	public String u = "";
	private String v = "";
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	@Override
	public String toString() {
		return "AAA [x=" + x + ", y=" + y + ", u=" + u + ", v=" + v + "]";
	}
	
	
	
}