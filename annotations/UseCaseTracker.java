package annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
	public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
		for (Method m : cl.getDeclaredMethods()) {
			/*
			 * 这里UseCase就相当于是一个类了 getAnnotation就相当于从Method中去取得注解
			 */
			UseCase uc = m.getAnnotation(UseCase.class);
			if (uc != null) {
				System.out.println("Found UseCase:" + uc.id() + " "
						+ uc.description());
				//千万不能直接用 primitive parmeter!!这个remove会重载！！！
				useCases.remove(new Integer(uc.id()));
			}
		}
		for (int i : useCases) {
			System.out.println("Warning: Missing useCase-" + i);
		}
	}

	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 20, 21, 22, 23);
		trackUseCases(useCases, PwdUtils.class);
	}
}
