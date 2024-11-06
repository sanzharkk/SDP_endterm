package SDPProject;

// File: Manager.java
public class Manager extends User {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void performRole() {
        System.out.println(name + " может управлять персоналом и просматривать отчеты.");
    }
}

