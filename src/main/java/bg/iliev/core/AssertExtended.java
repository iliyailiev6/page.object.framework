package bg.iliev.core;

import java.util.Collection;

import org.junit.Assert;

/**
 * 
 * Class that can simplify the provided assertions in class Assert. 
 * 
 * @author Iliya
 * @see {@link MultipleAssert}
 *
 */
public class AssertExtended extends Assert{

    /**
     * Asserts that a collection has specific size.
     * @param col
     * @param size
     */
    static public <E> void assertSize(Collection<E> col, int size) {
        assertEquals(null, size, col.size());
    }
    
    /**
     * Asserts that a collection has specific size.
     * @param msg
     * @param col
     * @param size
     */
    static public <E> void assertSize(String msg, Collection<E> col, int size) {
        assertEquals(msg, size, col.size());
    }
    
}
