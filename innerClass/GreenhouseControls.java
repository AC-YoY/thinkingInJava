package innerClass;

import java.util.ArrayList;
import java.util.List;

public class GreenhouseControls extends Controller{
	private boolean lightStat = false;
	public class LightOn extends Event{
		public LightOn(long delayTime) {
			super(delayTime);
		}
		@Override
		public void action(){ lightStat = true;}
		@Override
		public String toString() {
			return "Light is on!";
		}
	}
	public class LightOff extends Event{
		public LightOff(long delayTime) {
			super(delayTime);
		}
		@Override
		public void action(){lightStat = false;}
		@Override
		public String toString(){
			return "Light is off!";
		} 
	}
	public class Bell extends Event{
		private long delayTime;
		public Bell(long delayTime){
			super(delayTime);
			this.delayTime = delayTime;
		}
		@Override
		public String toString() {
			return "Bell rings!";
		}
		@Override
		public void action(){
			//inner class can use all outer class's sources
			GreenhouseControls.this.addEvent(new Bell(delayTime));
		}
	}
	
	public class Restart extends Event{
		private List<Event> eventList = new ArrayList<Event>();
		public Restart(long delayTime,List<Event> eventList){
			super(delayTime);
			this.eventList = eventList;
		}
		/**
		 * core part:
		 * 问题在于需要在Restart中也重新安排一个计划，
		 * TA可以与之前的计划不一致， ---这个计划在传入参数中
		 * 安排完之后要记得将Restart自己也安排进集合中去
		 */
		public void action(){
			/**
			 * 要将每一个集合元素都进行管理
			 */
			for(Event e:eventList){
				/**
				 * event事件的时间是由创建的时候的传入参数来控制的，
				 * 这里只需要调用start()将Event事件开始并且放入集合中管理即可
				 */
				e.start();
				GreenhouseControls.this.addEvent(e);
			}
			this.start();
			addEvent(this);
			
		}
		public String toString(){
			return "System is [Restart]ing!";
		}
	}
	
	public static class Terminate extends Event{
		public Terminate(long delayTime) {
			super(delayTime);
		}
		@Override
		public void action() {
			System.exit(0);
		}
		@Override
		public String toString(){
			return "Terminate module starts!s";
		}
		
	}
	
}
