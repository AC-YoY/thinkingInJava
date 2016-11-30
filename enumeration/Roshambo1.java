package enumeration;
import static enumeration.Outcome.Draw;
import static enumeration.Outcome.Lose;
import static enumeration.Outcome.Win;

import java.util.Random;

public class Roshambo1 {
	public static void main(String[] args) {
		for(int i=0;i<SIZE;i++){
			match(newItem(),newItem());
		}
	}
	
	public static void match(Item a,Item b){
		System.out.println(a+" VS."+b+": "+a.compete(b));
	}
	static final int SIZE = 10;
	private static Random random = new Random();
	public static Item newItem(){
		switch(random.nextInt(3)){
		default:
		case 0:return new Scissors();
		case 1:return new Paper();
		case 2:return new Rock();
		}
	}
	
}
interface Item{
	//这个方法完全是为了上转型方便而添加的
	Outcome compete(Item it);
	Outcome eval(Paper p);
	Outcome eval(Scissors s);
	Outcome eval(Rock r);
}
class Paper implements Item{
	//为了上转型 要牺牲逻辑，这里的比较否是反向比较的
	public Outcome compete(Item it){return it.eval(this);};
	public Outcome eval(Paper p){return Draw;};
	public Outcome eval(Scissors s){return Win;};
	public Outcome eval(Rock r){return Lose;}
	@Override
	public String toString() {
		return "Paper";
	};
	
}
class Scissors implements Item{
	public Outcome compete(Item it){return it.eval(this);};
	public Outcome eval(Paper p){return Lose;};
	public Outcome eval(Scissors s){return Draw;};
	public Outcome eval(Rock r){return Win;}
	@Override
	public String toString() {
		return "Scissors";
	};
	
}
class Rock implements Item{
	public Outcome compete(Item it){return it.eval(this);};
	public Outcome eval(Paper p){return Win;};
	public Outcome eval(Scissors s){return Lose;};
	public Outcome eval(Rock r){return Draw;}
	@Override
	public String toString() {
		return "Rock";
	};
	
}