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
    firstOfHand = deck.deal();
    secondOfHand = deck.deal();
    System.out.println("Your hand is: " + firstOfHand.getValueString() + " of " + firstOfHand.getSuitString() + " and "
                      + secondOfHand.getValueString() + " of " + secondOfHand.getSuitString());
    
  }   //end playGame
  
  
} //end of class