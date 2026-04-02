import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    String type;   // Bogie type: Rectangular, Cylindrical, etc.
    String cargo;  // Cargo carried

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class trainconsistmanagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC12: Safety Compliance Check for Goods Bogies\n");

        // Prepare a list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // Safety validation using streams and allMatch()
        boolean isSafe = goodsBogies.stream()
                .allMatch(bogie -> {
                    // Cylindrical bogies must carry only Petroleum
                    if (bogie.type.equalsIgnoreCase("Cylindrical")) {
                        return bogie.cargo.equalsIgnoreCase("Petroleum");
                    }
                    // Other bogie types can carry any cargo
                    return true;
                });

        // Display result
        if (isSafe) {
            System.out.println("Train is SAFE: All goods bogies comply with safety rules.");
        } else {
            System.out.println("Train is UNSAFE: At least one goods bogie violates safety rules!");
        }
    }
}