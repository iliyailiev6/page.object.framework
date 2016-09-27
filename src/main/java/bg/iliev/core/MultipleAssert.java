package bg.iliev.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Chain multiple assertions into one statement. All assertion will be executed.
 * 
 * @author Iliya
 *
 */
public class MultipleAssert {

	private static final Logger LOG = Logger.getLogger(MultipleAssert.class.getCanonicalName());
	
	private static List<Map<String, Object>> statements;
	private static final String ACTUAL_KEY = "actual";
	private static final String EXPECTED_KEY = "expected";
	private List<String> errors;
	
	public MultipleAssert() {
		statements = new ArrayList<Map<String,Object>>();
		errors = new ArrayList<String>();
	}
	
	public MultipleAssert assertEquals(Object expected, Object actual){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ACTUAL_KEY, actual);
		map.put(EXPECTED_KEY, expected);
		statements.add(map);
		LOG.log(Level.INFO, "Actual param is : " + actual.toString());
		LOG.log(Level.INFO, "Expected param is : " + expected.toString());
		return this;
	}
	
	public void executeChainAssertion(){
		for (Map<String, Object> statement : statements){
			Object actual = statement.get(ACTUAL_KEY);
			Object expected = statement.get(EXPECTED_KEY);
			
			try{
				AssertExtended.assertEquals(expected, actual);
			}catch(AssertionError e){
				errors.add(e.getMessage() + "/n");
			}
		}
		
		if(!errors.isEmpty()){
			throw new AssertionError(errors.toString());
		}
	}
}
