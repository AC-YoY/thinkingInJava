package innerClass;

import java.util.ArrayList;

public class GreenhouseController {
	public static void main(String[] args) {
		GreenhouseControls gc = new GreenhouseControls();
		ArrayList<Event> al = new ArrayList<Event>();
		//这个bell不受Restart管理，以免，不断增加bell数量
		gc.addEvent(gc.new Bell(180000000));
		
		al.add(gc.new LightOn(130000000));
		al.add(gc.new LightOff(190000000));
		
		
		gc.addEvent(gc.new Restart(500000000,al));
		
		if(args.length == 1){
			gc.addEvent(
					new GreenhouseControls.Terminate(
							new Integer(args[0])));
		}
		
		gc.run();
	}
	
}
