package polymorphism;

import java.util.Arrays;

public abstract class StringProcessor implements Processor{
	public String name(){
		return getClass().getSimpleName();
	}
	public abstract String process(Object input);
	public static String s = "jd saj fksajk fsadjksa jks ajk";
	
	public static void main(String[] args) {
		Apply.process(new Upcase(), s);
		Apply.process(new Downcase(), s);
		Apply.process(new Splitter(), s);
	}
}
interface Processor{
	String name();
	Object process(Object input);
}
class Apply{
	public static void process(Processor p,Object s){
		System.out.println("Using processor"+p.name());
		System.out.println(p.process(s));
	}
}
class Upcase extends StringProcessor{
	public String process(Object input){
		return ((String)input).toUpperCase();
	}
}
class Downcase extends StringProcessor{
	public String process(Object input){
		return ((String)input).toLowerCase();
	}
}
class Splitter extends StringProcessor{
	@Override
	public String process(Object input) {
		return Arrays.toString(((String)input).split(" "));
	}
}