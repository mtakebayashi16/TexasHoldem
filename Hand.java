public class Hand{
  public Cards[] handCards = new Cards[1];
  private int cardSlots;     // so array length isnt exceeded when adding cards to hand
  
  public Hand(){
    handCards = new Cards[1];
    cardSlots = 0;
  }
  
  public int value(){   //determines the value of a hand, i.e. how strong it is
    int valTot = 0;
    
    if(handCards[0].getNumber() == handCards[1].getNumber()){        //if hand is a pair, the value is strong
      valTot = 1000;
    } 
    else if(handCards[0].getSuit() == handCards[1].getSuit()){    //if hand is of same suit, the value is moderately strong
      valTot = 500;
    }
    
    if(handCards[0].getNumber() > handCards[1].getNumber()){               //otherwise the total is just the highest card * 14 + 2nd cards value
      valTot = handCards[0].getNumber() * 14 +  handCards[1].getNumber();
    } else {
      valTot = handCards[1].getNumber() * 14 +  handCards[0].getNumber();
    }
    
    return valTot;
  }
  
  public void addCards(Cards card){
    handCards[cardSlots] = card;
    cardSlots++;
  }
  
  public void printHand(){
    System.out.print(handCards[0].getNumberString() + " of " + handCards[0].getSuitString() + " and "
                       + handCards[1].getNumberString() + " of " + handCards[1].getSuitString());
  }
  
}  //end of class