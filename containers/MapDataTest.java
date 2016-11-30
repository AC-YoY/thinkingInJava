package containers;

import generic.Generator;

import java.util.Iterator;

import arrays.RandomGenerator;

/**
 * 测试一下MapData的用法
 * 
 * 
 * @author 建苍
 *
 */
public class MapDataTest {
	public static void main(String[] args) {
		System.out.println(MapData.map(new Letters(), 11));
		System.out.println(
				MapData.map(new RandomGenerator.Character(),
						new RandomGenerator.String(3),8)
		);
	}
	
	
}
class Letters implements Generator<Pair<Integer,String>>,
	Iterable<Integer>{
	private int size = 9;
	private int number = 1;
	private char letter = 'A';
	
	@Override
	public Pair<Integer, String> next() {
		return 
			new Pair<Integer,String>(number++,""+letter++);
	}
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>(){
			public Integer next(){
				return number++;
			}
			public boolean hasNext() {
				return number<size;
			}
		};
	}
	
}