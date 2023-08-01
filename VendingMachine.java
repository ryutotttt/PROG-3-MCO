// * imports
import java.util.Scanner;

// * Vending Machine Class

public class VendingMachine {

  private float collected;
  private ItemSlot[] slots;
  private TransactionSummary summary;
  private Denomination denominations;
  private ItemSlot[] startInventory;
  private ItemSlot[] endInventory;

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
  }

  //! Add this method to the VendingMachine class
  public void customizeSandwich() {
    Scanner scCustomize = new Scanner(System.in);
    System.out.println("Customizing Your Own Sandwich");
    System.out.println("Available Ingredients:");
    System.out.println("1 - Egg (Php 70, 100 calories)");
    System.out.println("2 - Bread (Php 80, 120 calories)");
    System.out.println("3 - Cheese (Php 120, 150 calories)");
    System.out.println("4 - Deli Ham (Php 120, 180 calories)");
    System.out.println("5 - Chicken (Php 120, 200 calories)");
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
      } else if (ingredientChoice >= 1 && ingredientChoice <= 5) {
        Item[] items = slots[ingredientChoice + 2].getItem(); // Items are stored in slots 4 to 8
        if (items != null && items.length > 0) {
          for (int j = 0; j < slots[ingredientChoice + 3].getQuantity(); j++) {
            Item item = items[j];
            System.out.println("Selected Ingredient: " + item.getName());
            totalCost += slots[ingredientChoice + 3].getPrice();
            totalCalories += item.getCalories();
          }
        } else {
          System.out.println("Ingredient not available.");
        }
      } else {
        System.out.println("Invalid choice. Please select again.");
      }
    }

    System.out.println("Your Custom Sandwich:");
    System.out.println("Total Price: Php " + totalCost);
    System.out.println("Total Calories: " + totalCalories);
    System.out.println("Enjoy your sandwich!");

    scCustomize.close();
  }

  //! add slots and add price

  public void addSlot(ItemSlot slot, int sInd, float sPrice) {
    if (sInd >= 1 && sInd <= slots.length) {
      slots[sInd - 1] = slot;
      slots[sInd - 1].setPrice(sPrice);
    } else {
      System.out.println("Invalid slot index");
    }
  }

  public void addItem(Item item, int slotInd) {
    if (slotInd >= 1 && slotInd <= slots.length) {
      slots[slotInd - 1].addItems(item);
    } else {
      System.out.println("Invalid slot index");
    }
  }

  //! restockItems
  public void restockItems(int quantity) {
    for (ItemSlot slot : slots) {
      if (slot != null) {
        slot.restock(quantity);
      }
    }
  }

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

  //! display inventory
  /*public void displayInv() {
    System.out.println("------Starting Inventory------");
    for (ItemSlot slot : startInventory) {
      displayItemSlot(slot);
      
    }
  }*/
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
  public void displayAvailItems(int slotNumber) {
    if (slotNumber >= 1 && slotNumber <= slots.length) {
      ItemSlot slot = slots[slotNumber - 1];
      if (slot != null) {
        Item[] items = slot.getItem();
        System.out.println("Available Items in Slot " + slotNumber);
        if (items != null && items.length > 0) {
          for (int j = 0; j < slot.getQuantity(); j++) {
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
  public void selectItem(int slotNo) {
    int i;
    if (slotNo > 0 && slotNo <= slots.length) {
      ItemSlot slot = slots[slotNo - 1];
      Item[] items = slot.getItem();
      if (items != null && items.length > 0) {
        for (i = 0; i < slot.getQuantity(); i++) {
          Item item = items[i];
          System.out.println("Selected Item: " + item.getName());
          System.out.println("Price: Php " + slot.getPrice());
          collectMoney(slotNo, i);
          dispenseItem(slotNo);
        }
      } else {
        System.out.println("Slot is empty");
      }
    } else {
      System.out.println("Invalid Slot Number");
    }
  }

  //! dispense item
  public void dispenseItem(int slotNo) {
    int i;
    if (slotNo > 0 && slotNo < slots.length) {
      ItemSlot slot = slots[slotNo - 1];
      Item[] items = slot.getItem();
      Item item;
      if (slot.getQuantity() > 0) {
        for (i = 0; i < slot.getCapacity(); i++) {
          item = items[i];
          System.out.println("Dispencing Item " + item.getName());
        }
        slot.setQuantity(0);
      } else {
        System.out.println("Item out of stock");
      }
    }
  }

  //! collect money
  public void collectMoney(int cSlotNo, float amount) {
    Scanner scCollect = new Scanner(System.in);

    int i;
    if (cSlotNo > 0 && cSlotNo < slots.length) {
      ItemSlot slot = slots[cSlotNo - 1];
      Item[] items = slot.getItem();
      Item item;

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
      if (slot.getQuantity() > 0) {
        for (i = 0; i < slot.getCapacity(); i++) {
          item = items[i];
          System.out.println("Paying for Item: " + item.getName());
        }
      } else {
        System.out.println("Item Out of Stock");
      }
    }
    scCollect.close();
  }

  //! dispense change

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

  public void displaySummary() {
    System.out.println("Transaction Summary:");
    System.out.println("Quantity Sold: " + summary.getQuantitySold());
    System.out.println("Amount Collected: Php " + summary.getAmountCollected());
  }

  //! getter and setter

  public float getCollected() {
    return collected;
  }

  public ItemSlot[] getSlots() {
    return slots;
  }

  public TransactionSummary geTransactionSummary() {
    return summary;
  }

  public Denomination gDenominations() {
    return denominations;
  }

  public ItemSlot[] getStartInventory() {
    return startInventory;
  }

  public ItemSlot[] getEndInventory() {
    return endInventory;
  }
}
