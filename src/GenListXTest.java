import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    //TDD example
//    @Test
//    public void testDrivenDevelopment() throws Exception {
//        int i = genListX.testMePlease("123");
//        assertEquals(123, i);
//    }

    //Hamcrest Examples
    @Ignore
    @Test
    public void testUsingHamcrestShowingWhyItIsCool() throws Exception{
        List<String> values = new ArrayList<>();
        values.add("one");
        values.add("two");
        values.add("four");

        assertThat(values, containsInAnyOrder("one", "two", "three"));
    }

    @Ignore
    @Test
    public void testNotUsingHamcrestShowingWhyItIsCool() throws Exception {
        List<String> values = new ArrayList<>();
        values.add("one");
        values.add("two");
        values.add("four");

        assertEquals(Arrays.asList("one", "two", "three"), values);
    }
    ///////

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

    @Test
    public void testEmptyArray() throws Exception {
        assertEquals(0, genListX.size());
    }
}