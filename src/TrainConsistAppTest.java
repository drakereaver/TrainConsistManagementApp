import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Arrays;

public class TrainConsistAppTest {

    public boolean binarySearch(String[] bogieIds, String searchId) {
        Arrays.sort(bogieIds);
        int low = 0;
        int high = bogieIds.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = searchId.compareTo(bogieIds[mid]);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(bogies, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(binarySearch(bogies, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(bogies, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        assertTrue(binarySearch(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogies = {};
        assertFalse(binarySearch(bogies, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(binarySearch(bogies, "BG205"));
    }
}
