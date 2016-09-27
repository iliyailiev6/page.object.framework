package bg.iliev.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import bg.iliev.core.Page;

public class GoogleSearchPage extends Page{

	private final String URL = "https://www.google.com";
	
	@FindBy(className = "gsfi")
	private WebElement searchedText;
	
	@FindAll(@FindBy(className = "g"))
	private List<WebElement> resultList;
	
	@Override
	public void navigate() {
		driver.navigate().to(URL);
	}

	@Override
	public void refresh() {
		driver.navigate().refresh();
	}

	public void setTextToBeSearched(String text){
		searchedText.sendKeys(text);
	}
	
	public int getNumberOfResults(){
		return resultList.size();
	}
}
