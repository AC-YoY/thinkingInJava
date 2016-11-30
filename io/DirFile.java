package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;
/**
 * File 有四种 构造方法
 * 如何去过滤文件列表，选择所需的项目
 * 
 * @author 建苍
 *
 */
public class DirFile {
	public static void main(String[] args) {
//		File file = new File(".");
//		System.out.println( Arrays.toString(file.list()));
//		File SonFile = new File(file,"src");
//		System.out.println(Arrays.toString(SonFile.list()));
//		File son2 = new File(".","src");
//		System.out.println(Arrays.toString(son2.list()));
		
		File path = new File(".");
		String[] list;
		//下面两个方法是一个效果
		//MethodOne
//		list = path.list(new DirFilter("\\..+"));
		//MethodTwo
//		list = path.list(filter("\\..+"));
		//MethodThree
		final String regex = "\\..+";
		list = path.list(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String str) {
				Pattern p = Pattern.compile(regex);
				return p.matcher(str).matches();
			}
		});
		//大小写排序还是要学一个的
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list){
			System.out.println(dirItem);
		}
		
	}
	//anonymous inner class
	public static FilenameFilter filter(final String regex){
		return new FilenameFilter(){
			//如果要在匿名内部类当中调用外部资源，必须是final的?!
			private Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir,String name){
				return pattern.matcher(name).matches();
			}
		};
	}
}
//这个类就是为了能让文件按照需求去筛选
class DirFilter implements FilenameFilter{
	//regex更加方便
	private Pattern pattern;
	//正则 构造 不多说
	public DirFilter(String regex){
		pattern = Pattern.compile(regex);
	}
	/**
	 * FilenameFilter 唯一一个方法,用来判断文件是否合理
	 */
	@Override
	public boolean accept(File file, String name) {
		return pattern.matcher(name).matches();
	}
}