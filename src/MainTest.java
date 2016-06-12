import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 07-03-2016.
 */
@RunWith(value = Parameterized.class)
public class MainTest {

    private int day,month,year;
    private String expected;

    public MainTest(int day, int month, int year, String expected){
        this.day = day;
        this.month = month;
        this.year = year;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Input {0}/{1}/{2}, Result {3}")
    public static Iterable<Object[]> data1(){
        return Arrays.asList(new Object[][]{

                //Leap year test cases
                {28,2,1990,"1/3/1990"},
                {28,2,2000, "29/2/2000"},
                {29,2,2000,"1/3/2000"},
                {28,2,1900,"1/3/1900"},

                //Test cases for 'day' boundry values
                {31,12,2012,"1/1/2013"},
                {32,12,2012,"Bad input!"},
                {30,11,2012,"1/12/2012"},
                {31,11,2012,"Bad input!"},
                {0,10,2010,"Bad input!"},
                {1,10,2010,"2/10/2010"},

                //Test cases for 'month' boundry values
                {20,0,2012,"Bad input!"},
                {20,1,2012,"21/1/2012"},
                {10,12,2010,"11/12/2010"},
                {10,13,2010,"Bad input!"},

                //Test cases for 'year' boundry values
                {30,12,2014,"31/12/2014"},
                {30,12,2015,"Bad input!"},
                {30,12,1812,"31/12/1812"},
                {30,12,1811,"Bad input!"},

                //Test cases for equivalence partitioning
                {10,6,2001,"11/6/2001"},
                {15,12,2001,"16/12/2001"},
                {10,12,1913,"11/12/1913"},

                //Negative input test cases
                {-12,2,2016,"Bad input!"},
                {12,-12,2001,"Bad input!"},
                {28,12,-1000,"Bad input!"}
        });
    }

    @Test
    public void testGetNextDayValidInput() throws Exception {
        assertEquals(expected, Main.getNextDay(day,month,year));
    }
}