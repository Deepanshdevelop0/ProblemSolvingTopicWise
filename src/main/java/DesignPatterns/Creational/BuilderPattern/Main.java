package DesignPatterns.Creational.BuilderPattern;

public class Main {

    public static void main(String[] args) {
        User user1 = new User.Builder("Aman", "Talreja")
                .setAge(20)
                .build();

        User user2 = new User.Builder("Amax", "Talreja")
                .setEmail("amaxTalre2017@gmail.com")
                .build();

        System.out.println("user1 : " + user1.toString());
        System.out.println("user1 : " + user2.toString());


    }
}
