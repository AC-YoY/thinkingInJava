package typeInfo.pets;

import java.util.ArrayList;
import java.util.List;
/**
 * 一个实现了PetCreateor的子类
 * @author 建苍
 *
 */
public class ForNameCreator extends PetCreator{
	//创建 一个静态对象用于返回
	private static List<Class<? extends Pet>> types =
			new ArrayList<Class<? extends Pet>>();
	/*
	 *  Types that you want to be randomly created
	 */
	private static String[] typeNames = {
		"typeinfo.pets.Mutt",
	    "typeinfo.pets.Pug",
	    "typeinfo.pets.EgyptianMau",
	    "typeinfo.pets.Manx",
	    "typeinfo.pets.Cymric",
	    "typeinfo.pets.Rat",
	    "typeinfo.pets.Mouse",
	    "typeinfo.pets.Hamster"
	};
	
	@SuppressWarnings("unchecked")
	private static void loader(){
		for(String s:typeNames){
			try {
				/*
				 * 这里需要添加的是Class的引用，
				 * 而types只是String,需要获得ClassRef
				 */
				types.add((Class<? extends Pet>) 
						Class.forName(s));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	static{
		loader();
	}
	//PetCreator的方法实现，直接返回静态值
	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}
}
