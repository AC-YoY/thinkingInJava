package innerClass;

public class Parcel9 {
	public static void main(String[] args) {
		Parcel9 parcel9 = new Parcel9();
		Wrapping w = parcel9.wrapping(10);
		System.out.println(w.value());
	}
	
	public Wrapping wrapping(final int x){
		return new Wrapping(x){
			private int i = x; 
			
		};
	}
	
}
class Wrapping {
	private int i;
	public Wrapping(int x){i = x;}
	public int value(){return i;}
}