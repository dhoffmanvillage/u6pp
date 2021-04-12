package u6pp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Arrays;

public class YahtzeeTests {

    @Test
    void testGetScore() throws Exception {
        final int[] scores1 = {};
        final int[] scores2 = {-1, 2, 4, 10};
        final int[] scores3 = {-1, -1, -1, -1, -1};
        final int[] scores4 = {100, 200, 300};
        

        assertAll("Calculates appropriate score totals", 
            () -> assertEquals(0, Yahtzee.getScore(scores1)),
            () -> assertEquals(15, Yahtzee.getScore(scores2)),
            () -> assertEquals(-5, Yahtzee.getScore(scores3)),
            () -> assertEquals(600, Yahtzee.getScore(scores4))
        );
    }

    @Test
    void testGetScoresDoesNotAlterParameters() throws Exception {

        final int[] paramScores = {1, 1, 1, 1};
        final int[] copyScores = {1, 1, 1, 1};

        Yahtzee.getScore(paramScores);

        assertEquals(Arrays.toString(copyScores), Arrays.toString(paramScores));

    }

    @Test
    void testBeenUsed() throws Exception {
        final int[] scores = {23, 0, 2, 0, 1};

        assertAll("Yahtzee.beenUsed works correctly", 
            () -> assertTrue(Yahtzee.beenUsed(scores, 0)),
            () -> assertFalse(Yahtzee.beenUsed(scores, 1)),
            () -> assertTrue(Yahtzee.beenUsed(scores, 2)),
            () -> assertFalse(Yahtzee.beenUsed(scores, 3)),
            () -> assertTrue(Yahtzee.beenUsed(scores, 4))
        );
    }

    @Test
    void testBeenUsedDoesNotAlterParameters() throws Exception {

        final int[] paramScores = {1, 1, 1, 1};
        final int[] copyScores = {1, 1, 1, 1};

        Yahtzee.beenUsed(paramScores, 0);

        assertEquals(Arrays.toString(copyScores), Arrays.toString(paramScores));

    }

    @Test
    void testRollDice() throws Exception {
        final Dice[] diceToRoll1 = {new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};
        final Dice[] diceToRoll2 = {new Dice(), new Dice()};

        final boolean[] rollTheseDice1 = {false, false, false, false, false};
        final boolean[] rollTheseDice2 = {true, true};

        assertAll("Yahtzee.rollDice works as intended",
            () -> assertEquals(Arrays.toString(diceToRoll1), Arrays.toString(Yahtzee.rollDice(diceToRoll1, rollTheseDice1))),
            () -> assertNotEquals(Arrays.toString(diceToRoll2), Arrays.toString(Yahtzee.rollDice(diceToRoll2, rollTheseDice2)))
        );
    }

    @Test
    void testRollDiceDoesNotAlterParameters() throws Exception {

        final Dice[] diceToRoll = {new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};
        final boolean[] rollTheseDice = {false, false, false, false, false};
        final Dice[] copiedDice = {new Dice(), new Dice(), new Dice(), new Dice(), new Dice()};

        Yahtzee.rollDice(diceToRoll, rollTheseDice);

        assertEquals(Arrays.toString(copiedDice), Arrays.toString(diceToRoll));
    } 
}