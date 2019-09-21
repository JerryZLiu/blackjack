import java.util.*;
class Hand{
    ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
        drawRandomCard();
        drawRandomCard();
    }

    public void drawRandomCard(){

    }

    public void drawCard(Card c){
        hand.add(c);
    }

    public int valueOfHand(){
        int total = 0;
        //First push all aces to the back for easier calculation.
        hand.sort(new Comparator<Card>(){
            @Override
            public int compare(Card h1, Card h2) {
                if(h1 == Card.Ace){
                    return 1;
                } else{
                    return -1;
                }
            }
        });
        for(Card card: hand){
            switch (card) {
                case Ace:
                    if (total < 11) {
                        total += 11;
                    } else {
                        total += 1;
                    }
                    break;
                case Two:
                    total += 2;
                    break;
                case Three:
                    total += 3;
                    break;
                case Four:
                    total += 4;
                    break;
                case Five:
                    total += 5;
                    break;
                case Six:
                    total += 6;
                    break;
                case Seven:
                    total += 7;
                    break;
                case Eight:
                    total += 8;
                    break;
                case Nine:
                    total += 9;
                    break;
                case Ten:
                    total += 10;
                    break;
                case Jack:
                    total += 10;
                    break;
                case Queen:
                    total += 10;
                    break;
                case King:
                    total += 10;
                    break;
            }
        }
        return total;
    }

    enum Card{
        Ace("A"),
        Two("2"),
        Three("3"),
        Four("4"),
        Five("5"),
        Six("6"),
        Seven("7"),
        Eight("8"),
        Nine("9"),
        Ten("10"),
        Jack("J"),
        Queen("Q"),
        King("K");

        String rank;

        Card(String val){
            rank = val;
        }

    }
}