//* imports */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Represents a graphical user interface (GUI) for a Vending Machine application.
 * The GUI allows users to interact with the vending machine, select items, and make purchases.
 * It provides options to create a vending machine, customize sandwiches, and buy individual items.
 * The GUI is built using Swing components and follows the ActionListener pattern to handle events.
 */

public class GUI implements ActionListener {

  private JFrame frame;
  private JPanel mainPanel;
  private JPanel featuresPanel;
  private JButton createMachineButton;
  private JButton vendingFeaturesButton;
  private VendingMachine vendingMachine;
  private JTextArea outputTextArea;
  float totalCost = 0;
  int totalCalories = 0;

  /**
   * Initializes the main JFrame and sets up the main panel with buttons to create a vending machine
   * or exit the application.
   */

  public GUI() {
    frame = new JFrame();
    mainPanel = new JPanel();
    featuresPanel = new JPanel(new GridLayout(0, 1));
    vendingMachine = new VendingMachine();
    outputTextArea = new JTextArea(5, 30); // Initialize the JTextArea
    outputTextArea.setEditable(false);

    // Create and add slot 1
    ItemSlot slot1 = new ItemSlot(10, 0);
    Item item1 = new Item("Ice Cream", 100);
    vendingMachine.addSlot(slot1, 1, 80);
    vendingMachine.addItem(item1, 1);
    vendingMachine.restockSlot(1, 10); // Restock slot 1 with 10 items

    // Create and add slot 2
    ItemSlot slot2 = new ItemSlot(10, 0);
    Item item2 = new Item("Sisig", 110);
    vendingMachine.addSlot(slot2, 2, 120);
    vendingMachine.addItem(item2, 2);
    vendingMachine.restockSlot(2, 10); // Restock slot 2 with 10 items

    // Create and add slot 3
    ItemSlot slot3 = new ItemSlot(10, 0);
    Item item3 = new Item("Coke", 90);
    vendingMachine.addSlot(slot3, 3, 40);
    vendingMachine.addItem(item3, 3);
    vendingMachine.restockSlot(3, 10); // Restock slot 3 with 10 items

    // Create and add slot 4
    ItemSlot slot4 = new ItemSlot(10, 0);
    Item item4 = new Item("Egg", 70);
    vendingMachine.addSlot(slot4, 4, 10);
    vendingMachine.addItem(item4, 4);
    vendingMachine.restockItems(10);

    // Create and add slot 5
    ItemSlot slot5 = new ItemSlot(10, 0);
    Item item5 = new Item("Bread", 80);
    vendingMachine.addSlot(slot5, 5, 45);
    vendingMachine.addItem(item5, 5);
    vendingMachine.restockItems(10);

    // Create and add slot 6
    ItemSlot slot6 = new ItemSlot(10, 0);
    Item item6 = new Item("Cheese", 120);
    vendingMachine.addSlot(slot6, 6, 185);
    vendingMachine.addItem(item6, 6);
    vendingMachine.restockItems(10);

    // Create and add slot 7
    ItemSlot slot7 = new ItemSlot(10, 0);
    Item item7 = new Item("Deli Ham", 120);
    vendingMachine.addSlot(slot7, 7, 330);
    vendingMachine.addItem(item7, 7);
    vendingMachine.restockItems(10);
    // Create and add slot 8
    ItemSlot slot8 = new ItemSlot(10, 0);
    Item item8 = new Item("Chicken", 120);
    vendingMachine.addSlot(slot8, 8, 210);
    vendingMachine.addItem(item8, 8);
    vendingMachine.restockItems(10);

    JLabel label = new JLabel("Welcome! Please choose an action.");
    createMachineButton = new JButton("Create a Vending Machine");
    JButton exitButton = new JButton("Exit");

    createMachineButton.addActionListener(this);
    exitButton.addActionListener(this);

    mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    mainPanel.setLayout(new GridLayout(0, 1));
    mainPanel.add(label);
    mainPanel.add(createMachineButton);
    mainPanel.add(exitButton);

    frame.add(mainPanel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Vending Machine Factory");
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * Invoked when an action occurs in the GUI.
   * This method handles button clicks and displays corresponding frames based on user choices.
   *
   * @param e The ActionEvent that occurred.
   */

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == createMachineButton) {
      frame.dispose();
      openVendingMachineFrame();
    } else {
      int confirmed = JOptionPane.showConfirmDialog(
        null,
        "Are you sure you want to exit the application?",
        "Exit Confirmation",
        JOptionPane.YES_NO_OPTION
      );
      if (confirmed == JOptionPane.YES_OPTION) {
        frame.dispose();
      }
    }
  }

