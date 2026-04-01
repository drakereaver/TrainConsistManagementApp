import java.util.*;

class TrainConsistentManagementApp {
    static class Bogie {
        String name;
        int capacity;
        Bogie(String n, int c) {
            name = n;
            capacity = c;
        }
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:\n");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity:\n");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nUC7 sorting completed ...");
    }
}
