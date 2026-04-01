import java.util.*;

class TrainConsistentManagementApp {
    public static void main(String[] args) {
        System.out.println("UC3 - Track Unique Bogie IDs\n");

        Set<String> bogies = new HashSet<>();

        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");
        bogies.add("BG101");
        bogies.add("BG102");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogies);

        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println("UC3 uniqueness validation completed ..");
    }
}
