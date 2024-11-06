package SDPProject;

// File: OrderInvoker.java
public class OrderInvoker {
    private Command command;

    // Устанавливаем команду
    public void setCommand(Command command) {
        this.command = command;
    }

    // Выполняем команду
    public void executeCommand() {
        if (command != null) {
            command.execute();
        }
    }
}

