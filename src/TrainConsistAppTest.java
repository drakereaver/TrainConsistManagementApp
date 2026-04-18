import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistAppTest {

    static class Bogie {
        String name;
        int capacity;
        Bogie(String n, int c) {
            name = n;
            capacity = c;
        }
    }

    private List<Bogie> createBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        return bogies;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = createBogies();
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(222, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = createBogies();
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertTrue(total > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Sleeper", 72));
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createBogies();
        List<Integer> capacities = bogies.stream().map(b -> b.capacity).collect(Collectors.toList());
        assertTrue(capacities.containsAll(Arrays.asList(72, 56, 24, 70)));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createBogies();
        int total = bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        int manualSum = bogies.get(0).capacity + bogies.get(1).capacity + bogies.get(2).capacity + bogies.get(3).capacity;
        assertEquals(manualSum, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = createBogies();
        bogies.stream().map(b -> b.capacity).reduce(0, Integer::sum);
        assertEquals(4, bogies.size());
    }
}
