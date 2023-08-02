// * imports
import java.util.Scanner;

// * Vending Machine Class

/**
 * The VendingMachine class represents a simple vending machine that allows users to customize sandwiches and buy individual ingredients.
 * It maintains an array of item slots, each containing various items and their quantities.
 * The vending machine also keeps track of the amount collected from transactions and denominations of available currency.
 * Users can restock the items, replenish the denominations, display the inventory, and select items for purchase.
 * The vending machine can dispense items, calculate change, and display transaction summaries.
 */

public class VendingMachine {

  private float collected;
  private ItemSlot[] slots;
  private TransactionSummary summary;
  private Denomination denominations;
  private ItemSlot[] startInventory;
  private ItemSlot[] endInventory;

  /**
   * Constructs a new VendingMachine object.
   * Initializes the collected amount, item slots, denominations, and transaction summary.
   * The startInventory and endInventory are set to the same item slots array at the beginning.
   * Additional slots are created with specific items added to them.
   */

  public VendingMachine() {
    collected = 0.0f;
    slots = new ItemSlot[8];
    for (int i = 0; i < slots.length; i++) {
      slots[i] = new ItemSlot(0, 0); // Initialize each slot with an empty ItemSlot
    }
    denominations = new Denomination();
    summary = new TransactionSummary(0, 0.0f);
    startInventory = slots;
    endInventory = slots;

    ItemSlot slot4 = new ItemSlot(10, 10);
    ItemSlot slot5 = new ItemSlot(10, 45);
    ItemSlot slot6 = new ItemSlot(10, 185);
    ItemSlot slot7 = new ItemSlot(10, 330);
    ItemSlot slot8 = new ItemSlot(10, 210);

    Item item4 = new Item("Egg", 70);
    Item item5 = new Item("Bread", 80);
    Item item6 = new Item("Cheese", 120);
    Item item7 = new Item("Deli Ham", 120);
    Item item8 = new Item("Chicken", 120);

    slots[3] = slot4;
    slots[4] = slot5;
    slots[5] = slot6;
    slots[6] = slot7;
    slots[7] = slot8;

    addItem(item4, 4);
    addItem(item5, 5);
    addItem(item6, 6);
    addItem(item7, 7);
    addItem(item8, 8);
  }

  /**
   * Allows users to customize their own sandwich by selecting ingredients from the available item slots.
   * Users can view the list of available ingredients with their respective prices and calories.
   * They can add ingredients to their sandwich, view the total price and calories, and pay for the customized sandwich.
   */

  public void customizeSandwich() {
    Scanner scCustomize = new Scanner(System.in);
    System.out.println("\nCustomizing Your Own Sandwich");
    System.out.println("Available Ingredients:");
    System.out.println("3 - Egg (Php 70, 100 calories)");
    System.out.println("4 - Bread (Php 80, 120 calories)");
    System.out.println("5 - Cheese (Php 120, 150 calories)");
    System.out.println("6 - Deli Ham (Php 120, 180 calories)");
    System.out.println("7 - Chicken (Php 120, 200 calories)");
    System.out.println("0 - Done customizing");

    int ingredientChoice;
    float totalCost = 0;
    int totalCalories = 0;

    while (true) {
      System.out.print("Select an ingredient (1-5) or 0 to finish: ");
      ingredientChoice = scCustomize.nextInt();
      scCustomize.nextLine(); // Consume the newline character after reading the integer input

      if (ingredientChoice == 0) {
        break;
      } else if (ingredientChoice >= 3 && ingredientChoice <= 7) {
        Item[] items = slots[ingredientChoice].getItem();
        if (items != null && items.length > 0) {
          System.out.println("Selected Ingredient: " + items[0].getName());
          totalCost += slots[ingredientChoice].getPrice();
          totalCalories += items[0].getCalories();

          // Adding additional steps for each ingredient
          switch (ingredientChoice) {
            case 3:
              System.out.println("Cooking egg...");
              break;
            case 4:
              System.out.println("Toasting bread...");
              break;
            case 5:
              System.out.println("Melting cheese...");
              break;
            case 6:
              System.out.println("Slicing ham...");
              break;
            case 7:
              System.out.println("Roasting chicken...");
              break;
          }
        } else {
          System.out.println("Ingredient not available.");
        }
      } else {
        System.out.println("Invalid choice. Please select again.");
      }
    }

    System.out.println("\nTotal Price: Php " + totalCost);
    System.out.println("Total Calories: " + totalCalories);

    // Collecting money for the custom sandwich
    if (totalCost > 0) {
      System.out.print("Please insert money: ");
      float insertedAmount = scCustomize.nextFloat();
      float change = insertedAmount - totalCost;
      if (change >= 0) {
        System.out.println("Change: " + change + "Php");
        dispenseChange(change);
        summary.addQuantitySold();
        summary.addCollectedAmount(totalCost); // Update the amount collected from customizable sandwiches
      } else {
        System.out.println("Insufficient amount. Your money will be refunded.");
      }
    }

    scCustomize.close();
  }

