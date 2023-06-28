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

    public VendingMachine(){
        collected = 0.0f;
        slots = new ItemSlot[8];
        denominations = new Denomination[8];
        summary = new TransactionSummary(0, 0.0f);
        startInventory = new ItemSlot[8];
        endInventory = new ItemSlot[8];
    }


    //! add slots

    public void addSlot(ItemSlot[] slots){
        int i = 0;

        while(i < 8)
        {
            slots[i] = new ItemSlot(10);
            startInventory[i] = new ItemSlot(0);
            endInventory[i] = new ItemSlot(0);
            i++;
        }
    }

    //! add denomination
    public void addDenomination(Denomination[] denomination) {
        int i = 0;
        while(i < 8)
        {
            denomination[i] = new Denomination(" " + (i + 1), 0);
            i++;
        }
    }

    //! restockItems
    public void restockItems(){
        for(ItemSlot slot: slots){
            slot.restock();
        }
    }

    //! set price
    public void setPrice(ItemSlot slot, float price)
    {
        slot.setPrice(price);
    }

    //! replenish money
    public void replenishMoney(Denomination denomination, int quantity){
        denomination.replenish(quantity);
        System.out.println(denomination.getType() + "Quantity: " + quantity);
    }

    //! display item in slot
    
    public void displayItemSlot(ItemSlot slot){
        Item[] items = slot.getItem();
        int i = 0;
        while(i < slot.getCapacity())
        {
            Item item = items[i];
            System.out.println("Item " + (i + 1) + ": " + item.getName());
            System.out.println("Calories: " + item.getCalories());
        }
        System.out.println("Quantity: " + slot.getCapacity());
    }

    //! display inventory
    public void displayInv(){
        System.out.println("------Starting Inventory------");
        for(ItemSlot slot : startInventory){
            //* displayItemSlot
        }

        System.out.println("------End Inventory------");
        for(ItemSlot slot : endInventory){
            //* displayItemSlot
        }
        
    }
    //! getter and setter

    public float getCollected(){
        return collected;
    }

    public ItemSlot[] getSlots(){
        return slots;
    }

    public TransactionSummary geTransactionSummary(){
        return summary;
    }

    public Denomination[] gDenominations(){
        return denominations;
    }

    public ItemSlot[] getStartInventory(){
        return startInventory;
    }

    public ItemSlot[] getEndInventory(){
        return endInventory;
    }

    
}
