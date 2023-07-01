public class TransactionSummary {

  private int quantitySold;
  private float amountCollected;

  public TransactionSummary(int quantitySold, float amountCollected) {
    this.quantitySold = quantitySold;
    this.amountCollected = amountCollected;
  }

  //! getter and setter
  public int getQuantitySold() {
    return quantitySold;
  }

  public float getAmountCollected() {
    return amountCollected;
  }

  //! add all sold items

  public void addQuantitySold() {
    quantitySold++;
  }

  
}
