package bg.iliev.core.runner;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Set;
import java.util.function.Predicate;

import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.reflections.Reflections;
import org.springframework.test.util.ReflectionTestUtils;

import bg.iliev.core.AssertExtended;
import bg.iliev.core.BrowserType;
import bg.iliev.core.Page;
import bg.iliev.core.TestContext;
import bg.iliev.core.annotations.AbstractPage;
import bg.iliev.core.annotations.Driver;
import bg.iliev.core.annotations.TestConfiguration;
import bg.iliev.core.configuration.ConfigurationManager;
import bg.iliev.core.configuration.WebDriverConfigurationOptions;
import bg.iliev.core.exception.WebDriverConfigurationException;


public class RunnerUtils {

	public static void handleBrowserType(){
		Reflections reflections = new Reflections(".*");
		
		Set<Class<?>> configClasses 
			= reflections.getTypesAnnotatedWith(TestConfiguration.class);
		AssertExtended.assertSize(configClasses, 1);
		
		Class<?> config = configClasses.iterator().next();
		WebDriverConfigurationOptions result = null;
		
		for(Method method : config.getMethods()){
			if(method.getName().equals("setBrowserOptions")){
				try {
					result = (WebDriverConfigurationOptions) method.invoke(config.newInstance(), null);
				} catch (IllegalAccessException e) {
					throw new WebDriverConfigurationException(e.getCause(), e.getMessage());
				} catch (IllegalArgumentException e) {
					throw new WebDriverConfigurationException(e.getCause(), e.getMessage());
				} catch (InvocationTargetException e) {
					throw new WebDriverConfigurationException(e.getCause(), e.getMessage());
				} catch (InstantiationException e) {
					throw new WebDriverConfigurationException(e.getCause(), e.getMessage());
				}
			}
		}
		
		ConfigurationManager.setOptions(result);
	}

	public static void initDriver() {

		int type = ConfigurationManager.getOptions().getBrowserType();
		
		if(type == BrowserType.FIREFOX){
			TestContext.setDriver(new FirefoxDriver());
		}
		
		if(type == BrowserType.CHROME){
			File file = new File("C:\\Users\\Iliya\\git\\page-object-framework\\page-object-framework\\page.object.framework\\src\\test\\driver\\chromedriver.exe");
			ChromeDriverService.Builder bldr = (new ChromeDriverService.Builder())
			                                   .usingDriverExecutable(file)
			                                   .usingAnyFreePort();
			ChromeDriver driver = new ChromeDriver(bldr.build());
			TestContext.setDriver(driver);
		}
		
		Reflections reflections = new Reflections(".*");
		
		Set<Class<?>> pageClasses 
			= reflections.getTypesAnnotatedWith(AbstractPage.class);
		pageClasses.removeIf(new Predicate<Class<?>>() {
			public boolean test(Class<?> t) {
				return !t.getName().equals(Page.class.getName());
			};
		});
		AssertExtended.assertSize(pageClasses, 1);
		
		try {
			Class<?> clazz = pageClasses.iterator().next();
			Field field = clazz.getDeclaredField("driver");
			ReflectionTestUtils.setField(clazz, 
					field.getName(), TestContext.getDriver());
		} catch (NoSuchFieldException e) {
			throw new WebDriverConfigurationException(e.getCause(), e.getMessage());
		} catch (SecurityException e) {
			throw new WebDriverConfigurationException(e.getCause(), e.getMessage());
		}
	}

	public static void injectDriverInstance(Description testDescription) {
		
		for(Field field : testDescription.getTestClass().getDeclaredFields()){
			if(field.getAnnotation(Driver.class) != null){
				
				ReflectionTestUtils.setField(testDescription.getTestClass(), field.getName(), TestContext.getDriver());
			}
		}
	}
}
