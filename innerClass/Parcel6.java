package innerClass;
/**
 * 创建在任意作用域的内部类
 * 
 * @author 建苍
 *
 */
public class Parcel6 {
	private void internalTracking(boolean b){
		/**
		 * if内部，就是本内部类的作用域
		 * 虽然生成该类是有条件的，但是编译的时候一样会被编译成类(Parcel6$1TrackingSlip.class)
		 */
		if(b){
			class TrackingSlip{
				private String id;
				private TrackingSlip(String s){
					id = s;
				}
				String getSlip(){return id;}
			}
			//我明明是在 class外部去调用它的，private也可以去生成一个实例？？
			TrackingSlip trackingSlip = new TrackingSlip("open");
			String str = trackingSlip.getSlip();
			
		}
		
	}
	public void track(){
		internalTracking(true);
	}
	public static void main(String[] args) {
		Parcel6 pracel6 = new Parcel6();
		pracel6.track();
		
	}
}
