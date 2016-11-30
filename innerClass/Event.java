package innerClass;

public abstract class Event {
	private long eventTime;
	/**
	 * fixed delayTime to make sure 
	 */
	private final long delayTime;
	public Event(long delayTime){
		this.delayTime = delayTime; 
		start();
	}
	
	public boolean ready(){
		return System.nanoTime() >= eventTime;
	}
	public void start(){
		eventTime = System.nanoTime() + delayTime;
	}
	/**
	 * hardware action,don't care.
	 */
	public abstract void action();
}