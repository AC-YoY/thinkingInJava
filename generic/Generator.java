package generic;
/**
 * 为了创建 生成器，区别于工厂模式，
 * 使用Generics 来决定返回类型
 * 
 * 
 * 
 * @author 建苍
 *
 * @param <T>
 */
public interface Generator<T> {
	T next();
}
