package bg.iliev.core;

import org.openqa.selenium.WebDriver;

import bg.iliev.core.annotations.AbstractPage;


/**
 * 
 * Abstract class to hold every possible action that a web page can do.
 * The framework assures that this class will always 
 * have the driver instance available.
 * 
 * @since 1.0
 * 
 * @author Iliya
 *
 */

@AbstractPage
public abstract class Page {

	protected WebDriver driver;
	
	/**
	 * Navigates to the caller page
	 */
	public abstract void navigate();
	
	/**
	 * Refresh the page
	 */
	public abstract void refresh();
}
