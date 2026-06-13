package DesignPatterns.Creational.BuilderPattern;

public class User {

    private final String firstName;
    private final String lastName;

    private final int age;
    private final String email;
    private final String address;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "User : " +
                "name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' + "";
    }


    public static class Builder {
        private final String firstName;
        private final String lastName;

        private int age;
        private String email;
        private String address;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }


    }

}
