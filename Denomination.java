public class Denomination {

  private String type;
  private int quantity;

  public Denomination(String type, int quantity) {
    this.type = type;
    this.quantity = quantity;
  }

  
  public String getType() {
    return type;
  }

  public float getQuantity() {
    return quantity;
  }


  public void replenish(int quantity){
    this.quantity += quantity;
  }
}
