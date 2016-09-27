package bg.iliev.core;

import java.util.Collection;

import org.junit.Assert;

public class AssertExtended extends Assert{

    /**
     * Asserts that a collection has specific size.
     * @param <E>
     * @param col
     * @param size
     */
    static public <E> void assertSize(Collection<E> col, int size) {
        assertEquals(null, size, col.size());
    }
}
