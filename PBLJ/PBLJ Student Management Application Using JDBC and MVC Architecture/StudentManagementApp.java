public class StudentManagementApp {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        StudentView view = new StudentView();

        int choice;
        do {
            choice = view.showMenuAndGetChoice();

            switch (choice) {
                case 1:
                    Student newStudent = view.getStudentDetails();
                    if (controller.addStudent(newStudent)) {
                        view.showMessage("Student added successfully.");
                    } else {
                        view.showMessage("Failed to add student.");
                    }
                    break;
                case 2:
                    view.showStudents(controller.getAllStudents());
                    break;
                case 3:
                    int updateId = view.getStudentId("update");
                    Student updatedStudent = view.getStudentDetails();
                    // Ensure StudentID matches the one to update
                    updatedStudent.setStudentID(updateId);
                    if (controller.updateStudent(updatedStudent)) {
                        view.showMessage("Student updated successfully.");
                    } else {
                        view.showMessage("Failed to update student.");
                    }
                    break;
                case 4:
                    int deleteId = view.getStudentId("delete");
                    if (controller.deleteStudent(deleteId)) {
                        view.showMessage("Student deleted successfully.");
                    } else {
                        view.showMessage("Failed to delete student.");
                    }
                    break;
                case 5:
                    view.showMessage("Exiting application. Goodbye!");
                    break;
                default:
                    view.showMessage("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
