import java.util.Scanner;
public class HumanPlayer{
  private Hand humHand;
  private double money;
  private boolean stand;
  private boolean playing = true;
  
  Scanner in = new Scanner( System.in );
  
  public HumanPlayer(){
    humHand = new Hand();
    money = 1000;
  }
  
  public void addCards(Cards card){
    humHand.addCards(card); 
  }
  
  public void printHand(){
    humHand.printHand(); 
  }
  
  public boolean playing(){
    return playing;
  }
  
    public Cards getCard1(){
    return humHand.getCard1();
  }
  
  public Cards getCard2(){
    return humHand.getCard2();
  }
  
  public double smallBlind(){
    money = money - 100;
    return 100;
  }
  
  public void clearHand(){
    humHand.clearHand();
  }
  
  public boolean stand(){
    String input;
    char i;            //so the program can compare the user input
    
    System.out.println("Do you want to stand? (y/n)");
    input = in.nextLine();
    i = input.charAt(0);
    
    if (i == 'y')
      stand = true;
    else{
      stand = false;
      playing = false;
    }
    return stand;
  }
  
  /*in a round of betting, a player can: check- only sometimes, does not put any money in pot
   * bet(call?): put in the minimum that previous players have set
   * raise: increase the size of the bet
   * fold: give up cards
   */
  public double betting(double bet){  
    String choice;
    double cost = 0;
    char c;
    System.out.println("What would you like to do?");       
    System.out.println("(call, raise, fold)");                                                      
    choice = in.nextLine();
    choice = choice.toLowerCase();
    c = choice.charAt(0);
    
    if (c == 'c'){             //if player calls, the bet value is subtracted and added to the pot
      money = money - bet;
      cost = bet;
    }
    else if (c == 'r'){                //if player raises, they can input by how much they would like to raise
      System.out.println("How much would you like to raise by? (only type in a number value)");
      String costString = in.nextLine();
      cost = Double.parseDouble(costString);
      if (cost <= 0){
        System.out.println("Please input a value greater than 0");
        cost = in.nextInt();
      }
      else{
        cost = cost + bet;
        money = money - cost;  //subtracts input value from player's money
      }
    }
    else{                   //if player folds, no money is taken, but the player is no longer playing that round
      playing = false;
    }
    return cost;
  }
  
  public double printMoney(){
    return money;
  }
  
  
  public int compareToCards(Cards flop1, Cards flop2, Cards flop3, Cards turn, Cards river, Cards hand1, Cards hand2){
    Cards[] playingCards = new Cards[7];
    playingCards[0] = flop1; 
    playingCards[1] = flop2;
    playingCards[2] = flop3;
    playingCards[3] = turn;
    playingCards[4] = river;
    playingCards[5] = hand1;
    playingCards[6] = hand2;
    
    for (int i = 1; i < playingCards.length; i++){            //sorts cards in numerical order
      if (playingCards[i].getNumber() < playingCards[i-1].getNumber()){
        Cards temp = playingCards[i];
        playingCards[i] = playingCards[i-1];
        playingCards[i-1] = temp;
      }
    }
    
    int sameSuit = 0;    //keeps track of how many cards have the same suit
    int changingNumber = 0;  //keeps track of how many cards are in increasing order
    int valueOfCards = 0;    //ranked each type of card hand from 0-800, highest value has best card combo
    int pairs = 0;
    
    boolean threeOfAKind = false;   //if there is a 3 of a kind, it can use this to check for a full house
    boolean combination = false;   //used to check if program needs to check for a high card (no combinations)
    boolean fullHouse = false;
    boolean fourOfAKind = false;
    boolean straightFlush = false;  
    
    for (int i = 0; i < playingCards.length-1; i++){   //check how many numbers are the same
      if (playingCards[i].getNumber() == playingCards[i+1].getNumber() && playingCards[i].getNumber() == playingCards[i+2].getNumber()){        
        if (playingCards[i].getNumber() == playingCards[i+3].getNumber()){
          valueOfCards = 700;  //4 of a kind has a value of 700
          combination = true;
          fourOfAKind = true;
        }
        else{
          threeOfAKind = true;
          valueOfCards = 300;   //3 of a kind has a value of 300
        }
      }
      else if (playingCards[i].getNumber() == playingCards[i+1].getNumber()){
        pairs ++; 
      }
    } //end of for-loop
    
    if (pairs == 1){
      if (threeOfAKind == true){
        valueOfCards = 600;       //three of a kind and a pair = full house, which has a value of 600
        combination = true;
        fullHouse = true;
      }
      else{
        valueOfCards = 100;   //a single pair has a value of 100
        combination = true;
      }
    }
    
    else if (pairs == 2){
      valueOfCards = 200;  //two pair has a value of 200
    }
    
    int indexNum = 0;
    
    for (int i = 0; i < playingCards.length-1; i++){    //check how many numbers are "in a row"
      if (playingCards[i].getNumber() == (playingCards[i+1].getNumber() + 1)){    
        changingNumber ++;
        indexNum = i;   //gets the index of the first number in the sequence of increasing numbers
      }
    }
    
    if(changingNumber == 4){
      for (int x = indexNum; x <= (indexNum + 3); x++){
        if (playingCards[x].getSuit() == playingCards[x+1].getSuit())
          sameSuit++;  
      }
      if (sameSuit == 4){  //all are same suit and increasing number
        valueOfCards = 800;   //straight flush has a value of 800 (highest possible combo)
        combination = true;
        straightFlush = true;
      }
      else{
        valueOfCards = 400;  //straight has a value of 400
        combination = true;
      }
    }
    
    if (fullHouse == false && fourOfAKind != true && straightFlush != true){  //check for a flush only if higher scoring combinations aren't present
      for (int i = 0; i < playingCards.length; i++){
        if (playingCards[i].getSuit() < playingCards[i-1].getSuit()){       //sorts suit in order by suit value
          Cards temp = playingCards[i];
          playingCards[i] = playingCards[i-1];
          playingCards[i-1] = temp;
        }
      }
      for (int k = 0; k < playingCards.length-1; k++){   //check how many numbers are the same
        if (playingCards[k].getSuit() == playingCards[k+1].getSuit() && playingCards[k].getSuit() == playingCards[k+2].getSuit()
              && playingCards[k].getSuit() == playingCards[k+3].getSuit() && playingCards[k].getSuit() == playingCards[k+4].getSuit()){        
          valueOfCards = 500;  //flush has a value of 500
          combination = true;
        }
      }
    }
    
    if (combination != true && threeOfAKind != true){  //if there are no combinations, check for the highest card
      valueOfCards = playingCards[playingCards.length].getNumber();
    }
    
    return valueOfCards;
    
  } //end of method
}