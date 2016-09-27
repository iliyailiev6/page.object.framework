package bg.iliev.core.runner;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;


/**
 * 
 * Custom junit runner that can do a lot of stuff by itself.
 * <br>
 * 1. Initialize web driver instance and inject it it test class.
 * <br>
 * 2. Initialize page objects.
 * <br>
 * 3. Run test several times on different browser.
 * <br>
 * 4. Automatic database configuration.
 * 
 * @since 1.0
 * 
 * @author Iliya
 *
 */
public class PageObjectJunitRunner extends BlockJUnit4ClassRunner{

	public PageObjectJunitRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
		
		RunnerUtils.handleBrowserType();
	}

}
