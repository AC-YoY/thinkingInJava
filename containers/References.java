package containers;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * 测试下  和GC一起的References
 * 
 * @author 建苍
 *
 */
public class References {
	//注册队列
	private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

	public static void checkQueue() {
		Reference<? extends VeryBig> inq = rq.poll();
		if (inq != null) {
			System.out.println("In queue: " + inq.get());
		}
	}

	public static void main(String[] args) {
		int size = 10;
		// Or, choose size via the command line:
		if (args.length > 0){
			size = new Integer(args[0]);
		}
		LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
		for (int i = 0; i < size; i++) {
			//在测试用的集合中添加新的SoftReference,由rq来管理
			sa.add(new SoftReference<VeryBig>(new VeryBig("Soft " + i), rq));
			System.out.println("Just created: " + sa.getLast());
			checkQueue();
		}
		LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
		for (int i = 0; i < size; i++) {
			wa.add(new WeakReference<VeryBig>(new VeryBig("Weak " + i), rq));
			System.out.println("Just created: " + wa.getLast());
			checkQueue();
		}
		SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig(
				"Soft"));
		WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig(
				"Weak"));
		System.gc();
		LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
		for (int i = 0; i < size; i++) {
			pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom " + i),
					rq));
			System.out.println("Just created: " + pa.getLast());
			checkQueue();
		}
	}
	
}
//随便造一个类测试
class VeryBig {
	private static final int SIZE = 10000;
	private long[] la = new long[SIZE];
	// 重要属性，描述哪个对象被删除了
	private String ident;
	public VeryBig(String id) {
		ident = id;
	}
	public String toString() {
		return ident;
	}
	protected void finalize() {
		System.out.println("Finalizing " + ident);
	}
}