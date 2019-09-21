package src;

import java.util.Scanner;

class Blackjack {

	public static void main(String[] args){
        Scanner input = new Scanner(System. in);
        System.out.println("Welcome to Blackjack. Here's $100 dollars to start off with.");
        
        int playerCash = 100;
        while(playerCash > 0) {
        	System.out.println("How much would you like to bet? Enter it as a integer. You currently have $" + playerCash + ". Bet 0 if you'd like to cash out and stop playing.");
        	int bet = 0;
        	boolean invalidBet = true;
        	while(invalidBet) {
	        	try {
	        		bet = Integer.parseInt(input.nextLine());
	                if(bet < 0 || bet > playerCash) {
	                	System.out.println("You made an invalid bet. Try again.");
	                	
	                }else {
	                	invalidBet = false;
	                }
	        	} catch(Exception e) {
	        		System.out.println("You made an invalid bet. Try again.");
	        	}
        	}
        	
        	if(bet == 0) {
        		break;
        	}
        	
        	Hand userHand = new Hand();
        	userHand.drawRandomCard();
        	userHand.drawRandomCard();
        	Hand dealerHand = new Hand();
        	dealerHand.drawRandomCard();
        	dealerHand.drawRandomCard();
        	String response;

        	System.out.print("Your hand: ");
        	userHand.printHand();

        	if(dealerHand.valueOfHand() == 21) {
        		System.out.println("Dealer got Blackjack! Here's their hand: ");
        		dealerHand.printHand();
        		System.out.println("You lose $" + bet);
        		playerCash -= bet;
        		continue;
        	}
        	if(userHand.valueOfHand() == 21) {
        		System.out.println("You got Blackjack!");
        		System.out.println("You win $" + bet);
        		playerCash += bet;
        		continue;
        	}

        	// Let the player add additional cards
        	do {
        		System.out.println("Type 'hit' if you want another card, otherwise type 'hold'.");
	        	response = input.nextLine().trim().toLowerCase();
	        	if(response.equals("hit")) {
	        		System.out.println("You drew: " + userHand.drawRandomCard().rank);
	        		System.out.print("Your hand: ");
	        		userHand.printHand();
	        		if(userHand.valueOfHand() > 21) {
	        			System.out.println("You busted! You lose $" + bet);
	        			playerCash -= bet;
	        			break;
	        		}
	        	} 
        	} while(response.equals("hit"));
        	
        	if(userHand.valueOfHand() > 21){
        		continue;
        	}
        	
        	// Dealer hits until > 16
        	while(dealerHand.valueOfHand() <= 16) {
        		System.out.println("Dealer drew: " + dealerHand.drawRandomCard().rank);
        		if(dealerHand.valueOfHand() > 21) {
        			System.out.println("Dealer busted! You win $" + bet);
        			playerCash += bet;
        			break;
        		}
        	}
        	
        	if(dealerHand.valueOfHand() > 21){
        		continue;
        	}
        	
        	//Print out final hands
        	System.out.print("Your hand: ");
    		userHand.printHand();
    		System.out.print("Dealer's hand: ");
    		dealerHand.printHand();
    		
        	if(dealerHand.valueOfHand() >= userHand.valueOfHand()) {
        		System.out.println("Dealer wins! You lose $" + bet);
        		playerCash -= bet;
        	} else {
        		System.out.println("You win! You won $" + bet);
        		playerCash += bet;
        	}
        }
        input.close();
        System.out.println("Good game! You finished with $" + playerCash);
    }
}