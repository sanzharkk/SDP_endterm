package SDPProject;

// File: UserFactory.java
public class UserFactory {
    public static User createUser(String role, String name) {
        switch (role.toLowerCase()) {
            case "customer":
                return new Customer(name);
            case "waiter":
                return new Waiter(name);
            case "chef":
                return new Chef(name);
            case "manager":
                return new Manager(name);
            default:
                throw new IllegalArgumentException("Неверная роль: " + role);
        }
    }
}

