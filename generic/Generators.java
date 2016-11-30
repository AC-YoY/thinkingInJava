package generic;

import java.util.List;

/**
 * Util
 * 
 * @author 建苍
 * 
 */
public class Generators {
	//
	public static <T> List<T> fill(List<T> list, Generator<T> gen, int num) {
		for (int i = 0; i < num; i++) {
			list.add(gen.next());
		}
		return list;
	}
}
