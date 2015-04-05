/* value of cards will range from 2-14, 
 * 14 being an ace, 13 being a king, 
 * 12 being a queen and 11 being a jack
 */

public class Cards{
  private int suit, number;
  public Cards(){
    suit = 5;
    number = 1;
  }
  
  public Cards(int cardSuit, int cardValue){
   suit = cardSuit;
   number = cardValue;
  }
  
  public int getSuit(){      //gets the value of the suit
    return suit;
  }
  
  public int getNumber(){     //gets the card value
    return number;
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
  
  public String getNumberString(){
   if (number <= 10)
     return Integer.toString(number);
    else if (number == 14)
     return "Ace";
   else if (number == 13)
     return "King";
   else if (number == 12)
     return "Queen";
   else if (number == 11)
     return "Jack";
   else
     return "Invalid";
    
  }
  
}  
