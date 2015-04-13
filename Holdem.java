import java.util.Scanner;

public class Holdem{
  public static void main(String[] args) {
    Scanner user_input = new Scanner(System.in);
    int round = 0;   //checks what round the game is on (helps determine if more cards need to be played, etc)
    boolean playerLose = false;    //checks if player has lost the game
    
    
    System.out.println("Welcome to Texas Hold'em!");
    System.out.println("What is your name?");
    String playerName = user_input.next();
    
    Deck deck = new Deck();
    Pot pot = new Pot();
    ComputerPlayer comp1 = new ComputerPlayer();
    ComputerPlayer comp2 = new ComputerPlayer();
    ComputerPlayer comp3 = new ComputerPlayer();
    ComputerPlayer comp4 = new ComputerPlayer();
    HumanPlayer person = new HumanPlayer();
    
    
    do{                 //main loop
      
      playerLose = playGame(comp1, comp2, comp3, comp4, person, pot, playerName);
      
    } while(playerLose == false); 
  }             //end of main loop
  
  private static boolean playGame(ComputerPlayer comp1, ComputerPlayer comp2, ComputerPlayer comp3, ComputerPlayer comp4, HumanPlayer person, Pot pot, String playerName){
    double bet = 20;        //minimum bet starts at $20
    double value;
    
    Deck deck = new Deck();
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
    
    double initialValue = comp1.bigBlind();
    pot.addToPot(initialValue);
    
    initialValue = comp2.smallBlind();
    pot.addToPot(initialValue);
    
    initialValue = comp3.smallBlind();
    pot.addToPot(initialValue);
    
    initialValue = comp4.smallBlind();
    pot.addToPot(initialValue);
    
    initialValue = person.smallBlind();
    pot.addToPot(initialValue);
    
    System.out.println(" ");                                 // to add an extra line in the output since there was no spacing between the two lines
    printStatements(comp1, comp2, comp3, comp4, person, pot);
    
    value = person.betting(bet);     //player first round of betting
    pot.addToPot(value);     
    
    double potVal = pot.potValue();
    
    if (comp1.playing() == true){     //computer 1st round betting
      bet = 20;
      value = comp1.firstRoundBet(20, potVal);
      pot.addToPot(value);
    }
    
    
    if (comp2.playing() == true){     
      bet = 20;
      value = comp2.firstRoundBet(20, potVal);
      pot.addToPot(value);
    }
    
    
    if (comp3.playing() == true){     
      bet = 20;
      value = comp3.firstRoundBet(20, potVal);
      pot.addToPot(value);
    }
    
    
    if (comp4.playing() == true){     //computer 1st round betting
      bet = 20;
      value = comp4.firstRoundBet(20, potVal);
      pot.addToPot(value);
    }
    
    checkPlayerMoney(person);  //game stops if player is out of money
    
    Cards flop1 = deck.deal();  // "the flop" -- first three community cards revealed
    Cards flop2 = deck.deal();
    Cards flop3 = deck.deal();
    System.out.println("Community Cards: " + flop1.getNumberString() + " of " + flop1.getSuitString()
                         + ", " + flop2.getNumberString() + " of " + flop2.getSuitString()
                         + ", and " + flop3.getNumberString() + " of " + flop3.getSuitString());
    printStatements(comp1, comp2, comp3, comp4, person, pot);
    
    if (person.playing() == true){   //player second round of betting
      value = person.betting(bet);
      pot.addToPot(value);
    }
    
    
    if (comp1.playing() == true){   //computer 2nd round betting
      value = comp1.secondRoundBet(flop1, flop2, flop3, comp1.getCard1(), comp1.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    
    if (comp2.playing() == true){  
      value = comp2.secondRoundBet(flop1, flop2, flop3, comp2.getCard1(), comp2.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    
    if (comp3.playing() == true){  
      value = comp3.secondRoundBet(flop1, flop2, flop3, comp3.getCard1(), comp3.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    
    if (comp4.playing() == true){   
      value = comp4.secondRoundBet(flop1, flop2, flop3, comp4.getCard1(), comp4.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    checkPlayerMoney(person);  //game stops if player is out of money
    
    Cards turn = deck.deal();  // "the turn" -- fourth community card is revealed
    System.out.println("Community Cards: " + flop1.getNumberString() + " of " + flop1.getSuitString()
                         + ", " + flop2.getNumberString() + " of " + flop2.getSuitString()
                         + ", " + flop3.getNumberString() + " of " + flop3.getSuitString()
                         + ", and " + turn.getNumberString() + " of " + turn.getSuitString());
    printStatements(comp1, comp2, comp3, comp4, person, pot);
    
    if (person.playing() == true){     //player third round of betting
      bet = 40;
      value = person.betting(bet);
      pot.addToPot(value);
    }
    
    
    if (comp1.playing() == true){   //computer 3rd round betting
      value = comp1.thirdRoundBet(flop1, flop2, flop3, turn, comp1.getCard1(), comp1.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    
    if (comp2.playing() == true){   
      value = comp2.thirdRoundBet(flop1, flop2, flop3, turn, comp2.getCard2(), comp2.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    
    if (comp3.playing() == true){   
      value = comp3.thirdRoundBet(flop1, flop2, flop3, turn, comp3.getCard2(), comp3.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    
    if (comp4.playing() == true){   
      value = comp4.thirdRoundBet(flop1, flop2, flop3, turn, comp4.getCard2(), comp4.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    checkPlayerMoney(person);  //game stops if player is out of money
    
    Cards river = deck.deal();    // "the river" -- fifth (last) community card is revealed
    System.out.println("Community Cards: " + flop1.getNumberString() + " of " + flop1.getSuitString()
                         + ", " + flop2.getNumberString() + " of " + flop2.getSuitString()
                         + ", " + flop3.getNumberString() + " of " + flop3.getSuitString()
                         + ", " + turn.getNumberString() + " of " + turn.getSuitString()
                         + ", and " + river.getNumberString() + " of " + river.getSuitString());
    printStatements(comp1, comp2, comp3, comp4, person, pot);
    
    if (person.playing() == true){       //player fourth (last) round of betting
      bet = 40;
      value = person.betting(bet);
      pot.addToPot(value);
    }
    
    if (comp1.playing() == true){      //computer 4th round betting
      value = comp1.fourthRoundBet(flop1, flop2, flop3, turn, river, comp1.getCard2(), comp1.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    if (comp2.playing() == true){     
      value = comp2.fourthRoundBet(flop1, flop2, flop3, turn, river, comp2.getCard2(), comp2.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    
    if (comp3.playing() == true){     
      value = comp3.fourthRoundBet(flop1, flop2, flop3, turn, river, comp3.getCard2(), comp3.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    
    if (comp4.playing() == true){     
      value = comp4.fourthRoundBet(flop1, flop2, flop3, turn, river, comp4.getCard2(), comp4.getCard2(), bet, potVal);;
      pot.addToPot(value);
    }
    
    checkPlayerMoney(person);  //game stops if player is out of money
    
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
    System.out.println(" ");
    
    int pHand = person.compareToCards(flop1, flop2, flop3, turn, river, person.getCard1(), person.getCard2()); //best hand wins the pot, or is divided between tied hands
    int c1 = comp1.compareToCards(flop1, flop2, flop3, turn, river, comp1.getCard1(), comp1.getCard2());
    int c2 = comp2.compareToCards(flop1, flop2, flop3, turn, river, comp2.getCard1(), comp2.getCard2());
    int c3 = comp3.compareToCards(flop1, flop2, flop3, turn, river, comp3.getCard1(), comp3.getCard2());
    int c4 = comp4.compareToCards(flop1, flop2, flop3, turn, river, comp4.getCard1(), comp4.getCard2());
    
    if (pHand >= c1 && pHand >= c2 && pHand >= c3 && pHand >= c4 && person.playing() == true){       //give pot to best hand
      if (pHand == c1){
        person.getMoney(pot.potValue()/2);
        comp1.getMoney(pot.potValue()/2);
        
      } 
      else if(pHand == c2){                     //divides pot if there is a tie
        person.getMoney(pot.potValue()/2);
        comp2.getMoney(pot.potValue()/2);
      }
      else if(pHand == c3){
        person.getMoney(pot.potValue()/2);
        comp3.getMoney(pot.potValue()/2);
      }
      else if(pHand == c4){
        person.getMoney(pot.potValue()/2);
        comp4.getMoney(pot.potValue()/2);
      }
      else{
        person.getMoney(pot.potValue());
        System.out.println(playerName + " wins the round!");
      }
    }
    
    else if (c1 > pHand && c1 >= c2 && c1 >= c3 && c1 >= c4 && comp1.playing() == true){   
      if(c1 == c2){                     
        comp1.getMoney(pot.potValue()/2);
        comp2.getMoney(pot.potValue()/2);
      }
      else if(c1 == c3){
        comp1.getMoney(pot.potValue()/2);
        comp3.getMoney(pot.potValue()/2);
      }
      else if(c1 == c4){
        comp1.getMoney(pot.potValue()/2);
        comp4.getMoney(pot.potValue()/2);
      }
      else{
        comp1.getMoney(pot.potValue());
        System.out.println("Player1 wins the round!");
      }
    }
    
    else if (c2 > pHand && c2 >= c3 && c2 >= c4 && comp2.playing() == true){       
       if(c2 == c3){
        comp2.getMoney(pot.potValue()/2);
        comp3.getMoney(pot.potValue()/2);
      }
      else if(c2 == c4){
        comp2.getMoney(pot.potValue()/2);
        comp4.getMoney(pot.potValue()/2);
      }
      else{
        comp2.getMoney(pot.potValue());
        System.out.println("Player2 wins the round!");
      }
    }
    
    else if (c3 > pHand && c3 > c2 && c3 >= c4 && comp3.playing() == true){       
      if(c4 == c3){
        comp3.getMoney(pot.potValue()/2);
        comp4.getMoney(pot.potValue()/2);
      }
      else{
        comp3.getMoney(pot.potValue());
        System.out.println("Player3 wins the round!");
      }
    }
    
    else if (c4 > pHand && c4 > c2 && c4 > c3 && comp4.playing() == true){       
      comp3.getMoney(pot.potValue());
      System.out.println("Player4 wins the round!");
    }
    
    pot.clearPot();
    printStatements(comp1, comp2, comp3, comp4, person, pot);
    
    person.clearHand();
    comp1.clearHand();
    comp2.clearHand();
    comp3.clearHand();
    comp4.clearHand();
    deck.clearDeck();
    
    if (person.printMoney() <= 0){
      System.out.println(" ");
      System.out.println(" ");
      System.out.println("You lost the game!");
      return true;
    }
    else{
      System.out.println(" ");
      System.out.println(" ");
      System.out.println("******* NEXT ROUND *******");
      System.out.println(" ");
      return false;
    }
  }   //end playGame
  
  public static void printStatements(ComputerPlayer comp1, ComputerPlayer comp2, ComputerPlayer comp3, ComputerPlayer comp4, HumanPlayer person, Pot pot){
    System.out.println("Player 1 has $" + comp1.printMoney());    
    System.out.println("Player 2 has $" + comp2.printMoney());
    System.out.println("Player 3 has $" + comp3.printMoney());
    System.out.println("Player 4 has $" + comp4.printMoney());
    System.out.println("You have $" + person.printMoney());
    System.out.println("There is $" + pot.potValue() + " in the pot");
  }
  
  public static void checkPlayerMoney(HumanPlayer person){
    if (person.printMoney() <= 0){
      System.out.println(" ");
      System.out.println(" ");
      throw new IllegalStateException("You lost the game!");
      
    }
  }
  
  
  
} //end of class