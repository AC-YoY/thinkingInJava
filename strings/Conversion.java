package strings;

public class Conversion {
	public static void main(String[] args) {
		System.out.println(showBinary((
				"REWFCSACSDCDSAFDEWFdassa的萨芬和我复婚为"
				+ "附近的萨芬卡萨防护饿我去和阿什可视对讲飞洒户"
				+ "外欺负为jfkas回复肯定撒进机房书库房价肯定是解"
				+ "放咯 jkfjewifjrewifsajdsahufs").getBytes()));
	}

	public static String showBinary(byte[] bb) {
		StringBuilder sb = new StringBuilder();
		int n = 0;
		for (byte b : bb) {
			if (n % 16 == 0) {
				sb.append(String.format("%05x: ", n));
			}
			sb.append(String.format("%02x ", b));
			n++;
			if(n%16==0){
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
