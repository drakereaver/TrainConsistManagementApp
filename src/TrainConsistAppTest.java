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
        bogies.add(new Bogie("AC Chair", 60));
        return bogies;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = createBogies();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = createBogies();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = createBogies();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(3, grouped.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Sleeper", 72));
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(1, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = createBogies();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertTrue(grouped.keySet().containsAll(Arrays.asList("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = createBogies();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = createBogies();
        bogies.stream().collect(Collectors.groupingBy(b -> b.name));
        assertEquals(5, bogies.size());
    }
}
