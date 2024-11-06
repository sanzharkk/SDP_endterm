package SDPProject;

// File: Main.java
public class Main {
    public static void main(String[] args) {
        // Создаем фасад для управления заказами
        OrderFacade orderFacade = new OrderFacade();

        // Создаем представление
        View view = new View();

        // Создаем контроллер
        Controller controller = new Controller(orderFacade, view);

        // Запускаем приложение
        controller.start();
    }
}




