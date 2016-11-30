package reusing;

public class FinalDemo2 {
	private final int i = 0;
	private final int j;
	private final Poppet p;
	
	public FinalDemo2(){
		j = i;
//		p = new Poppet(1);
	}
	public FinalDemo2(int k){
		j = k;
//		p = new Poppet(k);
	}
	
	{
		p = new Poppet(10);
	}
	
	public static void main(String[] args) {
		FinalDemo2 finalDemo2 = new FinalDemo2();
		FinalDemo2 finalDemo22 = new FinalDemo2(3);
		
	}
	
}

class Poppet{
	private int i;
	Poppet(int ii){
		i=ii;
	}
}