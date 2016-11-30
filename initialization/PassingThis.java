package initialization;

public class PassingThis {
	public static void main(String[] args) {
		new Person().eat(new Apple());
	}
}
class Person{
	public void eat(Apple apple){
		//do sth
		Apple peeled = apple.getPeeled();
		System.out.println("apple done");
	}
}
class Apple{
	Apple getPeeled(){
		return Peeler.peel(this);
	}
}
class Peeler{
	static Apple peel(Apple apple){
		// do sth
		return apple;
	}
}