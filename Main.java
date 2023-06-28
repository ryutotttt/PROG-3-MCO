import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    // TODO: Auto-generated method stub //
    Test();
  }
  public static void Test()
  {
    //VendingMachine VendingMachine = new VendingMachine();
    Scanner scMain = new Scanner(System.in);
    int choice, choiceCr, choiceF;
    

    
    do{
      System.out.println("Welcome! Please choose an action.");
      System.out.println(" 1 - Create Vending Machine \n 2 - Test Vending Machine \n 3 - Exit ");
      System.out.print("Enter Choice: ");
      choice = scMain.nextInt();
      switch(choice){

        case 1: 
          System.out.println(" 1 - Create a Regular Vending Machine \n 2 - Create a Special Vending Machine \n 3 - Back");
          System.out.print("Enter Choice: ");
          choiceCr = scMain.nextInt();

          switch(choiceCr) {
            case 1: 
              System.out.println("Regular Vending Machine");
            break;
            
            case 2: 
              System.out.println("Special Vending Machine");
            break;

            case 3: // TODOES: Back to Menu

            break;

            default: 
              System.out.println("Invalid");
          }
          break;

        case 2: 
          System.out.println(" 1 - Vending Features \n 2 - Maintenance Features");
          System.out.print("Enter Choice: ");
          choiceF = scMain.nextInt();
          switch(choiceF)
          {
            case 1: 
              System.out.println("Vending Features");
            break;

            case 2: 
              System.out.println("Maintenance Features");
            break;

            case 3: // TODOES: Back to Menu
            break;

            default: 
              System.out.println("Invalid");
          }
        break;

        case 3: // TODOES: Exit program
        break;

        default: 
              System.out.println("Invalid");
          
      }
    }while (choice!= 3);
    scMain.close();
  }

}
