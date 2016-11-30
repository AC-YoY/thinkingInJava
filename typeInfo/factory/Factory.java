package typeInfo.factory;
/**
 * 这个接口目的就是为了重载create()
 * 而<T>则实现了不同子类  返回不同对象的效果
 * 
 * 实现 Factory接口的对象一方面是他的子类
 * 另一方面，他们也拥有这个接口instacne之后的对象
 * 
 * !!!Attention 非Interface还不能使用<T>
 * 因为不是generic
 * 
 * @author 建苍
 *
 * @param <T>
 */
public interface Factory<T> {
	public T create();
}
