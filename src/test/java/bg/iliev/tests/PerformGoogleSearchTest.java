package bg.iliev.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import bg.iliev.core.annotations.Driver;
import bg.iliev.core.annotations.PageObject;
import bg.iliev.core.runner.PageObjectJunitRunner;
import bg.iliev.pageobjects.GoogleSearchPage;

@RunWith(PageObjectJunitRunner.class)
public class PerformGoogleSearchTest {

	@PageObject
	private GoogleSearchPage googleSearchPage;
	
	@Driver
	private WebDriver driver;
	
	@Test
	public void testSearchInGoogle(){
		googleSearchPage.navigate();
		googleSearchPage.setTextToBeSearched("test search");
		Assert.assertTrue(googleSearchPage.getNumberOfResults() > 0);
	}
}
