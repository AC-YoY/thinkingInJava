package concurrency;
/**
 * 交互输入输出
 * 
 * @author 建苍
 *
 */
public class ResponsiveUI extends Thread{
	private static volatile double d = 1;
	public ResponsiveUI(){
		setDaemon(true);
		start();
	}
	public void run(){
		while(true){
			d = d + (Math.E+Math.PI)/d;
		}
	}
	
	public static void main(String[] args) throws Exception {
//		U can only kill this
//		new UnresponsiveUI(); 
		// Daemon Thread here , ends after main Thread
		new ResponsiveUI();
		System.in.read();
		System.out.println(d);
	}
}
class UnresponsiveUI{
	private volatile double d =1;
	public UnresponsiveUI() throws Exception{
		while(d>0){
			d = d + (Math.PI+Math.E)/d;
		}
		System.in.read(); // unreachable
	}
}