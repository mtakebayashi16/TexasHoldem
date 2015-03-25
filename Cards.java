/* value of cards will range from 2-14, 
 * 14 being an ace, 13 being a king, 
 * 12 being a queen and 11 being a jack
 */

public class Cards{
  private int suit, value;
  public Cards(){
    suit = 5;
    value = 1;
  }
  
  public Cards(int cardSuit, int cardValue){
   suit = cardSuit;
   value = cardValue;
  }
  
  public int getSuit(){      //gets the value of the suit
    return suit;
  }
  
  public int getValue(){     //gets the card value
    return value;
  }
  
  public String getSuitString(){
   if (suit == 0)
     return "Spades";
   else if (suit == 1)
     return "Clubs";
   else if (suit == 2)
     return "Hearts";
   else if (suit == 3)
     return "Diamonds";
   else
     return "Invalid";     
  }
  
  public String getValueString(){
   if (value < 10)
     return Integer.toString(value);
    else if (value == 13)
     return "Ace";
   else if (value == 12)
     return "King";
   else if (value == 11)
     return "Queen";
   else if (value ==10)
     return "Jack";
   else
     return "Invalid";
    
  }
  
}  
