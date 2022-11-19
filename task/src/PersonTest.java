import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;



public class PersonTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testNullOrEmptyPerson() {
        exception.expect(IllegalArgumentException.class);
        Person person = new Person("", "last name", null);
    }

    @Test
    public void testPersonConstructor() {
        Person person = new Person("Test name", "last name", "22");
        assertEquals("Test name", person.getFirstName());
        assertEquals("last name", person.getLastName());
        assertEquals(22, person.getAge());
        assertEquals("Person{" + "firstName='" + person.getFirstName() + '\'' +
                ", lastName='" + person.getLastName() + '\'' +
                ", age=" + person.getAge() + '}', person.toString());
    }

}