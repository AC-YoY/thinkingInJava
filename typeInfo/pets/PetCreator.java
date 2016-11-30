package typeInfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
	private Random random = new Random();
	// 继承的类要实现获得  类引用 List的方法 , 提供ClassRef集合
	public abstract List<Class<? extends Pet>> types();
	// 根据 classRef List 随机创建一个  对象
	public Pet randomPet(){
		int n = random.nextInt(types().size());
		try {
			return types().get(n).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 创建 一个 instance array
	public Pet[] createArray(int size){
		Pet[] result = new Pet[size];
		for(int i=0;i<size;i++){
			result[i] = randomPet();
		}
		return result;
	}
	// 将Array 填充进 List 中去
	public ArrayList<Pet> arrayList(int size){
		ArrayList<Pet> result = new ArrayList<Pet>();
		Collections.addAll(result, createArray(size));
		return result;
	}
	
}
