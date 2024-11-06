package SDPProject;

public class Customer extends User {
    public Customer(String name) {
        super(name);
    }

    @Override
    public void performRole() {
        System.out.println(name + " can browse menu and place orders.");
    }
}
class Waiter extends User {
    public Waiter(String name) {
        super(name);
    }

    @Override
    public void performRole() {
        System.out.println(name + " can manage orders and serve food.");
    }
}
class Chef extends User {
    public Chef(String name) {
        super(name);
    }

    @Override
    public void performRole() {
        System.out.println(name + " can view and prepare orders.");
    }
}
