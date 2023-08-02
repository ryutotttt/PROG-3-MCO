/**
 * The TransactionSummary class represents a summary of transactions made in a vending machine.
 * It keeps track of the quantity of items sold and the total amount collected from those transactions.
 */

public class TransactionSummary {

  private int quantitySold;
  private float amountCollected;

  /**
   * Creates a new TransactionSummary object with the specified quantity sold and amount collected.
   *
   * @param quantitySold    The quantity of items sold.
   * @param amountCollected The total amount collected from the transactions.
   */

  public TransactionSummary(int quantitySold, float amountCollected) {
    this.quantitySold = quantitySold;
    this.amountCollected = amountCollected;
  }

  //! getter and setter

  /**
   * Retrieves the quantity of items sold.
   *
   * @return The quantity of items sold.
   */

  public int getQuantitySold() {
    return quantitySold;
  }

  /**
   * Retrieves the total amount collected from the transactions.
   *
   * @return The total amount collected from the transactions.
   */

  public float getAmountCollected() {
    return amountCollected;
  }

  //! add all sold items

  /**
   * Increases the quantity of items sold by 1.
   * This method is called each time an item is sold to update the quantity sold.
   */

  public void addQuantitySold() {
    quantitySold++;
  }

  /**
   * Adds the payment amount to the total amount collected.
   * This method is called after each successful transaction to update the total collected amount.
   *
   * @param payAmount The payment amount received in the transaction.
   */

  public void addCollectedAmount(float payAmount) {
    amountCollected += payAmount;
  }
}
