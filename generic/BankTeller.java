package generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * anonymous class,
 * generic
 * generator
 * 
 * 用泛型匿名内部类来写一个生成器
 * @author 建苍
 *
 */
public class BankTeller {
	public static void main(String[] args) {
		List<Banker> lb = new ArrayList<Banker>();
		Generator<Banker> gb = Banker.generator();
		Generators.fill(lb, gb, 5);
		
		List<Costomer> lc = new ArrayList<Costomer>();
		Generator<Costomer> gc = Costomer.generator;
		Generators.fill(lc, gc, 15);
		
		Random random = new Random();
//		for(int i=0;i<15;i++){
//			System.out.println(lb.get(random.nextInt(lb.size()))+" serves "+
//					lc.get(i));
//		}
		
		for(Costomer c:lc){
			serves(lb.get(random.nextInt(lb.size())),c);
		}
	}
	
	public static void serves(Banker b,Costomer c){
		System.out.println(b+" serves "+c);
	}
}
class Banker{
	private static int counter = 0;
	private final int NO = counter++;
	private Banker(){}
	public String toString(){
		return "Banker:["+NO+"]";
	}
	public static Generator<Banker> generator(){
		
		return new Generator<Banker>(){
			@Override
			public Banker next() {
				return new Banker();
			}
		};
	}
}
class Costomer{
	private static int counter = 0;
	private final int NO = counter++;
	private Costomer(){}
	public String toString(){
		return "Costomer:["+NO+"]";
	}
	
	public static Generator<Costomer> generator = new Generator<Costomer>(){
		@Override
		public Costomer next() {
			return new Costomer();
		}
	};
}
