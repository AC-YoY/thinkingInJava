package initialization;
/**
 * sometimes method finalize() helps find out 
 * which object can be destoryed/recyle/collection?
 * 
 * @author 建苍
 *
 */
public class SomethingAboutGc {
	public static void main(String[] args) {
		Book book = new Book();
		book.checkIn();
		////////////////////
		new Book().checkIn();
		// special operation
		System.gc();
	}
}

class Book{
	boolean status = false;
	public void checkIn(){
		status = true;
	}
	public void checkOut(){
		status = false;
	}
	
	@Override
	public void finalize(){
		if(status){
			System.out.println("this book  is checking out");
		}
	}
	
}
