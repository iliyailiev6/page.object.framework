package bg.iliev.core;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

/**
 * 
 * Class to hold runtime configuration, as well as the web driver instance.
 * 
 * @since 1.0
 * 
 * @author Iliya
 *
 */
public final class TestContext {

	private static WebDriver webDriver;
	
	private TestContext() {
		// no instances of this class
	}
	
	/**
	 * 
	 * @throws NullPointerException if driver is null
	 * @param driver
	 */
	public static void setDriver(WebDriver driver){
		webDriver = Objects.requireNonNull(driver);
	}
	
	public static WebDriver getDriver(){
		return webDriver;
	}
}
