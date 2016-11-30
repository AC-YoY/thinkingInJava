package initialization;

public class EnumDemo {
	public static void main(String[] args) {
		EnumDemo a = new EnumDemo(Spiciness.NOT);
		a.describe();
	}

	Spiciness degree;

	public EnumDemo(Spiciness degree) {
		this.degree = degree;
	}

	public void describe() {
		System.out.println("this burrito is");
		switch (degree) {
		case NOT:
			System.out.println("not spicy at all");
			break;
		case MILD:
			System.out.println("a little hot");
			break;
		case FLAMING:
		default:
			System.out.println("too hot");
		}
	}
	
}
enum Spiciness {

	NOT,MILD,MEDIUM,HOT,FLAMING

}
