public class test{

public int compareToCards(Cards flop1, Cards flop2, Cards flop3, Cards turn, Cards river, Cards hand1, Cards hand2){
    Cards[] playingCards = new Cards[7];
    playingCards[0] = flop1; 
    playingCards[1] = flop2;
    playingCards[2] = flop3;
    playingCards[3] = turn;
    playingCards[4] = river;
    playingCards[5] = hand1;
    playingCards[6] = hand2;
    
    for (int i = 1; i < playingCards.length; i++){            //sorts cards in numerical order
      if (playingCards[i].getNumber() < playingCards[i-1].getNumber()){
        Cards temp = playingCards[i];
        playingCards[i] = playingCards[i-1];
        playingCards[i-1] = temp;
      }
    }
    
    int sameSuit = 0;    //keeps track of how many cards have the same suit
    int changingNumber = 0;  //keeps track of how many cards are in increasing order
    int valueOfCards = 0;    //ranked each type of card hand from 0-800, highest value has best card combo
    int pairs = 0;
    
    boolean threeOfAKind;   //if there is a 3 of a kind, it can use this to check for a full house
    boolean combination;   //used to check if program needs to check for a high card (no combinations)
    
    for (int i = 0; i < playingCards.length-1; i++){   //check how many numbers are the same
      if (playingCards[i].getNumber() == playingCards[i+1].getNumber() && playingCards[i].getNumber() == playingCards[i+2].getNumber()){        
        if (playingCards[i].getNumber() == playingCards[i+3].getNumber()){
          valueOfCards = 700  //4 of a kind has a value of 700
          combination = true;  
        }
        else{
          threeOfAKind = true;
          valueOfCards = 300;   //3 of a kind has a value of 300
        }
      }
      else if (playingCards[i].getNumber() == playingCards[i+1].getNumber()){
       pairs ++; 
      }
    } //end of for-loop
    
    if (pairs == 1){
      if (threeOfAKind == true){
        valueOfCards = 600;       //three of a kind and a pair = full house, which has a value of 600
        combination = true;
      }
      else{
        valueOfCards = 100;   //a single pair has a value of 100
        combination = true;
      }
    }
    
    else if (pairs == 2){
      valueOfCards = 200;  //two pair has a value of 200
    }
    
    int indexNum = 0;
    
    for (int i = 0; i < playingCards.length-1; i++){    //check how many numbers are "in a row"
      if (playingCards[i].getNumber() == (playingCards[i+1].getNumber() + 1)){    
        changingNumber ++;
        indexNum = i;   //gets the index of the first number in the sequence of increasing numbers
      }
    }
    
    if(changingNumber == 4){
      for (int x = indexNum; x <= (indexNum + 4); x++){
        if (playingCards[i].getSuit() == playingCards[j].getSuit())
          sameSuit++;  
      }
      if (sameSuit == 4){  //all are same suit and increasing number
        valueOfCards = 800;   //straight flush has a value of 800 (highest possible combo)
        combination = true
      }
      else{
        valueOfCards = 400;  //straight has a value of 400
        combination = true;
      }
    }
      
 /********************************** PROGRESS BAR **********************************************/
    
    //still need to check for high card and flush

  }

}