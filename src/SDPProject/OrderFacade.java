package SDPProject;

// File: OrderFacade.java
public class OrderFacade {
    private OrderInvoker invoker = new OrderInvoker();
    private Order order;

    public OrderFacade() {
        this.order = new Order();
    }

    // Создать заказ
    public void createOrder(MenuItem... items) {
        for (MenuItem item : items) {
            order.addItem(item);
        }

        Command createOrderCommand = new CreateOrderCommand(order);
        invoker.setCommand(createOrderCommand);
        invoker.executeCommand();
    }

    // Обновить статус заказа
    public void updateOrderStatus(OrderStatus newStatus) {
        Command updateStatusCommand = new UpdateOrderStatusCommand(order, newStatus);
        invoker.setCommand(updateStatusCommand);
        invoker.executeCommand();
    }

    // Отменить заказ
    public void cancelOrder() {
        Command cancelOrderCommand = new CancelOrderCommand(order);
        invoker.setCommand(cancelOrderCommand);
        invoker.executeCommand();
    }

    // Добавить наблюдателя к заказу (например, клиента или официанта)
    public void addObserver(Observer observer) {
        order.addObserver(observer);
    }
}