  /**
   * Opens the frame for selecting a type of vending machine to create.
   * The user can choose between a regular vending machine and a special vending machine.
   */

  private void openVendingMachineFrame() {
    JFrame vendingFrame = new JFrame("Vending Machine");
    vendingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose this frame on close
    vendingFrame.setSize(400, 300);

    JLabel vendingLabel = new JLabel("Select a Vending Machine to Create");
    vendingFrame.add(vendingLabel, BorderLayout.NORTH);

    JButton regularButton = new JButton("Regular Vending Machine");
    JButton specialButton = new JButton("Special Vending Machine");
    JButton exitButton = new JButton("Exit");

    regularButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          vendingFrame.dispose(); // Close the current frame
          openRegularVendingMachineFrame(vendingFrame); // Open the regular vending machine frame
        }
      }
    );

    specialButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          vendingFrame.dispose();
          openSpecialVendingMachineFrame();
        }
      }
    );

    exitButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          vendingFrame.dispose();
        }
      }
    );

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
    buttonsPanel.add(Box.createVerticalGlue());
    buttonsPanel.add(vendingLabel);
    buttonsPanel.add(Box.createVerticalStrut(10)); // Adds some vertical space
    buttonsPanel.add(regularButton);
    buttonsPanel.add(specialButton);
    buttonsPanel.add(exitButton);
    buttonsPanel.add(Box.createVerticalGlue());

    vendingFrame.add(buttonsPanel, BorderLayout.CENTER);

    vendingFrame.setVisible(true);
  }

  /**
   * Opens the frame for a regular vending machine with test features.
   * The user can test various vending features, such as buying items and getting transaction summaries.
   *
   * @param vendingFrame The JFrame of the regular vending machine.
   */

  private void openRegularVendingMachineFrame(JFrame vendingFrame) {
    JPanel regularVendingPanel = new JPanel();
    regularVendingPanel.setLayout(
      new BoxLayout(regularVendingPanel, BoxLayout.Y_AXIS)
    );

    JLabel regularVendingLabel = new JLabel(
      "Regular Vending Machine Frame - Test Features"
    );
    regularVendingPanel.add(regularVendingLabel);

    vendingFeaturesButton =
      new JButton("Vending Features and Maintenance Features");
    vendingFeaturesButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          testVendingFeatures();
        }
      }
    );
    regularVendingPanel.add(vendingFeaturesButton);

    vendingFrame.setContentPane(regularVendingPanel);
    vendingFrame.pack();
    vendingFrame.setVisible(true);
  }

  /**
   * Tests the vending features in the regular vending machine.
   * Allows users to select items, enter quantity, pay, and get transaction summaries.
   */

  private void testVendingFeatures() {
    JFrame buyIndividualFrame = new JFrame("Regular Vending Machine");
    buyIndividualFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    buyIndividualFrame.setSize(400, 300);

    JLabel label = new JLabel("Select an item and quantity to buy:");
    buyIndividualFrame.add(label, BorderLayout.NORTH);

    // Create buttons for each item in the vending machine
    JButton[] itemButtons = new JButton[3];
    for (int i = 0; i < itemButtons.length; i++) {
      itemButtons[i] = new JButton();
      featuresPanel.add(itemButtons[i]);
    }

    // Item information
    String[] itemNames = { "Ice Cream", "Sisig", "Coke" };
    float[] itemPrices = { 80, 120, 40 };
    int[] itemCalories = { 100, 110, 90 };
    int[] itemQuantities = { 10, 10, 10 };

    for (int i = 0; i < itemButtons.length; i++) {
      String itemInfo =
        "ITEM " +
        (i + 1) +
        "\n" +
        "Name: " +
        itemNames[i] +
        "\n" +
        "Price: Php " +
        itemPrices[i] +
        "\n" +
        "Calories: " +
        itemCalories[i] +
        "\n" +
        "Quantity: " +
        itemQuantities[i];
      itemButtons[i].setText(itemInfo);
      int finalI = i;
      itemButtons[i].addActionListener(
          new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // Prompt for quantity to buy
              String input = JOptionPane.showInputDialog(
                featuresPanel,
                "Enter Quantity (1 to " + itemQuantities[finalI] + "):"
              );
              if (input != null && !input.isEmpty()) {
                int quantityToBuy = Integer.parseInt(input);
                if (
                  quantityToBuy >= 1 && quantityToBuy <= itemQuantities[finalI]
                ) {
                  float totalPrice = itemPrices[finalI] * quantityToBuy;
                  String transactionSummary =
                    "Selected Item: " +
                    itemNames[finalI] +
                    "\n" +
                    "Total Price: " +
                    quantityToBuy +
                    " x " +
                    itemPrices[finalI] +
                    " = Php " +
                    totalPrice +
                    "\n";

                  // Prompt for payment
                  input =
                    JOptionPane.showInputDialog(
                      featuresPanel,
                      transactionSummary + "Enter Amount:"
                    );
                  if (input != null && !input.isEmpty()) {
                    float amountPaid = Float.parseFloat(input);
                    float change = amountPaid - totalPrice;
                    if (change >= 0) {
                      // Update quantities and transaction summary
                      itemQuantities[finalI] -= quantityToBuy;

                      // Dispense change
                      vendingMachine.dispenseChange(change);

                      // Display transaction summary
                      String summaryMessage =
                        "Change: Php " +
                        change +
                        "\n" +
                        "Amount Received: Php " +
                        amountPaid +
                        "\n" +
                        "Quantity of Item Sold: " +
                        quantityToBuy +
                        " " +
                        itemNames[finalI] +
                        "\n" +
                        "Amount Collected: Php " +
                        totalPrice;
                      JOptionPane.showMessageDialog(
                        featuresPanel,
                        summaryMessage,
                        "Transaction Summary",
                        JOptionPane.INFORMATION_MESSAGE
                      );

                      // Update the item information display
                      itemButtons[finalI].setText(
                          "ITEM " +
                          (finalI + 1) +
                          "\n" +
                          "Name: " +
                          itemNames[finalI] +
                          "\n" +
                          "Price: Php " +
                          itemPrices[finalI] +
                          "\n" +
                          "Calories: " +
                          itemCalories[finalI] +
                          "\n" +
                          "Quantity: " +
                          itemQuantities[finalI]
                        );
                    } else {
                      JOptionPane.showMessageDialog(
                        featuresPanel,
                        "Insufficient amount. Please insert enough money.",
                        "Insufficient Amount",
                        JOptionPane.WARNING_MESSAGE
                      );
                    }
                  }
                } else {
                  JOptionPane.showMessageDialog(
                    featuresPanel,
                    "Invalid quantity entered.",
                    "Invalid Quantity",
                    JOptionPane.WARNING_MESSAGE
                  );
                }
              }
            }
          }
        );
    }

    JButton backButton = new JButton("Back");
    backButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          buyIndividualFrame.dispose(); // Close the current frame
          openVendingMachineFrame(); // Go back to the main vending machine frame
        }
      }
    );
    featuresPanel.add(backButton);

    buyIndividualFrame.add(featuresPanel, BorderLayout.CENTER);
    buyIndividualFrame.setVisible(true);
  }

  /*SPECIAL VENDING MACHINE SECTION */
  /**
   * Opens the frame for the Special Vending Machine with options to customize a sandwich or buy ingredients individually.
   * The frame displays buttons for customizing a sandwich from scratch or buying individual ingredients.
   * Users can navigate back to the main vending machine frame using the Back button.
   * The frame uses Swing components, including JFrames, JButtons, JLabels, and JPanels, in a vertical box layout.
   */

  private void openSpecialVendingMachineFrame() {
    JFrame specialVendingFrame = new JFrame("Special Vending Machine");
    specialVendingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    specialVendingFrame.setSize(400, 300);

    JLabel specialVendingLabel = new JLabel(
      "Here, you can create your own sandwich from scratch or select an ingredient individually with the items available."
    );
    specialVendingFrame.add(specialVendingLabel, BorderLayout.NORTH);

    JButton customizeButton = new JButton("Customize your own Sandwich");
    JButton buyIndividualButton = new JButton("Buy ingredient individually");
    JButton backButton = new JButton("Back");

    customizeButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          specialVendingFrame.dispose();
          openCustomizeSandwichFrame();
        }
      }
    );

    buyIndividualButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          specialVendingFrame.dispose();
          openBuyIndividualFrame();
        }
      }
    );

    backButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          specialVendingFrame.dispose();
          openVendingMachineFrame();
        }
      }
    );

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
    buttonsPanel.add(Box.createVerticalGlue());
    buttonsPanel.add(specialVendingLabel);
    buttonsPanel.add(Box.createVerticalStrut(10));
    buttonsPanel.add(customizeButton);
    buttonsPanel.add(buyIndividualButton);
    buttonsPanel.add(backButton);
    buttonsPanel.add(Box.createVerticalGlue());

    specialVendingFrame.add(buttonsPanel, BorderLayout.CENTER);

    specialVendingFrame.setVisible(true);
  }

  /**
   * Opens the frame for customizing a sandwich.
   * The user can select ingredients, see the total price and calories, and finish customizing.
   */

  private void openCustomizeSandwichFrame() {
    JFrame customizeFrame = new JFrame("Customize Your Own Sandwich");
    customizeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    customizeFrame.setSize(400, 300);

    //vendingMachine.customizeSandwich();

    JLabel label = new JLabel("Customizing Your Own Sandwich");
    JLabel availableIngredientsLabel = new JLabel("Available Ingredients:");
    JLabel selectIngredientLabel = new JLabel(
      "Select an ingredient (1-5) or 0 to finish:"
    );
    JLabel totalPriceLabel = new JLabel("Total Price: Php ");
    JLabel totalCaloriesLabel = new JLabel("Total Calories: ");
    JLabel changeLabel = new JLabel("Change: Php ");

    JButton eggButton = new JButton("Egg (Php 70, 100 calories)");
    JButton breadButton = new JButton("Bread (Php 80, 120 calories)");
    JButton cheeseButton = new JButton("Cheese (Php 120, 150 calories)");
    JButton deliHamButton = new JButton("Deli Ham (Php 120, 180 calories)");
    JButton chickenButton = new JButton("Chicken (Php 120, 200 calories)");
    JButton finishButton = new JButton("Finish Customizing");

    eggButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Add egg to the sandwich
          totalCost += 70;
          totalCalories += 100;
          totalPriceLabel.setText("Total Price: Php " + totalCost);
          totalCaloriesLabel.setText("Total Calories: " + totalCalories);
          outputTextArea.append("Cooking egg...\n");
        }
      }
    );

    breadButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Add bread to the sandwich
          totalCost += 80;
          totalCalories += 120;
          totalPriceLabel.setText("Total Price: Php " + totalCost);
          totalCaloriesLabel.setText("Total Calories: " + totalCalories);
          outputTextArea.append("Toasting bread...\n");
        }
      }
    );

    cheeseButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Add cheese to the sandwich
          totalCost += 120;
          totalCalories += 150;
          totalPriceLabel.setText("Total Price: Php " + totalCost);
          totalCaloriesLabel.setText("Total Calories: " + totalCalories);
          outputTextArea.append("Melting cheese...\n");
        }
      }
    );

    deliHamButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Add deli ham to the sandwich
          totalCost += 120;
          totalCalories += 180;
          totalPriceLabel.setText("Total Price: Php " + totalCost);
          totalCaloriesLabel.setText("Total Calories: " + totalCalories);
          outputTextArea.append("Slicing ham...\n");
        }
      }
    );

    chickenButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Add chicken to the sandwich
          totalCost += 120;
          totalCalories += 200;
          totalPriceLabel.setText("Total Price: Php " + totalCost);
          totalCaloriesLabel.setText("Total Calories: " + totalCalories);
          outputTextArea.append("Roasting chicken...\n");
        }
      }
    );

    finishButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          // Finish customizing the sandwich
          String summary = "======Customizable Sandwich Summary======\n";
          summary += "Total Price: Php " + totalCost + "\n";
          summary += "Total Calories: " + totalCalories;

          // Collecting money for the custom sandwich
          float insertedAmount = Float.parseFloat(
            JOptionPane.showInputDialog(customizeFrame, "Please insert money:")
          );
          float change = insertedAmount - totalCost;
          if (change >= 0) {
            summary += "\nChange: Php " + change;
            vendingMachine.dispenseChange(change);
            vendingMachine.getTransactionSummary().addQuantitySold();
            vendingMachine
              .getTransactionSummary()
              .addCollectedAmount(totalCost);

            JOptionPane.showMessageDialog(
              customizeFrame,
              summary,
              "Customizable Sandwich Summary",
              JOptionPane.INFORMATION_MESSAGE
            );
            customizeFrame.dispose(); // Close the customization frame
            showMainPanel(); // Switch back to the main panel
          } else {
            JOptionPane.showMessageDialog(
              customizeFrame,
              "Insufficient amount. Your money will be refunded.",
              "Insufficient Amount",
              JOptionPane.WARNING_MESSAGE
            );
          }
        }
      }
    );

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new GridLayout(0, 1));
    mainPanel.add(label);
    mainPanel.add(availableIngredientsLabel);
    mainPanel.add(eggButton);
    mainPanel.add(breadButton);
    mainPanel.add(cheeseButton);
    mainPanel.add(deliHamButton);
    mainPanel.add(chickenButton);
    mainPanel.add(selectIngredientLabel);
    mainPanel.add(totalPriceLabel);
    mainPanel.add(totalCaloriesLabel);
    mainPanel.add(changeLabel);
    mainPanel.add(finishButton);

    JScrollPane scrollPane = new JScrollPane(outputTextArea);
    mainPanel.add(scrollPane, BorderLayout.SOUTH);

    customizeFrame.add(mainPanel);

    customizeFrame.setVisible(true);
  }

  /**
   * Opens the frame for buying individual items from the vending machine.
   * The user can select items, enter quantity, pay, and get transaction summaries.
   */

  // Inside the Main class, add the following method
  private void openBuyIndividualFrame() {
    JFrame buyIndividualFrame = new JFrame("Buy Individual Items");
    buyIndividualFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    buyIndividualFrame.setSize(400, 300);

    JLabel label = new JLabel("Select an item and quantity to buy:");
    buyIndividualFrame.add(label, BorderLayout.NORTH);

    // Create buttons for each item
    JButton[] itemButtons = new JButton[5];
    for (int i = 0; i < itemButtons.length; i++) {
      itemButtons[i] = new JButton();
      buyIndividualFrame.add(itemButtons[i]);
    }

    // Item information
    String[] itemNames = { "Egg", "Bread", "Cheese", "Deli Ham", "Chicken" };
    float[] itemPrices = { 70, 80, 120, 120, 120 };
    int[] itemCalories = { 100, 120, 150, 180, 200 };
    int[] itemQuantities = { 10, 10, 10, 10, 10 };

    for (int i = 0; i < itemButtons.length; i++) {
      String itemInfo =
        "Name: " +
        itemNames[i] +
        "\n" +
        "Price: Php " +
        itemPrices[i] +
        "\n" +
        "Calories: " +
        itemCalories[i] +
        "\n" +
        "Quantity: " +
        itemQuantities[i];
      itemButtons[i].setText(itemInfo);
      int finalI = i;
      itemButtons[i].addActionListener(
          new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // Prompt for quantity to buy
              String input = JOptionPane.showInputDialog(
                buyIndividualFrame,
                "Enter Quantity (1 to " + itemQuantities[finalI] + "):"
              );
              if (input != null && !input.isEmpty()) {
                int quantityToBuy = Integer.parseInt(input);
                if (
                  quantityToBuy >= 1 && quantityToBuy <= itemQuantities[finalI]
                ) {
                  float totalPrice = itemPrices[finalI] * quantityToBuy;
                  String transactionSummary =
                    "Selected Item: " +
                    itemNames[finalI] +
                    "\n" +
                    "Total Price: " +
                    quantityToBuy +
                    " x " +
                    itemPrices[finalI] +
                    " = Php " +
                    totalPrice +
                    "\n";

                  // Prompt for payment
                  input =
                    JOptionPane.showInputDialog(
                      buyIndividualFrame,
                      transactionSummary + "Enter Amount:"
                    );
                  if (input != null && !input.isEmpty()) {
                    float amountPaid = Float.parseFloat(input);
                    float change = amountPaid - totalPrice;
                    if (change >= 0) {
                      // Update quantities and transaction summary
                      itemQuantities[finalI] -= quantityToBuy;

                      vendingMachine.getTransactionSummary().addQuantitySold();
                      vendingMachine
                        .getTransactionSummary()
                        .addCollectedAmount(totalPrice);

                      // Dispense change
                      vendingMachine.dispenseChange(change);

                      // Display transaction summary
                      String summaryMessage =
                        "Change: Php " +
                        change +
                        "\n" +
                        "Quantity of Item Sold: " +
                        quantityToBuy +
                        " " +
                        itemNames[finalI] +
                        "\n" +
                        "Amount Collected: Php " +
                        totalPrice;
                      JOptionPane.showMessageDialog(
                        buyIndividualFrame,
                        summaryMessage,
                        "Transaction Summary",
                        JOptionPane.INFORMATION_MESSAGE
                      );

                      // Update the item information display
                      itemButtons[finalI].setText(
                          "Name: " +
                          itemNames[finalI] +
                          "\n" +
                          "Price: Php " +
                          itemPrices[finalI] +
                          "\n" +
                          "Calories: " +
                          itemCalories[finalI] +
                          "\n" +
                          "Quantity: " +
                          itemQuantities[finalI]
                        );
                    } else {
                      JOptionPane.showMessageDialog(
                        buyIndividualFrame,
                        "Insufficient amount. Please insert enough money.",
                        "Insufficient Amount",
                        JOptionPane.WARNING_MESSAGE
                      );
                    }
                  }
                } else {
                  JOptionPane.showMessageDialog(
                    buyIndividualFrame,
                    "Invalid quantity entered.",
                    "Invalid Quantity",
                    JOptionPane.WARNING_MESSAGE
                  );
                }
              }
            }
          }
        );
    }
    JButton backButton = new JButton("Back");
    backButton.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          buyIndividualFrame.dispose(); // Close the current frame
          openSpecialVendingMachineFrame(); // Go back to the special vending machine frame
        }
      }
    );
    buyIndividualFrame.add(backButton);

    buyIndividualFrame.setLayout(new GridLayout(0, 1));
    buyIndividualFrame.setVisible(true);
  }

  /**
   * Switches the main panel content to the main panel with create vending machine and exit buttons.
   * Used to navigate back to the main panel after customizing a sandwich.
   */

  private void showMainPanel() {
    frame.setContentPane(mainPanel);
    frame.pack();
    frame.setVisible(true);
  }
}
