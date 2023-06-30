// * imports
import java.util.Scanner;

// * Vending Machine Class

public class VendingMachine {

  private float collected;
  private ItemSlot[] slots;
  private TransactionSummary summary;
  private Denomination[] denominations;
  private ItemSlot[] startInventory;
  private ItemSlot[] endInventory;

  public VendingMachine() {
    collected = 0.0f;
    slots = new ItemSlot[8];
    denominations = new Denomination[8];
    summary = new TransactionSummary(0, 0.0f);
    startInventory = new ItemSlot[8];
    endInventory = new ItemSlot[8];
  }

  //! add slots
  
  public void addSlot(ItemSlot[] slots) {
    int i = 0;

    while (i < 8) {
      slots[i] = new ItemSlot(10);
      startInventory[i] = new ItemSlot(0);
      endInventory[i] = new ItemSlot(0);
      i++;
    }
  }

  //! add denomination
  
  public void addDenomination(Denomination[] denomination) {
    int i = 0;
    while (i < 8) {
      denomination[i] = new Denomination(" " + (i + 1), 0);
      i++;
    }
  }

  //! add items

  public void addItem(Item item, int slotInd) 
  {
    if(slotInd >= 0 && slotInd < slots.length)
    {
      slots[slotInd].addItems(item);
    }
    else{
      System.out.println("Invalid slot");
    }
  }

  //! restockItems
  public void restockItems(int quantity) {
    for (ItemSlot slot : slots) {
      slot.restock(quantity);
    }
  }

  //! set price
  public void setPrice(ItemSlot slot, float price) {
    slot.setPrice(price);
  }

  //! replenish money
  public void replenishMoney(Denomination denomination, int quantity) {
    denomination.replenish(quantity);
    System.out.println(denomination.getType() + "Quantity: " + quantity);
  }

  //! display item in slot

 

  //! display inventory
  public void displayInv() {
    System.out.println("------Starting Inventory------");
    for (ItemSlot slot : startInventory) {
      //* displayItemSlot
        System.out.println(slot.getItem() + ": " + slot.getQuantity());
    }

    System.out.println("------End Inventory------");
    for (ItemSlot slot : endInventory) {
      //* displayItemSlot
      System.out.println(slot.getItem() + ": " + slot.getQuantity());
    }
  }

  //! display all
  public void displayAvailItems(){
    int i = 0, j = 0;

    while(i < slots.length){
      Item[] items = slots[i].getItem();
      System.out.println("Slot " + (i + 1) + ": ");
      if(items != null && items.length > 0)
      {
        while(j < slots[i].getQuantity())
        {
          System.out.println("Item " + (j + 1) + ": " + items[j].getName());
          System.out.println("Calories " + (j + 1) + ": " + items[j].getCalories());
          j++;
        }
        System.out.println("Price: Php " + slots[i].getPrice());
        System.out.println("Quantity: " + slots[i].getQuantity());
        
      }
      else{
        System.out.println("Slot Empty");
      }
      System.out.print("\n");
      i++; 
    }
  }

  //! select item
  public void selectItem(int slotNo){

        if(slotNo > 0 && slotNo < slots.length){
          ItemSlot slot = slots[slotNo - 1];
          System.out.println("Selected Item: " + slot.getItem());
          System.out.println("Price: Php " + slot.getPrice());
        }
        else{
          System.out.println("Invalid Slot Number");
        }
  }
  //! dispense item
  public void dispenseItem(int slotNo)
  {

  }
  //! collect money
  public void collectMoney(ItemSlot slot, float amount){
        Scanner scCollect = new Scanner(System.in);
        
        if(slot != null && slot.getQuantity() > 0)
        {
            System.out.println("Total Amount: " + slot.getPrice());
            System.out.println("Insert Money");
            amount = scCollect.nextFloat();

            if(amount >= slot.getPrice()){
                    //? System.out.println("");
                    amount -= slot.getPrice();
                    slot.decrementQuantity(0);
            }       
            else{
                System.out.println("Not Enough Inserted Money");
            }
        }
        else{
            System.out.println("Item Out of Stock/ Item Unavailable: " + slot.getItem());
        }
        scCollect.close();
  }

  //! dispense change 


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

  public Denomination[] gDenominations() {
    return denominations;
  }

  public ItemSlot[] getStartInventory() {
    return startInventory;
  }

  public ItemSlot[] getEndInventory() {
    return endInventory;
  }
}
