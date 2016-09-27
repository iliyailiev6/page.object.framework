package bg.iliev.configuration;

import bg.iliev.core.BrowserType;
import bg.iliev.core.annotations.TestConfiguration;
import bg.iliev.core.configuration.WebDriverConfiguration;
import bg.iliev.core.configuration.WebDriverConfigurationOptions;

@TestConfiguration
public class TestConfig extends WebDriverConfiguration{

	@Override
	public WebDriverConfigurationOptions setBrowserOptions() {
		WebDriverConfigurationOptions options = new WebDriverConfigurationOptions();
		options.setBrowserType(BrowserType.FIREFOX);
		return options;
	}

}
