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
  
  public void shuffle(){
    for (int i = 0; i < deck.length; i++){
      Cards temp = deck[i];
      int randomNum = (int)(Math.random()*(i+1));
      deck[i] = deck[randomNum];
      deck[randomNum] = temp;
    }
  }
  
} //end of class