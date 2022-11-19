import java.util.ArrayList;
import java.util.List;

/**
 * Class represent of Household with a list of its members
 */
public class Household {
    private String streetAddress;
    private String city;
    private String state;
    private List<Person> members;

    /**
     * Constructor, creating new instance of this class
     * @param inputData line with information by following format:
     *                  first name, last name, address, city, state, age of member
     */
    public Household(String[] inputData) {
        if(inputData == null) {
            throw new IllegalArgumentException("Input data must not be null");
        }
        if(inputData.length!= 6) {
            throw new IllegalArgumentException("Input data must have 6 elements");

        }
        this.streetAddress = inputData[2].toLowerCase();
        this.city = inputData[3].toLowerCase();
        this.state = inputData[4].toLowerCase();
        this.members = new ArrayList<>();
        this.members.add(new Person(inputData[0], inputData[1], inputData[5]));
    }

    /**
     * Adding a new member to current household
     * @param person person who will be added to household
     */
    public void addMember(Person person) {
        if(person == null) {
            throw new IllegalArgumentException("person must not be null");
        }
        this.members.add(person);
    }

    /**
     * Sort members in alphabetic order by Last Name and then by First Name
     */
    private void sortMembers() {
        this.members.sort((m1, m2) -> {
            int res = m1.getLastName().compareToIgnoreCase(m2.getLastName());
            if (res != 0)
                return res;
            return m1.getFirstName().compareToIgnoreCase(m2.getFirstName());
        });

    }

    /**
     * Get household as string in with custom format
     * @return line with full household information
     */
    @Override
    public String toString() {
        this.sortMembers();
        String result = "Household at " + this.getStreetAddress() + ", " + this.members.size() + ":\n";
        for(Person member: this.members) {
            if(member.getAge() >= 18) {
                result += member.getFirstName() + ", " + member.getLastName() + ", " + this.getStreetAddress() + ", " +
                        this.getCity() + ", " + this.getState() + ", " + member.getAge() + "\n";
            }
        }
        return result;
    }

    /**
     * Get address of household
     * @return string with address of household
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Get city of household
     * @return string with city of household
     */
    public String getCity() {
        return city;
    }
    /**
     * Get state of household
     * @return string with state of household
     */
    public String getState() {
        return state;
    }

    /**
     * Retrieve list of members
     * @return list of members
     */
    public List<Person> getMembers() {
        return members;
    }
}
