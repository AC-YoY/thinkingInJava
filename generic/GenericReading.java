package generic;

import java.util.Arrays;
import java.util.List;

/**
 * 我们会使用三种方式来读取
 * generic collection中的数据
 * 
 * 目标是：实现 covariantArray效果，
 * 自动UperCase
 * 
 * @author 建苍
 *
 */
public class GenericReading {
	//Basic method
	static <T> T readExact(List<T> list){
		return list.get(0);
	}
	//Test member
	static List<Jazz> jazz = Arrays.asList(new Jazz());
	static List<Music> music = Arrays.asList(new Music());
	
	static void f1(){
		Jazz j = readExact(jazz);
		Music m = readExact(music);
		//读取对象  再UperCase
		m = readExact(jazz);
	}
	
	static class Reader<T>{
		T readExact(List<T> list){return list.get(0);}
	}
	static void f2(){
		Reader<Music> rm = new Reader<Music>();
		Music m = rm.readExact(music);
//		这里类型也 超出边界了
//		Jazz j = rm.readExact(jazz);
	}
	//UperCase
	static class CovariantReader<T>{
		T readExact(List<? extends T> list){return list.get(0);}
	}
	static void f3(){
		CovariantReader<Music> cm = new CovariantReader<Music>();
		Music m = cm.readExact(music);
		Music j = cm.readExact(jazz);
		Jazz ja = (Jazz) cm.readExact(jazz);
	}
	
	public static void main(String[] args) {
		f1();
		f2();
		f3();
	}
}
class Music{}
class Jazz extends Music{}