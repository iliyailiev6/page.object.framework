package bg.iliev.core.runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import org.reflections.Reflections;

import bg.iliev.core.AssertExtended;
import bg.iliev.core.annotations.TestConfiguration;
import bg.iliev.core.configuration.WebDriverConfigurationOptions;


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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
