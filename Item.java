public class Item {

  private String name;
  private int calories;

  public Item(String name, int calories) {
    this.name = name;
    this.calories = calories;
  }

  //! getter and seter
  public String getName() {
    return name;
  }

  public int getCalories() {
    return calories;
  }
}
