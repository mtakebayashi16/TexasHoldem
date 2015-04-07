/* creates an AI player for the poker game
 */ 

public class ComputerPlayer{
  private Hand compHand;
  private int winChance = 178;  //determines if chance of winning is over 50%, found by multiplying the queen value by 14 and adding the value of a jack
  //(I googled it and found this: "a High Card hand with a Q and J beats 50% of the other possible hands")
  private double money;
  private boolean playing = true;
  
  public ComputerPlayer(){
    compHand = new Hand();    //creates computers "hole cards" (player's hand)
    money = 1000;
  }
  
  public void addCards(Cards card){
    compHand.addCards(card); 
  }
  
  public double printMoney(){
    return money;
  }
  
  public void printHand(){
    compHand.printHand(); 
  }
  
  public boolean stand(){
    return(compHand.value() >= winChance);
  }
  
  public Cards getCard1(){
    return compHand.getCard1();
  }
  
  public Cards getCard2(){
    return compHand.getCard2();
  }
  
  public double bigBlind(){
   money = money - 200;
   return 200;
  }
  
  public double smallBlind(){
   money = money - 100;
   return 100;
  }
  
  public double firstRoundBet(double betVal, double potVal){     //created a method for the first round since it will differ from other rounds (no house cards revealed)
    double bet = 0;
    if (this.stand() == true){
      if (compHand.value() >= 190){      //raise, chose a random numerical value for the cards to be higher then (king value * 14 + queen value)
        money = money - (potVal * 0.3);   //raises by 30% of the pot's value
        bet = (potVal * 0.3) + betVal;
        System.out.println("Player raises by " + (potVal * 0.3));
      }
      else{                            //call
        money = money - betVal;
        bet = betVal;
        System.out.println("Player calls");
      }
    }
    else{
      playing = false;                //fold cards
      System.out.println("Player folds");
    } 
    return bet;
  }
  
  public double secondRoundBet(Cards flop1, Cards flop2, Cards flop3, Cards hand1, Cards hand2, double betVal, double potVal){
    double bet = 0; 
    Cards[] playingCards = new Cards[4];
    playingCards[0] = flop1; 
    playingCards[1] = flop2;
    playingCards[2] = flop3;
    playingCards[3] = hand1;
    playingCards[4] = hand2;
    
    for (int i = 1; i < playingCards.length; i++){            //sorts cards in numerical order
      if (playingCards[i].getNumber() < playingCards[i-1].getNumber()){
        Cards temp = playingCards[i];
        playingCards[i] = playingCards[i-1];
        playingCards[i-1] = temp;
      }
    }
    
    int sameSuit = 0;    //keeps track of how many cards have the same suit
    int pair = 0;      //keeps track of how many pairs there are
    int changingNumber = 0;  //keeps track of how many cards are in increasing order
    int valueofCards = 0;
      
    for (int i = 0; i < playingCards.length-1; i++){   //check how many numbers are the same
      if (playingCards[i].getNumber() == playingCards[i+1].getNumber()){        
        pair ++;
      }
    }
    for (int i = 0; i < playingCards.length-1; i++){    //check how many numbers are "in a row"
      if (playingCards[i].getNumber() == (playingCards[i+1].getNumber() + 1)){    
        changingNumber ++;     
      }
    }
      
     for (int i = 0; i < playingCards.length; i++){       //check how many suits are the same
       for (int j = 1; j < playingCards.length; j++){
         if (playingCards[i].getSuit() == playingCards[j].getSuit()){
          sameSuit++; 
         }
       }
     }
     
     sameSuit = sameSuit - 4; //using the nested four loops will still have 4 times where the card is compared against itself
    
    if (changingNumber == 2)        //creates a "value" that approximates how strong the hand is
      valueofCards += 100;
     else if (changingNumber > 2)
      valueofCards += 200;
     else
       valueofCards +=0;
     
     if (sameSuit >=3)
       valueofCards +=200;
     
     valueofCards = (pair * 200); 
     if (hand1.getNumber() > hand2.getNumber())
       valueofCards += hand1.getNumber();
     else
       valueofCards += hand2.getNumber();
     
     if (valueofCards > 200){
       if (valueofCards > 400){
          money = money - (potVal * 0.3);   //raises by 30% of the pot's value
        bet = (potVal * 0.3) + betVal;
        System.out.println("Player raises by " + (potVal * 0.3));
       }
       else{                        //call
        money = money - betVal;
        bet = betVal;
        System.out.println("Player calls"); 
       }
     }
     else{ 
      playing = false;                //fold cards
      System.out.println("Player folds");
     }
    
    return bet;  
  }
  
  public boolean playing(){
    return playing;
  }
  
  
  
  
}   //end of class