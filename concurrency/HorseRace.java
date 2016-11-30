﻿package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CyclicBarrier
 * 一个可以无限循环的CountDownLatch
 * @author 建苍
 *
 */
public class HorseRace {
	static final int FINISH_LINE = 75;
	private List<Horse> horses = new ArrayList<Horse>();
	private ExecutorService exec = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;
	public HorseRace(int nHorses,final int pause){
		barrier = new CyclicBarrier(nHorses,new Runnable(){
			public void run(){
				StringBuilder s = new StringBuilder();
				for(int i=0;i<FINISH_LINE;i++){
					s.append("=");
				}
				System.out.println(s);
				for(Horse horse:horses){
					System.out.println(horse.tracks());
				}
				for(Horse horse:horses){
					if(horse.getStrides()>=FINISH_LINE){
						System.out.println(horse + "won!");
						exec.shutdownNow();
						return;
					}
				}
				try{
					TimeUnit.MILLISECONDS.sleep(pause);
				}catch(InterruptedException e){
					System.out.println("barrier-action sleep interrupted");
				}
			}
		});
		for(int i = 0; i < nHorses; i++) {
		      Horse horse = new Horse(barrier);
		      horses.add(horse);
		      exec.execute(horse);
		}
	}
	public static void main(String[] args) {
	    int nHorses = 7;
	    int pause = 200;
	    if(args.length > 0) { // Optional argument
	      int n = new Integer(args[0]);
	      nHorses = n > 0 ? n : nHorses;
	    }
	    if(args.length > 1) { // Optional argument
	      int p = new Integer(args[1]);
	      pause = p > -1 ? p : pause;
	    }
	    new HorseRace(nHorses, pause);
	}
}
class Horse implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private int strides = 0;
	private static Random random = new Random();
	private static CyclicBarrier barrier;
	public Horse(CyclicBarrier b){barrier = b;}
	public synchronized int getStrides(){return strides;}
	public void run(){
		try{
			while(!Thread.interrupted()){
				synchronized(this){
					strides += random.nextInt(3);
				}
				barrier.await();
			}
		}catch(InterruptedException e){
		}catch(BrokenBarrierException e){
			throw new RuntimeException(e);
		}
	}
	public String toSttring(){
		return "Horse "+id+" ";
	}
	public String tracks(){
		StringBuilder s = new StringBuilder();
		for(int i=0;i<getStrides();i++){
			s.append("*");
		}
		s.append(id);
		return s.toString();
	}
}