  /**
   * Displays the summary of customizable sandwiches sold, including the total quantity sold and the amount collected.
   */

  public void displayCustomizableSandwichSummary() {
    System.out.println("======Customizable Sandwich Summary======");
    System.out.println("Quantity Sold: " + summary.getQuantitySold());
    System.out.println("Amount Collected: Php " + summary.getAmountCollected());
  }

  /**
   * Restocks a specific item slot with a given quantity of items.
   * @param slotNumber The index of the slot to restock.
   * @param quantity The quantity of items to add to the slot.
   */

  public void restockSlot(int slotNumber, int quantity) {
    if (slotNumber >= 1 && slotNumber <= slots.length) {
      ItemSlot slot = slots[slotNumber - 1];
      if (slot != null) {
        slot.restock(quantity);
      } else {
        System.out.println("Slot is not initialized");
      }
    } else {
      System.out.println("Invalid slot number.");
    }
  }

  //! add slots and add price

  /**
   * Adds a new item slot to the vending machine at the specified index with the given price.
   * @param slot The item slot to add.
   * @param slotIndex The index of the slot to add.
   * @param slotPrice The price of the items in the slot.
   */

  public void addSlot(ItemSlot slot, int sInd, float sPrice) {
    if (sInd > 0 && sInd <= slots.length) {
      slots[sInd - 1] = slot;
      slots[sInd - 1].setPrice(sPrice);
    } else {
      System.out.println("Invalid slot index");
    }
  }

  /**
   * Adds an item to the specified item slot.
   * @param item The item to add.
   * @param slotIndex The index of the slot to add the item.
   */

  public void addItem(Item item, int slotInd) {
    if (slotInd > 0 && slotInd <= slots.length) {
      slots[slotInd - 1].addItems(item);
    } else {
      System.out.println("Invalid slot index");
    }
  }

  /**
   * Restocks all item slots with the given quantity of items.
   * @param quantity The quantity of items to restock in each slot.
   */
  //! restockItems
  public void restockItems(int quantity) {
    for (ItemSlot slot : slots) {
      if (slot != null) {
        slot.restock(quantity);
      }
    }
  }

  /**
   * Replenishes the denominations of available currency in the vending machine.
   * @param oneK The number of 1000 PHP denominations to add.
   * @param fiveHund The number of 500 PHP denominations to add.
   * @param twoHund The number of 200 PHP denominations to add.
   * @param oneHund The number of 100 PHP denominations to add.
   * @param fiftyPhp The number of 50 PHP denominations to add.
   * @param twentyPhp The number of 20 PHP denominations to add.
   * @param tenPhp The number of 10 PHP denominations to add.
   * @param fivePhp The number of 5 PHP denominations to add.
   * @param one The number of 1 PHP denominations to add.
   */

  //! replenish money
  public void replenishMoney(
    int oneK,
    int fiveHund,
    int twoHund,
    int oneHund,
    int fiftyPhp,
    int twentyPhp,
    int tenPhp,
    int fivePhp,
    int one
  ) {
    denominations.replenish(
      oneK,
      fiveHund,
      twoHund,
      oneHund,
      fiftyPhp,
      twentyPhp,
      tenPhp,
      fivePhp,
      one
    );
  }

