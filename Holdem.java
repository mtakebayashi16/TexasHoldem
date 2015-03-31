import java.util.Scanner;

public class Holdem{
  public static void main(String[] args) {
    Scanner user_input = new Scanner(System.in);
    int round = 0;   //checks what round the game is on (helps determine if more cards need to be played, etc)
    boolean lose = false;    //checks if player has lost the game
    
    System.out.println("Welcome to Texas Hold'em!");
    System.out.println("What is your name?");
    String playerName = user_input.next();
    
    
    do{                 //main loop
      playGame();
    } while(lose = false); 
  }
  
  private static void playGame(){
    Deck deck = new Deck();
    Cards firstOfHand, secondOfHand;
    
    deck.shuffle();
    firstOfHand = deck.deal();              //deals out two "hole cards" (the player's hand)
    secondOfHand = deck.deal();
    System.out.println("Your hand is: " + firstOfHand.getValueString() + " of " + firstOfHand.getSuitString() + " and "
                      + secondOfHand.getValueString() + " of " + secondOfHand.getSuitString());
    
        //first round of betting
    
        // "the flop" -- first three community cards revealed
    
        //second round of betting
    
        // "the turn" -- fourth community card is revealed
    
        //third round of betting
    
        // "the river" -- fifth (last) community card is revealed
    
        //fourth (last) round of betting
    
        //all player's hole cards are revealed
        //best hand wins the pot, or is divided between tied hands
    
  }   //end playGame
  
  private static void betting(){
    
    
  
  
  } //end betting
  
  
} //end of class