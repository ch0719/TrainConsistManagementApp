import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + "(" + capacity + ")";
    }
}

public class trainconsistmanagementApp{

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC13: Performance Comparison (Loops vs Streams)\n");

        // Prepare a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            bogies.add(new Bogie("Bogie-" + i, (i % 100) + 1)); // capacities 1 to 100
        }

        // -------- Loop-Based Filtering --------
        long loopStart = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long loopEnd = System.nanoTime();
        long loopDuration = loopEnd - loopStart;

        // -------- Stream-Based Filtering --------
        long streamStart = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long streamEnd = System.nanoTime();
        long streamDuration = streamEnd - streamStart;

        // Display results
        System.out.println("Filtered bogies using loop: " + loopFiltered.size());
        System.out.println("Loop filtering time: " + loopDuration + " ns");

        System.out.println("Filtered bogies using stream: " + streamFiltered.size());
        System.out.println("Stream filtering time: " + streamDuration + " ns");

        // Verify results match
        System.out.println("Results match: " + (loopFiltered.size() == streamFiltered.size()));
    }
}