  //! display all denomination
  /**
   * Displays the quantities of all available denominations in the vending machine.
   */

  public void displayDenominations() {
    System.out.println("Denomination Quantities:");
    System.out.println("1000 PHP: " + denominations.getOneK());
    System.out.println("500 PHP: " + denominations.getfiveHund());
    System.out.println("200 PHP: " + denominations.gettwoHund());
    System.out.println("100 PHP: " + denominations.getoneHund());
    System.out.println("50 PHP: " + denominations.getfiftyPhp());
    System.out.println("20 PHP: " + denominations.gettwentyPhp());
    System.out.println("10 PHP: " + denominations.getTen());
    System.out.println("5 PHP: " + denominations.getFive());
    System.out.println("1 PHP: " + denominations.getOne());
    System.out.println("Total Denomination: " + denominations.getTotal());
  }

  /**
   * Displays the items available in the specified item slot.
   * @param slotNumber The index of the slot to display.
   */
  //! display item in slot
  public void displayStrtInv(int slotNumber) {
    if (slotNumber >= 1 && slotNumber <= startInventory.length) {
      ItemSlot slot = startInventory[slotNumber - 1];
      Item[] items = slot.getItem();

      System.out.println("Items in Slot " + slotNumber + ":");
      if (items != null && items.length > 0) {
        for (int j = 0; j < slot.getQuantity(); j++) {
          System.out.println(items[j].getName() + ": " + slot.getQuantity());
        }
      } else {
        System.out.println("Slot Empty");
      }
      System.out.println();
    } else {
      System.out.println("Invalid slot number.");
    }
  }

  /**
   * Displays the items available in all item slots at the end of the inventory.
   */
  public void displayEndInv() {
    for (ItemSlot slot : endInventory) {
      System.out.println("Slot:");
      Item[] items = slot.getItem();
      if (items != null && items.length > 0) {
        for (int j = 0; j < slot.getQuantity(); j++) {
          System.out.println(items[j].getName() + ": " + slot.getQuantity());
        }
      }
      System.out.println();
    }
  }

  //! display all
  /**
   * Displays the details of all available items in the specified item slot.
   * @param slotNumber The index of the slot to display.
   */

  public void displayAvailItems(int slotNumber) {
    if (slotNumber >= 1 && slotNumber <= slots.length) {
      ItemSlot slot = slots[slotNumber - 1];
      if (slot != null) {
        Item[] items = slot.getItem();
        System.out.println("Available Items in Slot " + slotNumber);
        if (items != null) {
          for (int j = 0; j < items.length; j++) {
            if (items[j] != null) {
              System.out.println("Item: " + items[j].getName());
              System.out.println("Calories: " + items[j].getCalories());
              System.out.println("Price: Php " + slot.getPrice());
              System.out.println("Quantity: " + slot.getQuantity());
              System.out.println();
            }
          }
        } else {
          System.out.println("Slot Empty");
        }
      } else {
        System.out.println("Invalid slot number.");
      }
    } else {
      System.out.println("Invalid slot number.");
    }
  }

  //! select item
  /**
   * Selects an item from the specified item slot and initiates the purchase process.
   * @param slotNumber The index of the slot to select an item from.
   */
  public void selectItem(int slotNo) {
    if (slotNo > 0 && slotNo <= slots.length) {
      ItemSlot slot = slots[slotNo - 1];
      Item[] items = slot.getItem();
      if (items != null && items.length > 0) {
        for (int i = 0; i < slot.getQuantity(); i++) {
          Item item = items[i];
          if (item != null) {
            System.out.println("Selected Item: " + item.getName());
            System.out.println("Price: Php " + slot.getPrice());
            collectMoney(slotNo, i);
            dispenseItem(slotNo);
          }
        }
      } else {
        System.out.println("Slot is empty");
      }
    } else {
      System.out.println("Invalid Slot Number");
    }
  }

