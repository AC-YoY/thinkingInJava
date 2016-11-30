package innerClass;

public class MutiNestingAccess {
	public static void main(String[] args) {
		MNA mna = new MNA();
		MNA.A mnaa = mna.new A();
		MNA.A.B mnaab = mnaa.new B();
		
	}
}
class MNA{
	private void f(){}
	
	class A{
		private void g(){}
		
		public class B{
			void h(){
//				无论嵌套多少层，内部类始终可以使用外部类的资源
				g();
				f();
			}
		}
		
	}
	
}