import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Vending();
  }

  public static void Vending() {
    Scanner scMain = new Scanner(System.in);
    int choice, choiceCr;
    VendingMachine vendingMachine = new VendingMachine();

    System.out.println("=======================================");
    System.out.println("   Welcome! Please choose an action.");
    System.out.println("=======================================");
    System.out.println(" 1 - Create Vending Machine \n 2 - Exit ");
    System.out.print("Enter Choice: ");
    choice = scMain.nextInt();
    scMain.nextLine(); // Consume the newline character after reading the integer input

    switch (choice) {
      case 1:
        System.out.println(
          " 1 - Create a Regular Vending Machine \n 2 - Create a Special Vending Machine \n 3 - Back"
        );
        System.out.print("Enter Choice: ");
        choiceCr = scMain.nextInt();
        scMain.nextLine(); // Consume the newline character after reading the integer input

        switch (choiceCr) {
          case 1:
            System.out.println("Regular Vending Machine");

            // Create and add slot 1
            ItemSlot slot1 = new ItemSlot(10, 0);
            Item item1 = new Item("Ice Cream", 100);
            vendingMachine.addSlot(slot1, 1, 80);
            vendingMachine.addItem(item1, 1);

            // Create and add slot 2
            ItemSlot slot2 = new ItemSlot(10, 0);
            Item item2 = new Item("Sisig", 110);
            vendingMachine.addSlot(slot2, 2, 120);
            vendingMachine.addItem(item2, 2);

            // Create and add slot 3
            ItemSlot slot3 = new ItemSlot(10, 0);
            Item item3 = new Item("Coke", 90);
            vendingMachine.addSlot(slot3, 3, 40);
            vendingMachine.addItem(item3, 3);

            int choiceF;

            System.out.println("\n Test Vending Machine");
            System.out.println(
              " 1 - Vending Features and Maintenance Features"
            );
            System.out.print("Enter Choice: ");
            choiceF = scMain.nextInt();
            scMain.nextLine(); // Consume the newline character after reading the integer input

            switch (choiceF) {
              case 1:
                int slotNo;

                System.out.println("Maintenance Features");
                vendingMachine.displayStrtInv(1);
                vendingMachine.displayStrtInv(2);
                vendingMachine.displayStrtInv(3);

                vendingMachine.restockItems(5);
                vendingMachine.replenishMoney(
                  10,
                  10,
                  10,
                  10,
                  10,
                  10,
                  10,
                  10,
                  10
                );
                vendingMachine.displayDenominations();
                System.out.println(
                  "---------------------------------------------------------------------------------------"
                );
                System.out.println("Vending Features\n");
                vendingMachine.displayAvailItems(1);
                vendingMachine.displayAvailItems(2);
                vendingMachine.displayAvailItems(3);

                System.out.println("Select Item");
                slotNo = scMain.nextInt();
                scMain.nextLine(); // Consume the newline character after reading the integer input
                vendingMachine.selectItem(slotNo);

                System.out.println(
                  "---------------------------------------------------------------------------------------"
                );

                vendingMachine.displaySummary();

                break;
              case 2:
                /*System.out.println("Maintenance Features");
                        vendingMachine.displayStrtInv();
                        vendingMachine.replenishMoney(10, 10, 10, 10, 10, 10, 10, 10, 10);
                        vendingMachine.displayDenominations();*/
                //vendingMachine.displaySummary();
                break;
              default:
                System.out.println("Invalid");
                break;
            }
          case 2:
            System.out.println("-------------------------------------------");
            System.out.println("  Welcome to the Special Vending Machine!");
            System.out.println("-------------------------------------------");
            System.out.println(
              "Here, you can create your own sandwich from scratch or select an ingredient individually with the items available."
            );

            //prepare a selected product based on Items stored in the machine
            // the choices of items for the product that the user want
            int choiceS;
            System.out.println("\nPick an action:");
            System.out.println("1 - Customize your own Sandwich");
            System.out.println("2 - Buy ingredient individually");
            System.out.println("3 - Back");
            System.out.print("Enter Choice: ");
            choiceS = scMain.nextInt();
            scMain.nextLine(); // Consume the newline character after reading the integer input

            switch (choiceS) {
              case 1:
                vendingMachine.customizeSandwich(); //(alternative two)
                //CustomizableSandwich.customizeSandwich();

                break;
              case 2:
                int ingredientChoice;

                // Create and add slot 4
                ItemSlot slot4 = new ItemSlot(10, 0);
                Item item4 = new Item("Egg", 70);
                vendingMachine.addSlot(slot4, 4, 10);
                vendingMachine.addItem(item4, 4);

                // Create and add slot 5
                ItemSlot slot5 = new ItemSlot(10, 0);
                Item item5 = new Item("Bread", 80);
                vendingMachine.addSlot(slot5, 5, 45);
                vendingMachine.addItem(item5, 5);

                // Create and add slot 6
                ItemSlot slot6 = new ItemSlot(10, 0);
                Item item6 = new Item("Cheese", 120);
                vendingMachine.addSlot(slot6, 6, 185);
                vendingMachine.addItem(item6, 6);

                // Create and add slot 7
                ItemSlot slot7 = new ItemSlot(10, 0);
                Item item7 = new Item("Deli Ham", 120);
                vendingMachine.addSlot(slot7, 7, 330);
                vendingMachine.addItem(item7, 7);

                // Create and add slot 8
                ItemSlot slot8 = new ItemSlot(10, 0);
                Item item8 = new Item("Chicken", 120);
                vendingMachine.addSlot(slot8, 8, 210);
                vendingMachine.addItem(item8, 8);

                System.out.println("\nAccessable Options :\n");

                vendingMachine.displayAvailItems(4);
                vendingMachine.displayAvailItems(5);
                vendingMachine.displayAvailItems(6);
                vendingMachine.displayAvailItems(7);
                vendingMachine.displayAvailItems(8);

                System.out.println("Select Item (4-8)");
                ingredientChoice = scMain.nextInt();
                scMain.nextLine(); // Consume the newline character after reading the integer input
                vendingMachine.selectItem(ingredientChoice);

                System.out.println(
                  "---------------------------------------------------------------------------------------"
                );
                vendingMachine.displaySummary();
                break;
              default:
                System.out.println("Invalid");
                break;
            }

            break;
          case 3:
            break;
          default:
            System.out.println("Invalid");
            break;
        }

        break;
      case 2:
        break;
      default:
        System.out.println("Invalid");
        break;
    }

    scMain.close();
  }
}
