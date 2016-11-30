package containers;

/**
 * 微基准测试
 * 
 * @author 建苍
 * 
 */
public class RandomBounds {
	public static void main(String[] args) {
		if(args.length != 1){
			usage();
		}
		if(args[0].equals("Lower")){
			while(Math.random()!=0.0){
				//do sth
			}
			System.out.println("produce 0.0!");
		}else if(args[0].equals("Upper")){
			while(Math.random()!=1.0){
				//do sth else
			}
			System.out.println("produce 1.0!");
		}
		else{
			usage();
		}
	}

	static void usage() {
		System.out.println("Usage:");
		System.out.println("/tRandomBounds Lower");
		System.out.println("/tRandomBounds Upper");
		System.exit(1);
	}

}
