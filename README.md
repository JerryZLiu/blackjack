# blackjack

# How to Run

This is a version of Blackjack coded in Java. In order to prevent card counting, the probability of getting any rank of card is equal the whole time. The game follows the classic rules of Blackjack. It's a one player game - you face off against the dealer (computer).

You can run the game by cloning this project, then navigating to the blackjack project.

`Jerrys-MacBook-Pro-5:~ jerry$ cd blackjack/`

Then compile the java files

`Jerrys-MacBook-Pro-5:blackjack jerry$ javac src/*.java`

Then run Blackjack

`Jerrys-MacBook-Pro-5:blackjack jerry$ java src.Blackjack`

# Testing

The JUnit tests, which test the Hand class, are more difficult to run via command line because there are a host of dependencies that may not be exist on your computer. Instead, if you'd like to run them and verify the results, I recommend opening Eclipse/Intellij and running the tests from there.

# Design Choices

I chose to divide the project into two main classes, one that keeps track of the hand of each player, and the main blackjack class that contains most of the logic of the game. There's a lot of boilerplate to be done with tracking cards, calculating values of hands, and printing out the contents of hands, which is why I chose to seperate it out. The algorithm for calculating the hand value was more involved than I anticipated, as determing the value of the Ace card requires first summing the other cards. The data structures were very straightforward, I used enums for the cards and an ArrayList to hold player's hands.

# Choice of language/tools

I picked Java since it's the langauge I'm most familiar with. JUnit for tests since it's the built in option for Eclipse. Didn't really need to use any external libraries. 
