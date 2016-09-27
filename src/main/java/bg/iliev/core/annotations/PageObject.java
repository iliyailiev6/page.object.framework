package bg.iliev.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Annotation that marks a class as page object. 
 * The page object class will be initialized from 
 * the test runner and injected into the test class.
 * 
 * @since 1.0
 * 
 * @author Iliya
 *
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PageObject {

	
}
