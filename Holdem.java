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
    ComputerPlayer comp1 = new ComputerPlayer();
    ComputerPlayer comp2 = new ComputerPlayer();
    ComputerPlayer comp3 = new ComputerPlayer();
    ComputerPlayer comp4 = new ComputerPlayer();
    HumanPlayer person = new HumanPlayer();
    
    deck.shuffle();
    
    for (int i = 0; i < 2; i++){           //deals out "hole cards" (the player's hand)
     person.addCards(deck.deal());
     comp1.addCards(deck.deal());
     comp2.addCards(deck.deal());
     comp3.addCards(deck.deal());
     comp4.addCards(deck.deal());
    }
    
    System.out.println("Your hand is: ");
    person.printHand();         //was having trouble since I was putting this in the println statement, figured out that it doesnt need to be
                                //there since the method has a println statement inside it already
     
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
  
  
  
} //end of class