package containers;

import generic.Generator;

import java.util.ArrayList;
/**
 * Util方法，用来制造一个集合
 * 需要生成器和数量
 * 
 * 有什么意义！？有Generator我不会自己造！？
 * 
 * @author 建苍
 *
 * @param <T>
 */
public class CollectionData<T> extends ArrayList<T> {
	
	public CollectionData(Generator<T> gen,int quantity){
		for(int i=0;i<quantity;i++){
			add(gen.next());
		}
	}
	// A generic convenience method.
	public static <T> CollectionData<T> 
		list(Generator<T> gen,int quantity){
		return new CollectionData<T>(gen,quantity);
	}
	
}
