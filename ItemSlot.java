public class ItemSlot {

  private Item[] items;
  private int quantity;
  private int capacity;
  private float price;

  public ItemSlot(int capacity) {
        this.items = new Item[capacity];
        this.quantity = 0;
        this.capacity = capacity;
        this.price = 0.0f;
  }

  //! getter and setter

  public Item[] getItem() {
    return items;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
        this.quantity = quantity;
  }

  public int getCapacity(){
    return capacity;
  }

  //! restock

  public void restock(int quantity) {
        this.quantity += quantity;
  }

  //! stock bought
  public void decrementQuantity(int quantity){
    this.quantity -= quantity;
  }

  //! add item

  public void addItems(Item newItem){
    if(quantity < capacity)
    {
      items[quantity] = newItem;
      quantity++;
      System.out.println("Item " + newItem.getName() + " added");
    }
    else{
      System.out.println("Slots are full");
    }
  }
  
}
