import java.util.Scanner;

/**
 * The CustomizableSandwich class allows users to customize their own sandwich by selecting ingredients.
 * It provides a console-based interface for users to choose from available ingredients and displays the
 * customization summary, including the total calories of the sandwich.
 */

public class CustomizableSandwich {

    /**
     * Allows users to customize their own sandwich by selecting ingredients.
     * This method provides a console-based interface for users to choose from available ingredients,
     * and it displays the customization summary, including the total calories of the sandwich.
     */

    public static void customizeSandwich() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Customizing Sandwich...");
        System.out.println("Available Ingredients: ");
        System.out.println("1 - Chicken Breast");
        System.out.println("2 - Cheese");
        System.out.println("3 - Bread");
        System.out.println("4 - Deli Ham");
        System.out.println("0 - Finish Customization");

        float totalCalories = 0;
        String customization = "";

        while (true) {
            System.out.print("Enter the ingredient number (0 to finish customization): ");
            int ingredientNumber = sc.nextInt();
            sc.nextLine(); 

            if (ingredientNumber == 0) {
                break;
            } else if (ingredientNumber >= 1 && ingredientNumber <= 4) {
                String ingredient = getIngredientName(ingredientNumber);
                int calories = getIngredientCalories(ingredientNumber);
                totalCalories += calories;
                customization += ingredient + ", ";
            } else {
                System.out.println("Invalid ingredient number.");
            }
        }

        if (!customization.isEmpty()) {
            System.out.println("Toasting the bread...");
            System.out.println("Slicing the Cheese...");
            System.out.println("Adding the chicken breast...");
            System.out.println("Spreading the mayonnaise...");
            System.out.println("Assembling the sandwich...");
            System.out.println("Sandwich Done!");
            System.out.println("Customization: " + customization.substring(0, customization.length() - 2));
            System.out.println("Total Calories: " + totalCalories);
        } else {
            System.out.println("No ingredients selected. Customization canceled.");
        }

        sc.close();
    }

    /**
     * Retrieves the name of the ingredient based on the provided ingredient number.
     *
     * @param ingredientNumber The ingredient number for which the name is to be retrieved.
     * @return The name of the ingredient corresponding to the provided ingredient number.
     *         An empty string if the ingredient number is invalid.
     */

    private static String getIngredientName(int ingredientNumber) {
        switch (ingredientNumber) {
            case 1:
                return "Chicken Breast";
            case 2:
                return "Cheese";
            case 3:
                return "Bread";
            case 4:
                return "Deli Ham";
            default:
                return "";
        }
    }

    /**
     * Retrieves the calorie count of the ingredient based on the provided ingredient number.
     *
     * @param ingredientNumber The ingredient number for which the calorie count is to be retrieved.
     * @return The calorie count of the ingredient corresponding to the provided ingredient number.
     *         0 if the ingredient number is invalid.
     */
    
    private static int getIngredientCalories(int ingredientNumber) {
        switch (ingredientNumber) {
            case 1:
                return 100;
            case 2:
                return 50;
            case 3:
                return 80;
            case 4:
                return 70;
            default:
                return 0;
        }
    }
}