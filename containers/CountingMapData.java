package containers;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/**
 * 实现一个Map?
 * 别忘了 CountingMapData 本身就是一个Map
 * 
 * @author 建苍
 *
 */
public class CountingMapData extends AbstractMap<Integer,String>{
	
	private int size;
	//所以说他内部用了一个数组来存放数据？  需要数据的时候就去调用它？
	private static String[] chars = "qwertyuiopasdfghjklzxcvbnm".split("");
	
	public CountingMapData(int size){
		this.size = size;
	}
	/**
	 * 这边是一个enclosing class --> Map.Entry
	 * @author 建苍
	 *
	 */
	private static class Entry implements Map.Entry<Integer, String>{
		int index;
		Entry(int index){this.index = index;}
		public boolean equals(Object o){
			return Integer.valueOf(index).equals(o);
		}
		
		@Override
		public Integer getKey() {
			return index;
		}
		@Override
		public String getValue() {
			return chars[index%chars.length]+Integer.toString(index/chars.length);
		}
		//我是只读的！！！
		@Override
		public String setValue(String value) {
			throw new UnsupportedOperationException("hehe");
		}
		public int hashCode(){
			return Integer.valueOf(index).hashCode();
		}
	}
	//这是AbstractMap  必须要实现的方法
	public Set<Map.Entry<Integer, String>> entrySet(){
		Set<Map.Entry<Integer, String>> entries = 
				new LinkedHashSet<Map.Entry<Integer,String>>();
		for(int i=0;i<size;i++){
			entries.add(new Entry(i));
		}
		return entries;
	}
	
	public static void main(String[] args) {
		System.out.println(new CountingMapData(60));
	}
}
