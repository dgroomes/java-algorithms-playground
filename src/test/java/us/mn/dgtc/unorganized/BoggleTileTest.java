package us.mn.dgtc.unorganized;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import us.mn.dgtc.BoggleTile;

import static org.junit.Assert.*;

/**
 * Created by David Groomes on 9/15/2015.
 */
public class BoggleTileTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(BoggleTile.class).verify();
    }
}