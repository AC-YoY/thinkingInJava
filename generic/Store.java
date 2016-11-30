package generic;

import java.util.ArrayList;
import java.util.Random;
/**
 * 如何用泛型创造一个复杂的数据结构
 * 
 * BaseClass 利用 Generator
 * 在外部用集合包装它
 * 
 * @author 建苍
 *
 */
class Product{
	private int id;
	private String description;
	private double price;
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description
				+ ", price=" + price + "]";
	}
	private Product(int id, String description, double price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
	}
	public static Generator<Product> generator = new Generator<Product>(){
		Random random = new Random();
		@Override
		public Product next(){
			return new Product(random.nextInt(100),"TEST_NAME",Math.round(random.nextDouble()*1000)+0.99);
		}
	};
}
class Shelf extends ArrayList<Product> {
	public Shelf(int ProductQty){
		Generators.fill(this, Product.generator, ProductQty);
	}
}
class Aisle extends ArrayList<Shelf>{
	//因为Shelf只提供了一种方法，没有默认的空参构造，所以只能用两个formal parameters
	public Aisle(int ShelfQty,int ProductQty){
		for(int i=0;i<ShelfQty;i++){
			add(new Shelf(ProductQty));
		}
	}
}
public class Store extends ArrayList<Aisle>{
	public Store(int AisleQty,int ShelfQty,int ProductQty){
		for(int i=0;i< AisleQty;i++){
			//Constructor。绝对好用
			add(new Aisle(ShelfQty,ProductQty));
		}
	}
	
	@Override
	public String toString() {
		//要表示一大段字符串
		StringBuilder sb = new StringBuilder();
		for(Aisle a:this){
			for(Shelf s:a){
				for(Product p:s){
					sb.append(p);
					sb.append("\n");
				}
				sb.append("---------------------\n");
			}
			sb.append("-----------走廊------------\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Store(3,2,5));
	}
}
