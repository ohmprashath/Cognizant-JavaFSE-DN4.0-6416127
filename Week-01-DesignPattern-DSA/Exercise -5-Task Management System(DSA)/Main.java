public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task(1, "Design Database", "Pending"));
        manager.addTask(new Task(2, "Implement API", "In Progress"));
        manager.addTask(new Task(3, "Test Application", "Not Started"));

        System.out.println("\nAll Tasks:");
        manager.displayAllTasks();

        System.out.println("\nSearch Task ID 2:");
        Task found = manager.searchTask(2);
        if (found != null) found.displayTask();
        else System.out.println("Task not found.");

        System.out.println("\nDelete Task ID 2:");
        manager.deleteTask(2);

        System.out.println("\nAll Tasks After Deletion:");
        manager.displayAllTasks();
    }
}
