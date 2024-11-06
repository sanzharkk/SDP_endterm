package SDPProject;

// File: User.java
public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract void performRole();

    public String getName() {
        return name;
    }
}
