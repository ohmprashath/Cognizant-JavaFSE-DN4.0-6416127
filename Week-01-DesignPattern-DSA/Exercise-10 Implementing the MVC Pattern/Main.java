public class Main {
    public static void main(String[] args) {
        Student student = new Student("John", 1, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();
        controller.setStudentName("Alice");
        controller.setStudentGrade("B+");
        controller.updateView();
    }
}
