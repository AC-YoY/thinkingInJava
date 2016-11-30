package enumeration;
/**
 * 用于辅助比较roshanbo2
 * 
 * 
 * @author 建苍
 *
 * @param <T>
 */
public interface Competitor <T extends Competitor<T>>{
	//上面的自限定完全是为了使得比较对象都继承自 Competitor!!!
	Outcome compete(T competitor);
}
