package u6pp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BlackjackTests {

    private static Card[] hand1 = {}, hand2 = { new Card("Clubs", "Ace"), new Card("Spades", "Jack") },
            hand3 = { new Card("Clubs", "2"), new Card("Diamonds", "10"), new Card("Spades", "7") },
            hand4 = { new Card("Clubs", "2"), new Card("Diamonds", "10"), new Card("Spades", "7"),
                    new Card("Diamonds", "Ace"), new Card("Hearts", "3") },
            hand5 = { new Card("Clubs", "2"), new Card("Diamonds", "10"), new Card("Spades", "9") },
            hand6 = { new Card("Clubs", "2"), new Card("Diamonds", "10"), new Card("Spades", "4") },
            hand7 = { new Card("Diamonds", "10"), new Card("Spades", "7"), new Card("Hearts", "3") };

    @Test
    void testCalcPoints() throws Exception {

        assertAll("Calculates appropriate hand totals", () -> assertEquals(0, Blackjack.calcPoints(hand1)),
                () -> assertEquals(21, Blackjack.calcPoints(hand2)),
                () -> assertEquals(19, Blackjack.calcPoints(hand3)),
                () -> assertEquals(33, Blackjack.calcPoints(hand4)));
    }

    @Test
    void testIsBust() throws Exception {
        assertAll("Correctly determines if a hand is a bust or not", () -> assertFalse(Blackjack.isBust(hand1)),
                () -> assertFalse(Blackjack.isBust(hand2)), () -> assertFalse(Blackjack.isBust(hand3)),
                () -> assertTrue(Blackjack.isBust(hand4)));
    }

    @Test
    void testIsBlackjack() throws Exception {

        assertAll("Correctly determines if a hand is a Blackjack or not",
                () -> assertFalse(Blackjack.isBlackjack(hand1)), () -> assertTrue(Blackjack.isBlackjack(hand2)),
                () -> assertFalse(Blackjack.isBlackjack(hand4)), () -> assertFalse(Blackjack.isBlackjack(hand5)));
    }

    @Test
    void testDealerKeepHitting() throws Exception {

        assertAll("Correctly determines if a dealer should keep hitting",
                () -> assertTrue(Blackjack.dealerKeepHitting(hand1)),
                () -> assertFalse(Blackjack.dealerKeepHitting(hand2)),
                () -> assertFalse(Blackjack.dealerKeepHitting(hand4)),
                () -> assertTrue(Blackjack.dealerKeepHitting(hand6)));
    }

    @Test
    void testDetermineResult() throws Exception {

        assertAll("Correctly determines the comparison of two hands",
                () -> assertEquals("User Loses", Blackjack.determineResult(hand1, hand2)),
                () -> assertEquals("User Loses", Blackjack.determineResult(hand6, hand7)),
                () -> assertEquals("User Wins", Blackjack.determineResult(hand2, hand7)),
                () -> assertEquals("User Wins", Blackjack.determineResult(hand7, hand6)),
                () -> assertEquals("User Pushes", Blackjack.determineResult(hand2, hand2)),
                () -> assertEquals("User Pushes", Blackjack.determineResult(hand7, hand7)));
    }

}