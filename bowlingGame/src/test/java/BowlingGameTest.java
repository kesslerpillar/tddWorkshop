import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    @Test
    public void scoreZeroWhenFailingAllTheRolls() {
        assertEquals(0, new BowlingGame().score("--------------------"));
    }

    @Test
    public void scoreOneWhenTheFirstRollThrowOnePinAndMissOtherRolls() {
        assertEquals(1, new BowlingGame().score("1-------------------"));
    }

    @Test
    public void scoreTwoWhenTheFirstRollThrowOnePinAndMissOtherRolls() {
        assertEquals(2, new BowlingGame().score("2-------------------"));
    }

    @Test
    public void scoreTwentyWhenAllRollsThrowOnePin() {
        assertEquals(20, new BowlingGame().score("11111111111111111111"));
    }
}