package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.Hand;
import src.Hand.Card;

class handtest {

	@Test
	void testHandCalculation() {
		// A K = 21
		Hand hand = new Hand();
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.King);
		assertEquals(hand.valueOfHand(), 21);
		
		// A A = 12
		hand = new Hand();
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		assertEquals(hand.valueOfHand(), 12);
		
		// A A A A A A A A A A A = 21
		hand = new Hand();
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		hand.drawCard(Card.Ace);
		assertEquals(hand.valueOfHand(), 21);
		
		// 2 3 5 K = 20
		hand = new Hand();
		hand.drawCard(Card.Two);
		hand.drawCard(Card.Three);
		hand.drawCard(Card.Five);
		hand.drawCard(Card.King);
		assertEquals(hand.valueOfHand(), 20);
		
		// K J 2 = 22
		hand = new Hand();
		hand.drawCard(Card.King);
		hand.drawCard(Card.Jack);
		hand.drawCard(Card.Two);
		assertEquals(hand.valueOfHand(), 22);
	}

}
