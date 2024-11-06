package SDPProject;

// File: Order.java
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items = new ArrayList<>();
    private double total;
    private OrderStatus status;
    private List<Observer> observers = new ArrayList<>();

    public Order() {
        this.status = OrderStatus.CREATED;
    }

    public void addItem(MenuItem item) {
        items.add(item);
        total += item.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    // Добавляем наблюдателя
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Удаляем наблюдателя
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Устанавливаем новый статус и уведомляем наблюдателей
    public void setStatus(OrderStatus newStatus) {
        this.status = newStatus;
        notifyObservers();
    }

    // Уведомляем всех наблюдателей
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Order Details:\n");
        for (MenuItem item : items) {
            orderDetails.append(item.toString()).append("\n");
        }
        orderDetails.append("Total: $").append(total);
        orderDetails.append("\nStatus: ").append(status);
        return orderDetails.toString();
    }
}

