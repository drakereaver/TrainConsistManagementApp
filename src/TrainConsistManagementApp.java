import java.util.*;
import java.util.stream.*;

public class TrainConsistManagementApp {
    static class GoodsBogie {
        String type;
        String cargo;
        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(b -> System.out.println(b));

        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("Safety Compliance Status: " + isSafe);
        System.out.println(isSafe ? "Train formation is SAFE." : "Train formation is NOT SAFE.");
        System.out.println("UC12 safety validation completed ...");
    }
}
