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
  
  public double firstRoundBet(){     //created a method for the first round since it will differ from other rounds (no house cards revealed)
   double bet = 0;
    if (this.stand() == true){
      
    }
    else{
      playing = false;
    } 
    return bet;
  }
  
 
  
  
  
  
}   //end of class