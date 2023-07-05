import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.empty();
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        if (hasAddress()) {
            return address;
        } else {
            return "Address is unknown. Please set address";
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        int increasedAge = 0;
        if (age.isPresent()) {
            increasedAge = age.getAsInt();
            increasedAge++;
        }
        age = OptionalInt.of(increasedAge);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(surname);
        childBuilder.setAge(0);
        if (hasAddress()) {
            childBuilder.setAddress(address);
        }
        return childBuilder;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Name: " + name + " | Surname: " + surname);

        if (age.isPresent()) {
            builder.append(" | Age: ").append(getAge().getAsInt());
        }
        if (address != null) {
            builder.append(" | Address: ").append(address);
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}