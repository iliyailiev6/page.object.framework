package bg.iliev.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Annotation that marks a class as web driver. 
 * The driver will be initialized automatically from 
 * the test runner and injected into the test class. 
 * The driver configuration is done by your {@link TestConfiguration} class.
 * 
 * @since 1.0
 * 
 * @author Iliya
 *
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Driver {

}
