import java.util.LinkedList;

public class trainconsistmanagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create LinkedList for train consist
        LinkedList<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial Train Consist: " + train);

        // Insert Pantry Car at position 2
        train.add(2, "Pantry");

        System.out.println("After adding Pantry Car: " + train);

        // Remove first and last bogie
        train.removeFirst();
        train.removeLast();

        // Final consist
        System.out.println("Final Train Consist: " + train);
    }
}