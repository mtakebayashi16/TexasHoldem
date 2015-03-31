import java.util.Scanner;
public class HumanPlayer{
  private Hand humHand;
  private int money;
  
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
  
  public boolean stand(){
    Scanner in = new Scanner( System.in );
    String input;
    char i;            //so the program can compare the user input
    
    System.out.println("Do you want to stand? (y/n)");
    input = in.nextLine();
    i = input.charAt(0);
    
    if (i == 'y')
      return true;
    else
      return false;
  
  }
  
  
  
} //end of class