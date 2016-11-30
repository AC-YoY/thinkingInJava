package strings;

import java.util.Formatter;

/**
 * i don't like receipt
 * 
 * let's just show this table like 
 * what we do in mysql / sqlplus.
 * 
 * TARGET:
 * 
 * Item              Qty      Price
 * ----              ---      -----
 * Jack's Magic Be     4       4.25
 * Princess Peas       3       5.10
 * Three Bears Por     1      14.29
 * Tax                         1.42
 *                            -----
 * Total                      25.06
 * 
 * @author 建苍
 *
 */
public class Receipt {
	public static void main(String[] args) {
		printTitle();
		printReceipt("jhon's PaPa's homemade cake",3,122.4f);
		printReceipt("mdsa",2,35.2f);
		printReceipt("odsaji",2,33f);
		printTotal();
	}
	
	private static float total;
	private static Formatter fm = new Formatter(System.out);
	
	public static void printTitle(){
		fm.format("%-15S %-5S %-5S\n", "Item","Qty","Price");
		fm.format("%-15S %-5S %-5S\n", "----","---","-----");
	}
	
	public static void printReceipt(String name,int qty,float price){
		fm.format("%-15.15S %3d   %5.2f\n", name,qty,price);
		total += price;
	}
	public static void printTotal(){
		fm.format("%-15.15S %3s   %5.2f\n","Tax","",total*0.2f);
		fm.format("%-15S %-5S %-5S\n", "","","-----");
		fm.format("%-17.18S %10.2f\n","Total",total*=1.2f);
	}
	
	
	
}

