class TaskManager {
    private TaskNode head;

    // Add Task at the End
    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task added: " + task.taskName);
    }

    // Search Task by ID
    public Task searchTask(int taskId) {
        TaskNode temp = head;
        while (temp != null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Traverse all Tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
        } else {
            TaskNode temp = head;
            while (temp != null) {
                temp.task.displayTask();
                temp = temp.next;
            }
        }
    }

    // Delete Task by ID
    public boolean deleteTask(int taskId) {
        if (head == null) return false;

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted with ID: " + taskId);
            return true;
        }

        TaskNode current = head;
        while (current.next != null) {
            if (current.next.task.taskId == taskId) {
                current.next = current.next.next;
                System.out.println("Task deleted with ID: " + taskId);
                return true;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
        return false;
    }
}
