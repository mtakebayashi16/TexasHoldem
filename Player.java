/* creates an AI player for the poker game
 */ 

public class Player{
 private myHand1, myHand2;
 private int winChance = 178;  //determines if chance of winning is over 50%, found by multiplying the queen value by 14 and adding the value of a jack
                               //(I googled it and found this: "a High Card hand with a Q and J beats 50% of the other possible hands")
 
  public Player(){
    myHand1 = deck.deal();    //creates computers "hole cards" (player's hand)
    myHand2 = deck.deal();
  }
  
  public boolean stand(){
    return(
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
}   //end of class