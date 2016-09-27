package bg.iliev.core.configuration;

public class ConfigurationManager {

	private static WebDriverConfigurationOptions options;
	
	public static WebDriverConfigurationOptions getOptions() {
		return options;
	}

	public static void setOptions(WebDriverConfigurationOptions driverOptions) {
		options = driverOptions;
	}
}
