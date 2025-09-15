import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class FilterMatchAllTest {

    /**
     * Test class for FilterMatchAll.
     * <p>
     * The FilterMatchAll class is used to match a set of terms against a HashSet of strings.
     * It matches if ALL the terms in the filter are present in the provided line (HashSet).
     * The doMatch method performs this functionality.
     */

    @Test
    void testDoMatch_AllFilterTermsMatch() {
        // Setup
        String filterString = "apple banana cherry";
        FilterMatchAll filter = new FilterMatchAll(1, filterString);

        HashSet<String> inputSet = new HashSet<>();
        inputSet.add("apple");
        inputSet.add("banana");
        inputSet.add("cherry");

        // Execution and Assertion
        assertTrue(filter.doMatch(inputSet), "Expected all terms to match");
    }

    @Test
    void testDoMatch_OneFilterTermMissing() {
        // Setup
        String filterString = "dog cat mouse";
        FilterMatchAll filter = new FilterMatchAll(1, filterString);

        HashSet<String> inputSet = new HashSet<>();
        inputSet.add("dog");
        inputSet.add("cat");

        // Execution and Assertion
        assertFalse(filter.doMatch(inputSet), "Expected doMatch to return false as one term is missing");
    }

    @Test
    void testDoMatch_EmptyFilterString() {
        // Setup
        String filterString = "";
        FilterMatchAll filter = new FilterMatchAll(1, filterString);

        HashSet<String> inputSet = new HashSet<>();
        inputSet.add("anything");

        // Execution and Assertion
        assertTrue(!filter.doMatch(inputSet), "Expected doMatch to return true for empty filter string");
    }

    @Test
    void testDoMatch_EmptyInputSet() {
        // Setup
        String filterString = "bird fish";
        FilterMatchAll filter = new FilterMatchAll(1, filterString);

        HashSet<String> inputSet = new HashSet<>();

        // Execution and Assertion
        assertFalse(filter.doMatch(inputSet), "Expected doMatch to return false for empty input set");
    }

    @Test
    void testDoMatch_CaseInsensitiveMatch() {
        // Setup
        String filterString = "HOUSE car";
        FilterMatchAll filter = new FilterMatchAll(1, filterString);

        HashSet<String> inputSet = new HashSet<>();
        inputSet.add("house");
        inputSet.add("car");

        // Execution and Assertion
        assertTrue(filter.doMatch(inputSet), "Expected case-insensitive match");
    }

    @Test
    void testDoMatch_FilterWithExtraSpaces() {
        // Setup
        String filterString = "   computer   laptop   mouse   ";
        FilterMatchAll filter = new FilterMatchAll(1, filterString);

        HashSet<String> inputSet = new HashSet<>();
        inputSet.add("computer");
        inputSet.add("laptop");
        inputSet.add("mouse");

        // Execution and Assertion
        assertTrue(filter.doMatch(inputSet), "Expected match to handle extra spaces in filter string");
    }

    @Test
    void testDoMatch_SingleTermMatch() {
        // Setup
        String filterString = "key";
        FilterMatchAll filter = new FilterMatchAll(1, filterString);

        HashSet<String> inputSet = new HashSet<>();
        inputSet.add("key");

        // Execution and Assertion
        assertTrue(filter.doMatch(inputSet), "Expected doMatch to return true for single matching term");
    }

    @Test
    void testDoMatch_SingleTermNoMatch() {
        // Setup
        String filterString = "key";
        FilterMatchAll filter = new FilterMatchAll(1, filterString);

        HashSet<String> inputSet = new HashSet<>();
        inputSet.add("value");

        // Execution and Assertion
        assertFalse(filter.doMatch(inputSet), "Expected doMatch to return false for single non-matching term");
    }
}