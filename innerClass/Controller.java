package innerClass;

import java.util.ArrayList;
import java.util.List;

public class Controller {
//	public static void main(String[] args) {
//		ArrayList<String> al = new ArrayList<String>();
//		al.add("A");
//		al.add("B");
//		al.add("C");
//		while(al.size() > 0){
//			for(Iterator i=al.iterator();i.hasNext();){
//				String str = (String)i.next();
//				if(str.equals("A")){
//					i.remove();
//				}
//				System.out.println(str);
//			}
//		}
//	}
	
	private List<Event> eventList = new ArrayList<Event>();
	
	public void addEvent(Event e){
		eventList.add(e);
	}
//	need test
//	public void run(){
//		while(eventList.size()>0){
//			for(Iterator i=eventList.iterator();i.hasNext();){
//				Event e = (Event)i.next();
//				if(e.ready()){
//					System.out.println(e);
//					e.action();
//					eventList.remove(e);
//				}
//			}
//		}
//	}
	public void run(){
		while(eventList.size()>0){
			/**
			 * 高手。新构造一个集合，在旧的集合中去遍历新的集合元素。
			 * 这样就可以在新循环中去删除集合元素了。
			 */
			for(Event e:new ArrayList<Event>(eventList)){
				if(e.ready()){
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
			}
		}
	}
	
	
}
