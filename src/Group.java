import java.util.*;

public class Group {
    private Student headman;
    private final List<Student> listOfStudents = new ArrayList<>();
    private final List<String> listOfTasks = new ArrayList<>();
    private final Map<Student, HashSet<String>> listOfCompletedTasks = new HashMap<>();

    public Group(Student headman) {
        this.headman = headman;
        addStudent(headman);
    }

    public void changeHeadman(Student newHeadman) {
        boolean isExist = false;
        for (Student student : listOfStudents) {
            if (student.equals(newHeadman)) {
                isExist = true;
                this.headman = newHeadman;
                break;
            }
        }
        if (!isExist)
            System.out.println("Add this student to the group at first!");

    }

    public void viewAllStudents() {
        for (Student student : listOfStudents) {
            System.out.println(student);
        }
    }

    public void addStudent(Student newStudent) {
        boolean isExist = false;
        for (Student student : listOfStudents) {
            if (student.equals(newStudent)) {
                isExist = true;
                System.out.println("Such student is already added to the group!");
            }
        }
        if (!isExist) {
            listOfStudents.add(newStudent);
            HashSet<String> completedTasks = new HashSet<>();
            listOfCompletedTasks.put(newStudent, completedTasks);
        }

    }

    public void changeName(String newName, int studentId) {
        boolean isExist = false;
        for (Student student : listOfStudents) {
            if (student.getID() == studentId) {
                student.setName(newName);
                System.out.printf("Name was changed for student with ID=%d.\n", studentId);
                isExist = true;
            }
        }
        if (!isExist)
            System.out.printf("Student with ID=%d doesn't exist.\n", studentId);


    }

    public void changeSurname(String newSurname, int studentId) {
        boolean isExist = false;
        for (Student student : listOfStudents) {
            if (student.getID() == studentId) {
                student.setSurname(newSurname);
                System.out.printf("Surname was changed for student with ID=%d.\n", studentId);
                isExist = true;
            }
        }
        if (!isExist)
            System.out.printf("Student with ID=%d doesn't exist.\n", studentId);


    }

    public void deleteStudent(int studentId) {
        boolean isExist = false;
        for (Student student : listOfStudents) {
            if (student.getID() == studentId) {
                isExist = true;
                if (student.equals(headman)) {
                    System.out.println("Change headman before removing!");
                    break;
                }
                listOfStudents.remove(studentId - 1);
                listOfCompletedTasks.remove(student);
                System.out.printf("Student with ID=%d was removed from the group.\n", studentId);
                break;
            }
        }
        if (!isExist)
            System.out.printf("Student with ID=%d doesn't exist.\n", studentId);
    }

    public void assignTaskForGroup(String task) {
        listOfTasks.add(task);
    }

    public void completeTask(int studentId, String completedTask) {
        boolean isExistStudent = false;
        boolean isExistTask = false;

        for (Student student : listOfStudents) {
            if (student.getID() == studentId) {
                isExistStudent = true;
                for (String task : listOfTasks) {
                    if (task.equalsIgnoreCase(completedTask)) {
                        isExistTask = true;
                        HashSet<String> helpSet = listOfCompletedTasks.get(student);
                        helpSet.add(task);
                        listOfCompletedTasks.put(student, helpSet);
                        System.out.printf("\"%s\" was marked as completed for student with ID=%d.\n", task, studentId);
                        break;
                    }
                }
                break;
            }
        }

        if (!isExistStudent)
            System.out.printf("Student with ID=%d doesn't exist.\n", studentId);
        if (!isExistTask && isExistStudent)
            System.out.println("Such task doesn't exist.");
    }

    public Student getHeadman() {
        return this.headman;
    }

    public void showCompletedTasks() {
        for (Student student : listOfCompletedTasks.keySet()) {
            System.out.print(student + ":");
            if (listOfCompletedTasks.get(student).isEmpty())
                System.out.println(" no completed tasks.");
            for (String task : listOfCompletedTasks.get(student)) {
                System.out.printf("\n- %s;", task);
            }
            System.out.println();
        }
    }

}
