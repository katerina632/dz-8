public class Main {

    public static void main(String[] args) {
        Student headman = new Student("Bob", "Cool");
        Group group = new Group(headman);

        Student student2 = new Student("Nancy", "Drew");
        Student student3 = new Student("Ben", "Black");

        System.out.println("Headman of the group is " + group.getHeadman());
        group.addStudent(student2);
        group.addStudent(student2);
        group.addStudent(student3);
        group.viewAllStudents();

        group.deleteStudent(1);
        group.changeHeadman(student3);
        System.out.println("Headman of the group is " + group.getHeadman());

        group.changeName("HmmName",2);
        group.changeSurname("HmmSurname",2);
        group.viewAllStudents();

        group.assignTaskForGroup("First Task");
        group.assignTaskForGroup("Second Task");
        group.completeTask(1,"First Task");
        group.completeTask(2,"fd");
        group.completeTask(2,"first task");
        group.completeTask(2,"Second Task");
        group.completeTask(2,"Second Task");
        group.showCompletedTasks();
        group.deleteStudent(2);
        group.showCompletedTasks();
    }


}
