package typeInfo;

import java.util.ArrayList;
import java.util.List;

public class FilledList<T> {
	private Class<T> type;
	public FilledList(Class<T> type){this.type = type;}
	
	public List<T> create(int elements){
		List<T> result = new ArrayList<T>();
		
		try{
			for(int i=0; i<elements ;i++){
				result.add(type.newInstance());
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		FilledList<CountedInteger> fl = 
				new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(fl.create(10));
	}
	
}

/**
 * 这个类将要用在泛型中
 * @author 建苍
 *
 */
class CountedInteger{
	//这组玩法真是6
	private static long counter;
	private final long id = counter++;
	public String toString(){
		return Long.toString(id);
	}
}