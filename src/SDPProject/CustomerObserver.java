package SDPProject;

// File: CustomerObserver.java
public class CustomerObserver implements Observer {
    private String name;

    public CustomerObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(OrderStatus status) {
        System.out.println("Уважаемый клиент " + name + ", статус вашего заказа изменился на: " + status);
    }
}// File: WaiterObserver.java
class WaiterObserver implements Observer {
    private String name;

    public WaiterObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(OrderStatus status) {
        System.out.println("Официант " + name + ", статус заказа изменился на: " + status);
    }
}
