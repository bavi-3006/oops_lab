// Exp_2.java
// Demonstrates Single and Multilevel Inheritance

// Base class
class Food {
    String name;
    int calories;

    void displayInfo() {
        System.out.println("Food: " + name);
        System.out.println("Calories: " + calories + " kcal");
    }
}

// Single inheritance: Fruit extends Food
class Fruit extends Food {
    String color;

    void ripen() {
        System.out.println(name + " is ripening.");
    }
}

// Multilevel inheritance: Citrus extends Fruit
class Citrus extends Fruit {
    int vitaminCContent; // in mg

    void describeTaste() {
        System.out.println(name + " tastes tangy and refreshing!");
    }

    void showVitaminC() {
        System.out.println(name + " has " + vitaminCContent + " mg of Vitamin C.");
    }
}

// Main class
public class Exp_2 {
    public static void main(String[] args) {
        // Single Inheritance Demo
        System.out.println("---- Single Inheritance Demo ----");
        Fruit mango = new Fruit();
        mango.name = "Mango";
        mango.calories = 150;
        mango.color = "Yellow";
        mango.displayInfo();
        mango.ripen();

        // Multilevel Inheritance Demo
        System.out.println("\n---- Multilevel Inheritance Demo ----");
        Citrus orange = new Citrus();
        orange.name = "Orange";
        orange.calories = 80;
        orange.color = "Orange";
        orange.vitaminCContent = 70;
        orange.displayInfo();
        orange.ripen();
        orange.describeTaste();
        orange.showVitaminC();
    }
}
