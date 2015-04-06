import java.util.Scanner;
public class HumanPlayer{
  private Hand humHand;
  private int money;
  private boolean stand = false;
  
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
  
  public boolean standstatus(){
     return stand;
  }
  
  public boolean stand(){
    String input;
    char i;            //so the program can compare the user input
    
    System.out.println("Do you want to stand? (y/n)");
    input = in.nextLine();
    i = input.charAt(0);
    
    if (i == 'y')
      stand = true;
    else
      stand = false;
    return stand;
  }
  
  /*in a round of betting, a player can: check- only sometimes, does not put any money in pot
   * bet(call?): put in the minimum that previous players have set
   * raise: increase the size of the bet
   * fold: give up cards
  */
  public void betting(){  
    String choice;
    char c;
    System.out.println("What would you like to do?");       
    System.out.println("(call, raise, fold)");                                                      
    choice = in.nextLine();
    choice = choice.toLowerCase();
    c = choice.charAt(0);
    
    if (c == 'c'){
      
    }
    else if (c == 'r'){
      System.out.println("How much would you like to raise by?");
      
    }
    else{
      stand = true;
    }
  }
  
  public int printMoney(){
    return money;
  }
  
  
} //end of class