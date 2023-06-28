public class ItemSlot {
    private Item[] items;
    private int capacity;
    private float price;

    public ItemSlot(int capacity) {
        
        this.capacity = capacity;
        this.items = new Item[capacity];
    }

    //! getter and setter

    public Item[] getItem() {
        return items;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }
    public int getCapacity(){
        return capacity;
    }


    
    //! restock
    
    public void restock() {
        int i = 0;
        
        while(i < capacity){
            items[i] = new Item("Item " + (i + 1), i);
        }

    }

    


}
