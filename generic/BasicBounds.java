package generic;

interface HasColor{
	java.awt.Color getColor();
}
class Colored<T extends HasColor>{
	T item;
	Colored(T item){this.item = item;}
	T getItem(){ return item;}
	//有了边界才能 call method
	java.awt.Color color(){return item.getColor();}
}
class Dimension{ 
	public int x,y,z;
}
class ColoredDimension<T extends Dimension & HasColor>{
	T item;
	ColoredDimension(T item){this.item = item;}
	T getItem(){return item;}
	java.awt.Color color(){return item.getColor();}
	int getX(){return item.x;}
	int getY(){return item.y;}
	int getZ(){return item.z;}
}
interface Weight{ int weight();}
class Solid<T extends Dimension & HasColor & Weight>{
//	T item;
//	Solid(T item){}
}




public class BasicBounds {

}
