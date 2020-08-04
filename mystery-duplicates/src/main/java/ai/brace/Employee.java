package ai.brace;

public class Employee {
    public String firstName;
    public String middleInitial;
    public String lastName;
    public String socialSecurityNumber;

    public Employee(String _lastName, String _firstName, String _middleInitial, String _socialSecurityNumber) {
        firstName = _firstName;
        middleInitial = _middleInitial;
        lastName = _lastName;
        socialSecurityNumber = _socialSecurityNumber;
    }

    //In order for the hashmap to recognize duplicate keys, we need to override Java's equals and hashcode methods. Assuming social security is a reasonable way to check for uniqueness, we can just use it. Social security is also easy to turn into an integer which will be useful in the hashCode method.
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Employee)) {
            return false;
        }

        Employee e = (Employee) o;

        return e.socialSecurityNumber.equals(this.socialSecurityNumber);
    }

    //This is a simple implementation of hashCode.
    @Override
    public int hashCode() {

        return Integer.parseInt(this.socialSecurityNumber.replace("-", ""));
    }
}