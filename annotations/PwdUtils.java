package annotations;

import java.util.List;
/**
 * 尝试使用建好的 UseCase Annotation
 * @author 建苍
 *
 */
public class PwdUtils {
	//这一行只是为了试试看多个注解,以及多层注解怎么用
//	@MutilLevelAnnotation(setLower = @LowerAnnotation(value = 5))
	
	@UseCase(id = 20,description = "Pwd must contain at least a numeric")
	public boolean validatePassword(String pwd){
		return (pwd.matches("\\w*\\d\\w*"));
	}
	@UseCase(id = 21)
	public String encryptPassword(String pwd){
		return new StringBuilder(pwd).reverse().toString();
	}
	@UseCase(id = 22,description = "New Pwd can't equal previously uesd ones")
	public boolean checkForNewPassword(
			List<String> prevPwd,String pwd){
		return !prevPwd.contains(pwd);
	}
}
