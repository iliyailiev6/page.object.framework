package bg.iliev.core.exception;

public class WebDriverConfigurationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6133910889078125006L;

	public WebDriverConfigurationException() {
		super();
	}
	
	public WebDriverConfigurationException(Throwable t){
		super(t);
	}
	
	public WebDriverConfigurationException(Throwable t, String message){
		super(message, t);
	}
}
