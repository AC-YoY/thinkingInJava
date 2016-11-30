package strings;

import java.util.Formatter;

public class Turtle {
	public static void main(String[] args) {
		//Test Method move One
		Turtle micky = new Turtle("Micky");
		micky.move(3, 5);
		micky.move(5, 3);
		Turtle jummy = new Turtle("jummy",new Formatter(System.out));
		jummy.move(3, 2, "HeHe");
		jummy.move(3, 6, "HeHe");
		
	}
	
	
	private String name;
	private Formatter formatter;
	// constructor for Overwriting Method move
	public Turtle(String name) {
		super();
		this.name = name;
	}
	//full Constructor
	public Turtle(String name, Formatter formatter) {
		super();
		this.name = name;
		this.formatter = formatter;
	}


	//简单的重载+运算符号来实现运动
	public void move(int x,int y){
		System.out.println(name+"is moving to ("+x+","+y+")");
	}
	
	//useless String！！！！
	public void move(int x,int y,String str){
		formatter.format("%S$ is moving to (%d,%d)\n", name,x,y);
	}

}
