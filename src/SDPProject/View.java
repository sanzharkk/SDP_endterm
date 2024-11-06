package SDPProject;

// File: View.java
public class View {

    public void displayLogin() {
        System.out.println("=== Вход в систему ===");
    }

    public void displayMenu(User user) {
        System.out.println("\n=== Главное меню ===");
        if (user instanceof Customer) {
            System.out.println("1. Разместить заказ");
            System.out.println("2. Выйти");
        } else if (user instanceof Waiter) {
            System.out.println("1. Просмотреть заказы");
            System.out.println("2. Выйти");
        } else if (user instanceof Chef) {
            System.out.println("1. Обновить статус заказа");
            System.out.println("2. Выйти");
        } else if (user instanceof Manager) {
            System.out.println("1. Управление персоналом");
            System.out.println("2. Выйти");
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

