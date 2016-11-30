package typeInfo;

import java.util.Arrays;
import java.util.List;

abstract class RunTimeTypeIdentificationDemo {
	public static void main(String[] args) {
		List<RunTimeTypeIdentificationDemo> list = 
				Arrays.asList(new A(),new B());
		for(RunTimeTypeIdentificationDemo l:list){
			l.allHave();
		}
		
	}
	
	public void allHave(){
		System.out.println(toString());
	}
	abstract public String toString();
}
class A extends RunTimeTypeIdentificationDemo{
	public String toString(){
		return "A";
	}
}
class B extends RunTimeTypeIdentificationDemo{
	public String toString(){
		return "B";
	}
}