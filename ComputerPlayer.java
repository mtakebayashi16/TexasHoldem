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
  
  public double firstRoundBet(double betVal, double potVal){     //created a method for the first round since it will differ from other rounds (no house cards revealed)
   double bet = 0;
    if (this.stand() == true){
      if (compHand.value() >= 190){      //raise, chose a random numerical value for the cards to be higher then (king value * 14 + queen value)
        money = money - (potVal * 0.3);
        bet = (potVal * 0.3) + betVal;
      }
      else{                            //call
        money = money - betVal;
        bet = betVal;
      }
    }
    else{
      playing = false;                //fold cards
    } 
    return bet;
  }
  
 
  
  
  
  
}   //end of class