  //! dispense item
  /**
   * Dispenses an item from the specified item slot after a successful purchase.
   * @param slotNumber The index of the slot to dispense an item from.
   */

  public void dispenseItem(int slotNo) {
    if (slotNo >= 1 && slotNo <= slots.length) {
      ItemSlot slot = slots[slotNo - 1];
      if (slot != null) {
        Item[] items = slot.getItem();
        if (slot.getQuantity() > 0) {
          for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
              System.out.println("Dispensing Item: " + item.getName());
              slot.setQuantity(slot.getQuantity() - 1); // Update the quantity of items in the slot
              return; // Exit the method after dispensing one item
            }
          }
        } else {
          System.out.println("Item out of stock");
        }
      } else {
        System.out.println("Invalid slot number.");
      }
    } else {
      System.out.println("Invalid slot number.");
    }
  }

  /**
   * Collects money from the user to pay for the selected item.
   * @param cSlotNo The index of the slot corresponding to the selected item.
   * @param amount The amount of money to be collected.
   */

  //! collect money
  public void collectMoney(int cSlotNo, float amount) {
    Scanner scCollect = new Scanner(System.in);

    //int i;
    if (cSlotNo > 0 && cSlotNo <= slots.length) {
      ItemSlot slot = slots[cSlotNo - 1];
      //Item[] items = slot.getItem();
      //Item item;

      System.out.println("Total Amount: " + slot.getPrice());
      System.out.println("Insert Money");
      amount = scCollect.nextFloat();

      if (amount >= slot.getPrice()) {
        float change = amount - slot.getPrice();
        System.out.println("Change: " + change);

        dispenseChange(change);
        summary.addQuantitySold();
        summary.addCollectedAmount(slot.getPrice());
        slot.decrementQuantity();
      } else {
        System.out.println("Not Enough Inserted Money");
      }
    }
    scCollect.close();
  }

  //! dispense change
  /**
   * Dispenses change to the user after a successful purchase.
   * @param changeAmount The amount of change to be dispensed.
   */
  public void dispenseChange(float changeAmount) {
    System.out.println("Change:");

    int remainingChange = (int) (changeAmount);

    int[] denominationValues = { 1000, 500, 200, 100, 50, 20, 10, 5, 1 };

    for (int denomination : denominationValues) {
      int count = remainingChange / denomination;

      if (count >= 1) {
        int availableCount = denominations.getCountForDenomination(
          denomination
        );
        int dispensedCount = Math.min(count, availableCount);

        if (dispensedCount >= 1) {
          denominations.subtractFromDenomination(denomination, dispensedCount);
          remainingChange -= denomination * dispensedCount;
          System.out.println(dispensedCount + " x Php " + denomination);
        }
      }
    }
  }

  /**
   * Displays the summary of all transactions made in the vending machine, including the total quantity sold and the amount collected.
   */
  public void displaySummary() {
    System.out.println("Transaction Summary:");
    System.out.println("Quantity Sold: " + summary.getQuantitySold());
    System.out.println("Amount Collected: Php " + summary.getAmountCollected());
  }

  //! getter and setter

  /**
   * Getter method for the amount collected from transactions.
   * @return The total amount collected.
   */

  public float getCollected() {
    return collected;
  }

  /**
   * Getter method for the array of item slots in the vending machine.
   * @return The array of item slots.
   */

  public ItemSlot[] getSlots() {
    return slots;
  }

  /**
   * Getter method for the transaction summary.
   * @return The transaction summary object.
   */

  public TransactionSummary getTransactionSummary() {
    return summary;
  }

  /**
   * Getter method for the denominations of available currency.
   * @return The denominations object.
   */

  public Denomination gDenominations() {
    return denominations;
  }

  /**
   * Getter method for the array of item slots representing the start of the inventory.
   * @return The array of item slots representing the start inventory.
   */

  public ItemSlot[] getStartInventory() {
    return startInventory;
  }

  /**
   * Getter method for the array of item slots representing the end of the inventory.
   * @return The array of item slots representing the end inventory.
   */

  public ItemSlot[] getEndInventory() {
    return endInventory;
  }
}
