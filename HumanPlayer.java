import java.util.Scanner;
public class HumanPlayer{
  private Hand humHand;
  private double money;
  private boolean stand;
  private boolean playing = true;
  
  Scanner in = new Scanner( System.in );
  
  public HumanPlayer(){
    humHand = new Hand();
    money = 1000;
  }
  
  public void addCards(Cards card){
    humHand.addCards(card); 
  }
  
  public void printHand(){
   humHand.printHand(); 
  }
  
  public boolean playing(){
    return playing;
  }
  
  public boolean stand(){
    String input;
    char i;            //so the program can compare the user input
    
    System.out.println("Do you want to stand? (y/n)");
    input = in.nextLine();
    i = input.charAt(0);
    
    if (i == 'y')
      stand = true;
    else{
      stand = false;
      playing = false;
    }
    return stand;
  }
  
  /*in a round of betting, a player can: check- only sometimes, does not put any money in pot
   * bet(call?): put in the minimum that previous players have set
   * raise: increase the size of the bet
   * fold: give up cards
  */
  public double betting(double bet){  
    String choice;
    double cost = 0;
    char c;
    System.out.println("What would you like to do?");       
    System.out.println("(call, raise, fold)");                                                      
    choice = in.nextLine();
    choice = choice.toLowerCase();
    c = choice.charAt(0);
    
    if (c == 'c'){             //if player calls, the bet value is subtracted and added to the pot
      money = money - bet;
      cost = bet;
    }
    else if (c == 'r'){                //if player raises, they can input by how much they would like to raise
      System.out.println("How much would you like to raise by? (only type in a number value)");
      cost = in.nextInt();
      if (cost <= 0){
        System.out.println("Please input a value greater than 0");
        cost = in.nextInt();
      }
      else
      money = money - cost;  //subtracts input value from player's money
    }
    else{                   //if player folds, no money is taken, but the player is no longer playing that round
      playing = false;
    }
    return cost;
  }
  
  public double printMoney(){
    return money;
  }
  
  
} //end of class