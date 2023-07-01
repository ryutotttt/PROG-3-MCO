import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // TODO: Auto-generated method stub //
    Test();
  }

  public static void Test() {
    Scanner scMain = new Scanner(System.in);
    int choice, choiceCr, choiceF;
    VendingMachine vendingMachine = new VendingMachine();

    //? do {
      System.out.println("Welcome! Please choose an action.");
      System.out.println(
        " 1 - Create Vending Machine \n 2 - Exit "
      );
      System.out.print("Enter Choice: ");
      choice = scMain.nextInt();
      switch (choice) {
        case 1:
          System.out.println(
            " 1 - Create a Regular Vending Machine \n 2 - Create a Special Vending Machine \n 3 - Back"
          );
          System.out.print("Enter Choice: ");
          choiceCr = scMain.nextInt();

          switch (choiceCr) {
            case 1:
              System.out.println("Regular Vending Machine");
              ItemSlot slot1 = new ItemSlot(10, 0);
              vendingMachine.addSlot(slot1, 1, 80);
              Item item = new Item("Sandwich", 100);
              vendingMachine.addItem(item, 0);
              vendingMachine.displayAvailItems();
              System.out.println("\n Test Vending Machine");
              System.out.println(" 1 - Vending Features \n 2 - Maintenance Features");
              System.out.print("Enter Choice: ");
              choiceF = scMain.nextInt();
              switch (choiceF) {
                case 1:
                  System.out.println("Vending Features\n");
                  Scanner scSlotNo = new Scanner(System.in);
                  int slotNo;
                  vendingMachine.displayAvailItems();
                  System.out.println("Select Item");
                  slotNo = scSlotNo.nextInt();
                  vendingMachine.selectItem(slotNo);
                  break;
                case 2:
                  System.out.println("Maintenance Features");
                  vendingMachine.displayStrtInv();

                  vendingMachine.replenishMoney(10, 10, 10, 10, 10, 
                  10, 10, 10, 10);
                  vendingMachine.displayDenominations();
                  break;
                case 3: // TODOES: Back to Menu
                  break;
                default:
                  System.out.println("Invalid");
              }
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
        
        case 2: // TODOES: Exit program
          break;
        default:
          System.out.println("Invalid");
      }
    //? } while (choice != 2);
    scMain.close();
  }
}
