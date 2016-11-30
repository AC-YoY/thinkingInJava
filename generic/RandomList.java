package generic;

import java.util.ArrayList;
import java.util.Random;
/**
 * 辣鸡测试
 * @author 建苍
 *
 * @param <T>
 */
public class RandomList<T> {
	public static void main(String[] args) {
		RandomList<String> randomList = new RandomList<String>();
		for(String s:"SS IR KS DD".split(" ")){
			randomList.set(s);
		}
		for(int i=0;i<5;i++){
			System.out.println(randomList.randomGet());
		}
	}
	
	
	private ArrayList<T> al = new ArrayList<T>();
	Random random = new Random();
	public void set(T t){
		al.add(t);
	}
	public T randomGet(){
		return al.get(random.nextInt(al.size()));
	}
	
}
