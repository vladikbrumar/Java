import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class HouseholdTest {
    String[] inputData = {"firstname", "lastname", "address", "city", "state", "22"};
    Household household = new Household(inputData);
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testIncompleteInputData() {
        exception.expect(IllegalArgumentException.class);
        String[] inputData1 = {"1", "3", "4"};
        Household h = new Household(inputData1);
    }

    @Test
    public void testEmptyInputData() {
        exception.expect(IllegalArgumentException.class);
        String[] inputData2 = null;
        Household h2 = new Household(inputData2);
    }

    @Test
    public void testHouseholdConstructor() {
        assertEquals("address", household.getStreetAddress());
        assertEquals("city", household.getCity());
        assertEquals("state", household.getState());
    }

    @Test
    public void testAddingMembers() {
        household.addMember(new Person("John", "Johnson", "22"));
        assertEquals(2, household.getMembers().size());
    }

    @Test
    public void testAddEmptyPerson() {
        exception.expect(IllegalArgumentException.class);
        household.addMember(null);
    }

    @Test
    public void testToStringAndSort() {
        String[] inputData = {"Bob","Williams","234 2nd Ave.","Tacoma","WA","26"};
        Household h = new Household(inputData);
        h.addMember(new Person("Eve","Smith", "25"));

        String expected = "Household at 234 2nd ave., 2:\n" +
                "Eve, Smith, 234 2nd ave., tacoma, wa, 25\n" +
                "Bob, Williams, 234 2nd ave., tacoma, wa, 26\n";
        assertEquals(expected, h.toString());


    }

}