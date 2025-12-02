import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class for Car (inheritance and encapsulation)
abstract class Car {
    private String model;
    private String brand;
    private double price;
    private int stock;

    public Car(String model, String brand, double price, int stock) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }

    // Getters (encapsulation)
    public String getModel() { return model; }
    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    // Abstract method for polymorphism
    public abstract void displayDetails();
}

// Subclass for Sedan (inherits from Car, adds fuelType)
class Sedan extends Car {
    private String fuelType;

    public Sedan(String model, String brand, double price, int stock, String fuelType) {
        super(model, brand, price, stock);
        this.fuelType = fuelType;
    }

    public String getFuelType() { return fuelType; }

    // Overridden method (polymorphism)
    @Override
    public void displayDetails() {
        System.out.println("Category: Sedan");
        System.out.println("Model: " + getModel() + " | Brand: " + getBrand());
        System.out.println("Price: PKR " + getPrice() + " | Stock: " + getStock() + " | Fuel: " + fuelType);
        System.out.println("-----------------------------");
    }
}

// Main class (catalog and menu)
public class Main {
    private static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        // Sample Sedans
        cars.add(new Sedan("City", "Honda", 4500000, 10, "Petrol"));
        cars.add(new Sedan("Corolla", "Toyota", 5500000, 8, "Petrol"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Pakistani Sedan Catalog ===");
            System.out.println("1. Add Sedan");
            System.out.println("2. View All Sedans");
            System.out.println("3. View Sedans by Category");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Price (PKR): ");
                    double price = scanner.nextDouble();
                    System.out.print("Stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Fuel Type: ");
                    String fuel = scanner.nextLine();
                    cars.add(new Sedan(model, brand, price, stock, fuel));
                    System.out.println("Sedan added!");
                    break;
                case 2:
                    if (cars.isEmpty()) System.out.println("No sedans.");
                    else for (Car c : cars) c.displayDetails(); // Polymorphism
                    break;
                case 3:
                    System.out.println("Sedans:");
                    for (Car c : cars) if (c instanceof Sedan) c.displayDetails(); // Polymorphism
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid.");
            }
        }
    }
}
