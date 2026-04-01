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
        bogies.add(new Bogie("General", 90));
        return bogies;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = createBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = createBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
        assertFalse(filtered.stream().anyMatch(b -> b.capacity == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = createBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
        assertFalse(filtered.stream().anyMatch(b -> b.capacity < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = createBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(2, filtered.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = createBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 200)
                .collect(Collectors.toList());
        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = createBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 20)
                .collect(Collectors.toList());
        assertEquals(bogies.size(), filtered.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = createBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(4, bogies.size());
    }
}

