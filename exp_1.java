// Define a class named Car
public class Car {
    // Member variables (fields)
    String brand;
    String color;
    int year;

    // Member function (method)
    void displayDetails() {
        System.out.println("Car Brand: " + brand);
        System.out.println("Car Color: " + color);
        System.out.println("Manufacturing Year: " + year);
    }

    // Main method to create and use objects
    public static void main(String[] args) {
        // Creating the first object of Car
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.color = "Red";
        car1.year = 2022;

        // Creating the second object of Car
        Car car2 = new Car();
        car2.brand = "Hyundai";
        car2.color = "Blue";
        car2.year = 2023;

        // Displaying details of both cars
        System.out.println("Details of Car 1:");
        car1.displayDetails();

        System.out.println("\nDetails of Car 2:");
        car2.displayDetails();
    }
}
