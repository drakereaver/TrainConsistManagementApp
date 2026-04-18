import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TrainConsistAppTest {

    public int[] bubbleSort(int[] capacities) {
        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
        return capacities;
    }

    @Test
    void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSort_SingleElementArray() {
        int[] input = {50};
        int[] expected = {50};
        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};
        assertArrayEquals(expected, bubbleSort(input));
    }
}
