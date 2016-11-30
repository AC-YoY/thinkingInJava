package enumeration;

import java.util.Random;

/**
 * 建造一个 pragmatic Util
 * 用来随机生成一个 Enum中的元素
 * @author 建苍
 *
 */
public class Enums {
	private static Random random = new Random();
	/**
	 * 需要传入 Enum.values()参数
	 * @param values 
	 * @return
	 */
	public static <T> T random(T[] values){
		return values[random.nextInt(values.length)];
	}
	/**
	 * 这个参数直接传入类名即可
	 * 增加泛型是为了保证不会返回null出异常
	 * @param ec
	 * @return
	 */
	public static <T extends Enum<T>> T 
		random(Class<T> ec){
		return random(ec.getEnumConstants());
	}
}
