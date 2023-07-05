import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0 && age < 150) {
            this.age = OptionalInt.of(age);
            return this;
        } else {
            throw new IllegalArgumentException("Inadequate age input! The value can't be neither negative nor larger than 150");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person instance;
        if (this.name == null | this.surname == null) {
            throw new IllegalStateException("Both name and surname can't be null");
        }
        if (age.isEmpty()) {
            instance = new Person(this.name, this.surname);
        } else {
            instance = new Person(this.name, this.surname, this.age.getAsInt());
        }
        if (address != null) {
            instance.setAddress(address);
        }
        return instance;
    }

}