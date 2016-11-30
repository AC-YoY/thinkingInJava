package generic;
/**
 * 斐波那契数列，生产的是和！！！！
 * 单独用起来很简单。
 * 但是要实现Iterator配合适配器就很烦
 * 参见 FibonacciAdapt
 * 
 * 它自己是迭代出来的！！next是下一个而不是当前的数值
 * 
 * @author 建苍
 *
 */
public class Fibonacci implements Generator<Integer>{
	public static void main(String[] args) {
		Fibonacci fbc = new Fibonacci();
		for(int i=0;i<10;i++){
			System.out.println(fbc.next());
		}
	}
	private int count = 0;//每个对象自己维护好嘛
	private int fib(int n){
		if(n<2){
			return 1;
		}else{
			return fib(n-1)+fib(n-2);
		}
	}
	@Override
	public Integer next() {
		//返回当前值，而不是返回下一个数值，so why？
		return fib(count++);
	}
}
