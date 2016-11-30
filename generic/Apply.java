package generic;

import java.util.ArrayList;

public class Apply {
	public static void main(String[] args) {
		System.out.println(int.class);
	}
}
class Shape{
	public void rotate(){System.out.println(this+" rotate");}
	public void resize(int newSize){
		System.out.println(this+" resize "+newSize);
	}
}
class Square extends Shape{}
class FilledList<T> extends ArrayList<T>{
	public FilledList(Class<? extends T> type,int size){
		try{
			for(int i=0;i<size;i++){
				add(type.newInstance());
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}