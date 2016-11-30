package concurrency;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 顾名思义 客户仿真流派
 * 
 * @author 建苍
 * 
 */
public class BankTellerSimulation {
	static final int MAX_LINE_SIZE = 50;
	static final int ADJUSTMENT_PERIOD = 1000;

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		// If line is too long, customers will leave:
		CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
		exec.execute(new CustomerGenerator(customers));
		// Manager will add and remove tellers as necessary:
		exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD));
		if (args.length > 0) { // Optional argument
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
		} else {
			System.out.println("Press 'Enter' to quit");
			System.in.read();
		}
		exec.shutdownNow();
	}
}

/**
 * 客户仅用消耗时间来表示
 * 
 * @author 建苍
 * 
 */
class Customer {
	private final int serviceTime;

	public Customer(int tm) {
		this.serviceTime = tm;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public String toString() {
		return "[" + serviceTime + "]";
	}
}

/**
 * CustomerLine用来存放Customer对象
 * 
 * @author 建苍
 * 
 */
class CustomerLine extends ArrayBlockingQueue<Customer> {
	public CustomerLine(int size) {
		super(size);// capacity 有毛用！？
	}

	public String toString() {
		if (this.size() == 0) {
			return "[Empty]";
		}
		StringBuilder s = new StringBuilder();
		for (Customer c : this) {
			s.append(c);
		}
		return s.toString();
	}
}

/**
 * Generator是依附在CustomerLine上面 间隔生产出对象来
 * 
 * @author 建苍
 * 
 */
class CustomerGenerator implements Runnable {
	private CustomerLine customers;

	public CustomerGenerator(CustomerLine cl) {
		this.customers = cl;
	}

	private Random random = new Random();

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(random.nextInt(300));
				customers.put(new Customer(random.nextInt(1000)));
			}
		} catch (InterruptedException e) {
			System.out.println("CustomerGenerator Interrupted");
		}
		System.out.println("CustomerGenerator terminating");
	}
}

/**
 * 出纳
 * 
 * @author 建苍
 * 
 */
class Teller implements Runnable, Comparable<Teller> {
	private static int counter = 0;
	private final int id = counter++;
	private int customersServed = 0;
	private CustomerLine customers;
	// 判断该员工是否在干活
	private boolean servingCustomerLine = true;

	public Teller(CustomerLine cl) {
		this.customers = cl;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				Customer customer = customers.take();
				TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
				// 这里非常不理解!
				synchronized (this) {
					customersServed++;
					while (!servingCustomerLine) {
						wait();
					}
				}
			}
		} catch (Exception e) {
			System.out.println(this + " interrupted");
		}
		System.out.println(this + " terminating");
	}

	public synchronized void doSomethingElse() {
		customersServed = 0;
		servingCustomerLine = false;
	}

	public synchronized void serveCustomerLine() {
		assert !servingCustomerLine : "already serving:" + this;
		servingCustomerLine = true;
		notifyAll();
	}

	public String toString() {
		return "Teller:" + id + " ";
	}

	public String shortString() {
		return "T:" + id;
	}

	public synchronized int compareTo(Teller t) {
		return customersServed < t.customersServed ? -1
				: (customersServed == t.customersServed ? 0 : 1);
	}
}

class TellerManager implements Runnable {
	private ExecutorService exec;
	private CustomerLine customers;
	private PriorityQueue<Teller> workingTellers = new PriorityQueue<Teller>();
	private Queue<Teller> tellersDoingOtherThings = new LinkedList<Teller>();
	private int adjustmentPeriod;
	private static Random random = new Random();

	public TellerManager(ExecutorService es, CustomerLine customers,
			int adjustmentPeriod) {
		exec = es;
		this.customers = customers;
		this.adjustmentPeriod = adjustmentPeriod;

		Teller teller = new Teller(customers);
		exec.execute(teller);
		workingTellers.add(teller);
	}

	/**
	 * 根据顾客人数来调整Teller的实际人数
	 */
	public void adjustTellerNumber() {
		if (customers.size() / workingTellers.size() > 2) {
			// teller有的剩，才能调整
			if (tellersDoingOtherThings.size() > 0) {
				Teller teller = tellersDoingOtherThings.remove();
				teller.serveCustomerLine();
				workingTellers.offer(teller);
				return;
			}
			// 没得调整就新建一个
			Teller teller = new Teller(customers);
			exec.execute(teller);
			workingTellers.add(teller);
			return;
		}
		if (workingTellers.size() > 1
				&& customers.size() / workingTellers.size() < 2) {
			reassignOneTeller();
		}
		if (customers.size() == 0) {
			while (workingTellers.size() > 1) {
				reassignOneTeller();
			}
		}
	}

	private void reassignOneTeller() {
		Teller teller = workingTellers.poll();
		teller.doSomethingElse();
		tellersDoingOtherThings.offer(teller);
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
				adjustTellerNumber();
				System.out.print(customers + " { ");
				for (Teller teller : workingTellers)
					System.out.print(teller.shortString() + " ");
				System.out.println("}");
			}
		} catch (InterruptedException e) {
			System.out.println(this + "interrupted");
		}
		System.out.println(this + "terminating");
	}

	public String toString() {
		return "TellerManager ";
	}
}