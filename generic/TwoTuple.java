package generic;

public class TwoTuple<K,V> {

	private K k;
	private V v;
	
	public TwoTuple() {
		super();
	}

	public TwoTuple(K k,V v) {
		this.k = k;
		this.v = v;
	}

	@Override
	public String toString() {
		return "TwoTuple [k=" + k + ", v=" + v + "]";
	}
	
}
