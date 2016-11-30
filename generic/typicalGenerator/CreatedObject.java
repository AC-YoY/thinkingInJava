package generic.typicalGenerator;
/**
 * hei there , i wanna be created
 * @author 建苍
 *
 */
public class CreatedObject {
	//to make sure no one can use it
	private static int counter = 0;
 	private final int No = counter++;
	public int getNo() {
		return No;
	}
	@Override
	public String toString() {
		return "CreatedObject [No=" + No + "]";
	}
}
