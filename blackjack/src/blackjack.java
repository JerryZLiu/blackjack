import java.util.Scanner;

class Blackjack{

    public static void main(String[] args){
        Scanner input = new Scanner(System. in);
        System.out.println("Welcome to Blackjack. Here's $100 dollars to start off with.");
        
        int playerCash = 100;
        while(playerCash > 0) {
        	System.out.println("How much would you like to bet? Enter it as a integer. You currently have $" + playerCash + ". Bet 0 if you'd like to cash out and stop playing.");
        	int bet = 0;
        	if (input.hasNextInt()) {
                bet = input.nextInt();
                if(bet < 0 || bet > playerCash) {
                	System.out.println("You made an invalid bet. Try again.");
                	continue;
                }
            } else {
                System.out.println("You made an invalid bet. Try again.");
                continue;
            }
        	Hand userHand = new Hand();
        	userHand.drawRandomCard();
        	userHand.drawRandomCard();
        	Hand dealerHand = new Hand();
        	dealerHand.drawRandomCard();
        	dealerHand.drawRandomCard();
        	String response;
        	do {
        		System.out.print("Your hand: ");
        		userHand.printHand();
        		
        		if(dealerHand.valueOfHand() == 21) {
        			System.out.println("Dealer got Blackjack! Here's their hand: ");
        			dealerHand.printHand();
        			System.out.println("You lose $" + bet);
        			playerCash -= bet;
        			break;
        		}
        		if(userHand.valueOfHand() == 21) {
        			System.out.println("You got Blackjack!");
        			System.out.println("You win $" + bet);
        			playerCash += bet;
        			break;
        		}
        		
        	} while(response.equals("hit"));
        }
        	
        System.out.println("Good game! You finished with $" + playerCash);
    }
}