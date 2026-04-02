import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class trainconsistmanagementApp{

    public static void main(String[] args) {
        // Welcome message
        System.out.println("=== Train Consist Management App ===");

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask user for Train ID
        System.out.print("\nEnter Train ID (format TRN-1234): ");
        String trainID = scanner.nextLine();

        // Ask user for Cargo Code
        System.out.print("Enter Cargo Code (format PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Define regex patterns
        String trainPattern = "TRN-\\d{4}";       // TRN- followed by exactly 4 digits
        String cargoPattern = "PET-[A-Z]{2}";     // PET- followed by exactly 2 uppercase letters

        // Compile patterns
        Pattern trainRegex = Pattern.compile(trainPattern);
        Pattern cargoRegex = Pattern.compile(cargoPattern);

        // Match input
        Matcher trainMatcher = trainRegex.matcher(trainID);
        Matcher cargoMatcher = cargoRegex.matcher(cargoCode);

        // Validate Train ID
        if (trainMatcher.matches()) {
            System.out.println("Train ID is valid.");
        } else {
            System.out.println("Invalid Train ID format!");
        }

        // Validate Cargo Code
        if (cargoMatcher.matches()) {
            System.out.println("Cargo Code is valid.");
        } else {
            System.out.println("Invalid Cargo Code format!");
        }

        // Close scanner
        scanner.close();
    }
}