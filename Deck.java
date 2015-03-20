public class Deck{
  private Cards[] deck = new Cards[52];
  private int usedCards;    //keeps track of how many cards have been dealt
  
  
  public Deck(){
    int counter = 0; //keeps track of created cards (should be 52)
    for (int suit = 0; suit <= 3; suit++) {
      for (int value = 1; value <= 13; value++) {
        deck[counter] = new Cards(value,suit);
        counter++; 
      }
    }
  }
  
  public void shuffle(){                           //mixes up the cards
    for (int i = 0; i < deck.length; i++){
      Cards temp = deck[i];
      int randomNum = (int)(Math.random()*(i+1));
      deck[i] = deck[randomNum];
      deck[randomNum] = temp;
    }
  }
  
  public int checkCardsLeft(){            //checks how many cards are left in the deck
    return deck.length - usedCards;
  }
  
  public Cards deal(){    //wasn't sure how to do this (especially with an object return type) so I looked up help for making the method online
    if (usedCards == deck.length){
      throw new IllegalStateException("No cards are left in the deck.");
    }
    usedCards++;
    return deck[usedCards - 1];
  }
  
} //end of class