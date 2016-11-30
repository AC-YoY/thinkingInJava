package object;

public class test {
	public static void main(String[] args) {
		Integer i = new Integer(2);
		int j = i.intValue();
		System.out.println(j);

		float f = 1.23e+6f;
		System.out.println(f);
		long in =  (long) f;
		System.out.println(in);
	}
}
