class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    String type;
    int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return type + "(" + capacity + ")";
    }
}


public class trainconsistmanagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC14: Handle Invalid Bogie Capacity\n");

        try {
            // Valid bogie creation
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            System.out.println("Created bogie: " + sleeper);

            PassengerBogie acChair = new PassengerBogie("AC Chair", 56);
            System.out.println("Created bogie: " + acChair);

            // Invalid bogie creation (negative capacity)
            PassengerBogie invalidBogie = new PassengerBogie("First Class", -10);
            System.out.println("Created bogie: " + invalidBogie); // This will not execute
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Invalid bogie creation (zero capacity)
            PassengerBogie zeroBogie = new PassengerBogie("Sleeper", 0);
            System.out.println("Created bogie: " + zeroBogie); // Will not execute
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Valid bogie creation continues
        try {
            PassengerBogie firstClass = new PassengerBogie("First Class", 40);
            System.out.println("Created bogie: " + firstClass);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}