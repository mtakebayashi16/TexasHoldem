/* creates an AI player for the poker game
 */ 

public class ComputerPlayer{
 private Hand compHand;
 private int winChance = 178;  //determines if chance of winning is over 50%, found by multiplying the queen value by 14 and adding the value of a jack
                               //(I googled it and found this: "a High Card hand with a Q and J beats 50% of the other possible hands")
 
  public ComputerPlayer(){
    compHand = new Hand();    //creates computers "hole cards" (player's hand)
  }
  
  public void addCards(Cards card){
   compHand.addCards(card);
    
  }
  
  public boolean stand(){
    return(compHand.value() >= winChance);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
}   //end of class