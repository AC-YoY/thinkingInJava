package io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Externalizable接口被实现的时候只会自动调用默认构造器 所有带参构造器都要自己去调用
 * 
 * @author 建苍
 * 
 */
public class Externalizable_Demo implements Externalizable {
	
	private final static String file = "C:\\javajdk\\serialable.out";
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		System.out.println("Constructing objects:");
		Externalizable_Demo demo1 = new Externalizable_Demo();
		demo1.i = 10;
		demo1.s = "S";
		System.out.println("demo1:" + demo1);
		ObjectOutputStream oop = new ObjectOutputStream(
				new FileOutputStream(file));
		System.out.println("Saving Object:");
		oop.writeObject(demo1);
		oop.close();
		
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(file));
		System.out.println("Recovering demo1:");
		demo1 = (Externalizable_Demo)in.readObject();
		System.out.println(demo1);
	}

	// 没有初始化的属性，被恢复的时候只有自动初始化效果
	int i;
	String s;

	public Externalizable_Demo() {
		System.out.println("Externalizable_Demo");
	}
//		所以构造方法并不重要，
	// public Externalizable_Demo(String x, int a) {
	// System.out.println("Externalizable_Demo(String x, int a)");
	// s = x;
	// i = a;
	// }
	public String toString() {
		return s + " " + i;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Externalizable_Demo.writeExternalizable...");
		// 这部是在写信息的时候将primitive argument保存下来
		 out.writeObject(s);
		 out.writeInt(i);
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("Externalizable_Demo.readExternalizable...");
		 s = (String) in.readObject();
		 i = in.readInt();
	}

}
