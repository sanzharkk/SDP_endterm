package SDPProject;

// File: CreateOrderCommand.java
public class CreateOrderCommand implements Command {
    private Order order;

    public CreateOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("Создание нового заказа...");
        // Логика для добавления заказа в систему
        System.out.println(order);
    }
}
// File: CancelOrderCommand.java
class CancelOrderCommand implements Command {
    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("Отмена заказа...");
        order.setStatus(OrderStatus.CREATED); // Вернем статус в исходное состояние
        System.out.println("Заказ отменен.");
    }
}
// File: UpdateOrderStatusCommand.java
 class UpdateOrderStatusCommand implements Command {
    private Order order;
    private OrderStatus newStatus;

    public UpdateOrderStatusCommand(Order order, OrderStatus newStatus) {
        this.order = order;
        this.newStatus = newStatus;
    }

    @Override
    public void execute() {
        System.out.println("Обновление статуса заказа...");
        order.setStatus(newStatus);
        System.out.println("Новый статус заказа: " + newStatus);
    }
}


