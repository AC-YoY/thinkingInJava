package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * 基本的集合数组转换!!!!
 * 
 * @author 建苍
 *
 */
public class AddingGroups {
	public static void main(String[] args) {
		//数组转换集合
		Collection<Integer> collections = new ArrayList<Integer>(Arrays.asList(1,2,3));
		collections.add(0);
		System.out.println(collections);
		Integer[] inte = {4,5,6};
		//集合全添加集合 辣鸡方法 只能集合添加集合
		collections.addAll(Arrays.asList(inte));
		System.out.println(collections);
		//集合添加数组
		Collections.addAll(collections, 0,0);
		Collections.addAll(collections, inte);
		System.out.println(collections);
		//注意！数组转换成的集合是不能变动的
		List<Integer> list = Arrays.asList(1,2,3);
//!		list.add(2);
		list.set(0,88);
		System.out.println(list);
		
	}
}
