package generic;
/**
 * so, i wanna be a util class
 * @author 建苍
 *
 */
public class Tuple {
	public static <K,V> TwoTuple<K,V> tuple(K k,V v){
		return new TwoTuple(k,v);
	}
}
