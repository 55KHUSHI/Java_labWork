package restaurantMenu;

import java.util.Scanner;

public class RestaurantMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu categories
        String[] vegDishes = {"Paneer Butter Masala", "Vegetable Biryani", "Dal Tadka"};
        String[] nonVegDishes = {"Chicken Curry", "Mutton Biryani", "Fish Fry"};
        String[] eggDishes = {"Egg Curry", "Egg Biryani", "Egg Roll"};

        while (true) {
            // Display menu options
            System.out.println("Restaurant Menu:");
            System.out.println("1. Veg (Green)");
            System.out.println("2. Non-Veg (Red)");
            System.out.println("3. Egg (Brown)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Veg Dishes:");
                    displayDishes(vegDishes);
                    break;
                case 2:
                    System.out.println("Non-Veg Dishes:");
                    displayDishes(nonVegDishes);
                    break;
                case 3:
                    System.out.println("Egg Dishes:");
                    displayDishes(eggDishes);
                    break;
                case 4:
                    System.out.println("Thank you! Visit again.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper method to display dishes
    public static void displayDishes(String[] dishes) {
        for (String dish : dishes) {
            System.out.println("- " + dish);
        }
    }
}
