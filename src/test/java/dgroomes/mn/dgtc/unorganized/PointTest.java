package dgroomes.mn.dgtc.unorganized;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import dgroomes.Point;

/**
 * Created by David Groomes on 9/15/2015.
 */
public class PointTest {

    @Test
    public void testEquals() throws Exception {
        EqualsVerifier.forClass(Point.class).verify();
    }
}
