package containers;


public class TestDemo {
	public static void main(String[] args) {
//		A a1 = new A(1), a2 = new A(2);
//		A[] array = { a1, a2 };
//		Collection<A> c = Arrays.asList(array);
//		System.out.println(c);
//		a1.setValue(3);
//		System.out.println(c);
		
//		Queue<Integer> q = new LinkedList<Integer>();
//		for(int i=0;i<10;i++){
//			System.out.println(q.offer(i));
//		}
//		System.out.println(q.poll());
//		System.out.println(q.poll());
//		if(q.remove()!=null){
//			System.out.println("AA");
//		}
		
//		Random random = new Random(47);
//		boolean b;
//		for(int i=0;i<10;i++){
//			//assign has the last priority
//			b = random .nextDouble() >0.5;
//			System.out.println(b);
//		}
		
//		for(int i=0;i<10;i++){
//			A a = new A(1);
//			System.out.println(a);
//			System.out.println(a.hashCode());
//		}
		
//		String  s = "SB";
//		String s2 = "";
//		s2+='S';
//		s2+='B';
//		System.out.println(s.hashCode());
//		System.out.println(s2.hashCode());
//		String str = Test.class.getSimpleName();
//		System.out.println(str);
//		String str2 = "Test1";
//		System.out.println(str.compareTo(str2));
		String s = "020";
		int i = Integer.decode(s);
		System.out.println(i);
		
	}
}

class A {
	private int value = 0;

	public A(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "A [value=" + value + "]";
	}
	
}