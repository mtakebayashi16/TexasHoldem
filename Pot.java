public class Pot{
  private double total = 0;
  
  public Pot(){
   total = total;
  }
  
  public void addToPot(int value){
    total += value;
  }
  
  public void printPot(){
    System.out.println(total);
  }
  
  public void clearPot(){
   total = 0; 
  }
  
  public double potValue(){
    return total;
  }
  
  
} //end of class