import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jonas on 02-04-2016.
 */
public class PlayerTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void takeTurn() throws Exception {
        final Player player = context.mock(Player.class);

        //Get value of dice roll
        context.checking(new Expectations(){{
            oneOf(player).getFaceValue();
            will(returnValue(8));
        }});

        final int diceRoll = player.getFaceValue();
        assertEquals(diceRoll, 8);

        //Get value of the current location of the piece
        context.checking(new Expectations(){{
            oneOf(player).getLocation();
            will(returnValue(23));
        }});

        final int oldLocation = player.getLocation();
        assertEquals(oldLocation, 23);

        //Get value of new location
        context.checking(new Expectations(){{
            oneOf(player).getSquare(oldLocation, diceRoll);
            will(returnValue(31));
        }});

        final int square = player.getSquare(oldLocation, diceRoll);
        assertEquals(square, 31);

        //Set value of new location
        context.checking(new Expectations(){{
            oneOf(player).setLocation(square);
        }});

        player.setLocation(square);

    }

}