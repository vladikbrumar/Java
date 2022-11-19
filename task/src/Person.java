/**
 * Person class represents a person
 */
public class Person {
    private String firstName, lastName;
    private int age;

    /**
     * Constructor
     * @param firstName person's first name
     * @param lastName person's last name
     * @param age person's age
     */
    public Person(String firstName, String lastName, String age) {
        if(firstName.isEmpty() || lastName.isEmpty() || age.isEmpty()) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = Integer.parseInt(age);
    }

    /**
     * Get person's first name
     * @return string with person's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the person's last name
     * @return string with last name of person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the age of the person
     * @return int value of age of the person
     */
    public int getAge() {
        return age;
    }

    /**
     * Get the object as string
     * @return line with instance of Person object
     */
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
