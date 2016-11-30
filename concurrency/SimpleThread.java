package concurrency;

public class SimpleThread extends Thread{
	private int countDown = 5;
	private static char threadCount = 'A';
	
	public SimpleThread(){
		//store thread name
		super(""+threadCount++);
		start();
	}
	
	public String toString(){
		return "#"+getName()+"("+countDown+"),";
	}
	
	public void run(){
		while(true){
			System.out.println(this);
			if(--countDown == 0){
				return;
			}
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			new SimpleThread();
		}
	}
}
