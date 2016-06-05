import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Console;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 31-03-2016.
 */
public class GenListXTest {

    private GenListX genListX;

    @Before
    public void testInit() throws Exception {
        genListX = new GenListX();
        assertNull(genListX.list); //check if the list is null before each test
    }

    @Test
    public void testAdd() throws Exception {
        genListX.add("one");
        genListX.add("two");
        genListX.add("three");
        assertEquals(3, genListX.size());
        assertEquals("two", genListX.get(1));
    }

    @Test
    public void testAddAtIndex() throws Exception {
        genListX.add(0,"");
        genListX.add(1,"second");
        genListX.add(2,"third");
        assertEquals(3, genListX.size());
        assertEquals("second", genListX.get(1));
        assertEquals("", genListX.get(0));
    }

    @Test
    public void testSize() throws Exception {
        genListX.add("");
        genListX.add("second");
        assertEquals(2, genListX.size());
        genListX.add("");
        assertEquals(3, genListX.size());
    }

    @Test
    public void testGet() throws Exception {
        genListX.add("first");
        genListX.add("second");
        assertEquals(2, genListX.size());
        assertEquals("first", genListX.get(0));
    }

    @Test
    public void testRemove() throws Exception {
        genListX.add("first");
        genListX.add("second");
        genListX.add("third");
        assertEquals("second", genListX.get(1));
        genListX.remove(1);
        assertEquals("third", genListX.get(1));
    }
}