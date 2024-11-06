package SDPProject;

// File: Controller.java
import java.util.Scanner;

public class Controller {
    private OrderFacade orderFacade;
    private View view;
    private User currentUser;

    public Controller(OrderFacade orderFacade, View view) {
        this.orderFacade = orderFacade;
        this.view = view;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (currentUser == null) {
                view.displayLogin();
                System.out.print("Выберите роль (customer/waiter/chef/manager) или 'exit' для выхода: ");
                String role = scanner.nextLine();
                if (role.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.print("Введите имя пользователя: ");
                String name = scanner.nextLine();
                try {
                    currentUser = UserFactory.createUser(role, name);
                    view.displayMessage("Добро пожаловать, " + currentUser.getName() + " (" + role + ")!");
                } catch (IllegalArgumentException e) {
                    view.displayMessage("Ошибка: " + e.getMessage());
                }
            } else {
                view.displayMenu(currentUser);
                System.out.print("Выберите действие: ");
                String action = scanner.nextLine();
                handleAction(action, scanner);
            }
        }
        scanner.close();
    }

    private void handleAction(String action, Scanner scanner) {
        switch (action.toLowerCase()) {
            case "1":
                if (currentUser instanceof Customer) {
                    placeOrder(scanner);
                } else if (currentUser instanceof Waiter) {
                    viewOrders();
                } else if (currentUser instanceof Chef) {
                    updateOrderStatus(scanner, OrderStatus.IN_PROGRESS);
                } else if (currentUser instanceof Manager) {
                    // Дополнительные действия для менеджера
                    view.displayMessage("Функционал для менеджера еще не реализован.");
                }
                break;
            case "2":
                if (currentUser instanceof Customer) {
                    view.displayMessage("Выход из системы.");
                    currentUser = null;
                } else if (currentUser instanceof Waiter) {
                    // Дополнительные действия для официанта
                    view.displayMessage("Функционал для официанта еще не реализован.");
                } else if (currentUser instanceof Chef) {
                    // Дополнительные действия для повара
                    view.displayMessage("Функционал для повара еще не реализован.");
                } else if (currentUser instanceof Manager) {
                    // Дополнительные действия для менеджера
                    view.displayMessage("Функционал для менеджера еще не реализован.");
                }
                break;
            case "exit":
                view.displayMessage("Завершение работы.");
                System.exit(0);
                break;
            default:
                view.displayMessage("Неверный выбор. Пожалуйста, попробуйте снова.");
        }
    }

    private void placeOrder(Scanner scanner) {
        view.displayMessage("Создание заказа...");
        // Пример: добавление фиксированных позиций
        MenuItem pizza = new MenuItem("Pizza", 12.99);
        MenuItem soda = new MenuItem("Soda", 1.99);
        orderFacade.createOrder(pizza, soda);
    }

    private void viewOrders() {
        view.displayMessage("Просмотр всех заказов...");
        // Здесь можно реализовать просмотр всех текущих заказов
        view.displayMessage("Функционал просмотра заказов еще не реализован.");
    }

    private void updateOrderStatus(Scanner scanner, OrderStatus newStatus) {
        view.displayMessage("Обновление статуса заказа...");
        // Здесь можно реализовать выбор заказа и обновление его статуса
        // Для упрощения примера обновим статус текущего заказа
        orderFacade.updateOrderStatus(newStatus);
    }
}

