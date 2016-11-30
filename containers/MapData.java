package containers;

import generic.Generator;

import java.util.LinkedHashMap;

/**
 * 利用Generator
 * 生成一个Map
 * 
 * 类中包含静态类
 * 这是什么设计模式
 * 
 * @author 建苍
 *
 */
public class MapData<K,V> extends LinkedHashMap<K,V> {
	public MapData(Generator<Pair<K,V>> gen,int quantity){
		for(int i=0;i<quantity;i++){
			Pair<K,V> p = gen.next();
			put(p.key,p.value);
		}
	}
	public MapData(Generator<K> genK,Generator<V> genV,int quantity){
		for(int i=0;i<quantity;i++){
			put(genK.next(),genV.next());
		}
	}
	public MapData(Generator<K> genK,V value,int quantity){
		for(int i=0;i<quantity;i++){
			put(genK.next(),value);
		}
	}
	//迭代器
	public MapData(Iterable<K> genK,Generator<V> genV){
		for(K key:genK){
			put(key,genV.next());
		}
	}
	public MapData(Iterable<K> genK,V value){
		for(K key:genK){
			put(key,value);
		}
	}
	//Generic Convenience Methods
	public static <K,V> MapData<K,V> 
		map(Generator<Pair<K,V>> gen,int quantity){
		return new MapData<K,V>(gen,quantity);
	}
	public static <K,V> MapData<K,V> 
		map(Generator<K> genK,Generator<V> genV,int quantity){
		return new MapData<K,V>(genK,genV,quantity);
	}
	public static <K,V> MapData<K,V> 
		map(Generator<K> genK,V value,int quantity){
		return new MapData<K,V>(genK,value,quantity);
	}
	public static <K,V> MapData<K,V>
		map(Iterable<K> iteK,Generator<V> genV){
		return new MapData<K,V>(iteK,genV);
	}
	public static <K,V> MapData<K,V>
		map(Iterable<K> iteK,V value){
		return new MapData<K,V>(iteK,value);
	}
}
