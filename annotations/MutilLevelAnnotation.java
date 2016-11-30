package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Hello ,I'm the top Annotation
 * @author 建苍
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MutilLevelAnnotation {
	public String getString() default "Hello World";
	public LowerAnnotation setLower() default @LowerAnnotation(value = 3);
}
