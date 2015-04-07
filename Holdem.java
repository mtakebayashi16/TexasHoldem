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
    double bet = 20;        //minimum bet starts at $20
    double value;
    
    Deck deck = new Deck();
    Pot pot = new Pot();
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
    
    System.out.println(" ");                                 // to add an extra line in the output since there was no spacing between the two lines
    System.out.println("You have $" + person.printMoney());
    
    
    value = person.betting(bet);     //player first round of betting
    pot.addToPot(value);     
    
    double potVal = pot.potValue();
    
    comp1.firstRoundBet(20, potVal);     //computer 1st round betting
    comp2.firstRoundBet(20, potVal);
    comp3.firstRoundBet(20, potVal);
    comp4.firstRoundBet(20, potVal);
    
    Cards flop1 = deck.deal();  // "the flop" -- first three community cards revealed
    Cards flop2 = deck.deal();
    Cards flop3 = deck.deal();
    System.out.println("Community Cards: " + flop1.getNumberString() + " of " + flop1.getSuitString()
                      + ", " + flop2.getNumberString() + " of " + flop2.getSuitString()
                      + ", and " + flop3.getNumberString() + " of " + flop3.getSuitString());
    
    if (person.playing() == true){   //player second round of betting
    value = person.betting(bet);
    pot.addToPot(value);
    }
    else { 
    }
    
    
    /* ADD COMPUTER BETTING */  //computer 2nd round betting
    
    Cards turn = deck.deal();  // "the turn" -- fourth community card is revealed
    System.out.println("Community Cards: " + flop1.getNumberString() + " of " + flop1.getSuitString()
                      + ", " + flop2.getNumberString() + " of " + flop2.getSuitString()
                      + ", " + flop3.getNumberString() + " of " + flop3.getSuitString()
                      + ", and " + turn.getNumberString() + " of " + turn.getSuitString());
    
    if (person.playing() == true){     //player third round of betting
    bet = 40;
    value = person.betting(bet);
    pot.addToPot(value);
    }
    else {
      
    }
    
    /* ADD COMPUTER BETTING */      //computer 3rd round betting
    
    Cards river = deck.deal();    // "the river" -- fifth (last) community card is revealed
    System.out.println("Community Cards: " + flop1.getNumberString() + " of " + flop1.getSuitString()
                      + ", " + flop2.getNumberString() + " of " + flop2.getSuitString()
                      + ", " + flop3.getNumberString() + " of " + flop3.getSuitString()
                      + ", " + turn.getNumberString() + " of " + turn.getSuitString()
                      + ", and " + river.getNumberString() + " of " + river.getSuitString());
    
    if (person.playing() == true){       //player fourth (last) round of betting
    bet = 40;
    value = person.betting(bet);
    pot.addToPot(value);
    }
    else {
      
    }
    
    /* ADD COMPUTER BETTING */  //computer 4th round betting
    
     System.out.println("Community Cards: " + flop1.getNumberString() + " of " + flop1.getSuitString()     //all player's hole cards are revealed
                      + ", " + flop2.getNumberString() + " of " + flop2.getSuitString()
                      + ", " + flop3.getNumberString() + " of " + flop3.getSuitString()
                      + ", " + turn.getNumberString() + " of " + turn.getSuitString()
                      + ", and " + river.getNumberString() + " of " + river.getSuitString());    
     System.out.println("Your hand is: ");
     person.printHand();
     System.out.println(" ");
     System.out.println("Player 1's hand is: ");
     comp1.printHand();
     System.out.println(" ");
     System.out.println("Player 2's hand is: ");
     comp2.printHand();
     System.out.println(" ");
     System.out.println("Player 3's hand is: ");
     comp3.printHand();
     System.out.println(" ");
     System.out.println("Player 4's hand is: ");
     comp4.printHand();
     
    //best hand wins the pot, or is divided between tied hands
    
  }   //end playGame
  
  
  
} //end of class