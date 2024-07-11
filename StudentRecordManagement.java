import java.util.*;

interface Student {
    void addStudent();

    void updateStudent();

    void deleteStudent();

    void readStudentDetails();

    void listStudents();
}

class StudentDetails {
    int enroll;
    String name;
    int age;
    String grade;

    public StudentDetails(int enroll, String name, int age, String grade) {
        this.enroll = enroll;
        this.name = name;
        this.age = age;
        this.grade = grade;

    }

    public int getEnroll() {
        return enroll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void displayDetails() {
        System.out.println("Enroll no.: " + enroll);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }

}

class StudentRecord implements Student {
    ArrayList<StudentDetails> students = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void addStudent() {
        System.out.println("Enter Student Enrollment Number: ");
        int enroll = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter Student Name: ");
        String name = scan.nextLine();

        System.out.println("Enter Age: ");
        int age = scan.nextInt();
        scan.nextLine();

        System.out.println("Enter Student Grade: ");
        String grade = scan.nextLine();

        students.add(new StudentDetails(enroll, name, age, grade));
        System.out.println("New Student added!");

    }

    public void updateStudent() {
        System.out.println("Enter Student Enroll to update: ");
        int enroll = scan.nextInt();
        scan.nextLine();

        for (StudentDetails student : students) {
            if (student.getEnroll() == enroll) {
                System.out.println("Enter new Student Name: ");
                String name = scan.nextLine();
                student.setName(name);

                System.out.println("Enter new Age: ");
                int age = scan.nextInt();
                scan.nextLine();
                student.setAge(age);

                System.out.println("Enter new Grade: ");
                String grade = scan.nextLine();
                student.setGrade(grade);

                System.out.println("Student updated!");
                return;

            }
        }
        System.out.println("Student not found!");
    }

    public void deleteStudent() {
        System.out.println("Enter Student Enroll to delete: ");
        int enroll = scan.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getEnroll() == enroll) {
                students.remove(i);
                System.out.println("Student deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void readStudentDetails() {
        System.out.println("Enter Student Enroll to read details: ");
        int enroll = scan.nextInt();

        for (StudentDetails student : students) {
            if (student.getEnroll() == enroll) {
                student.displayDetails();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("Listing All students: ");
            for (StudentDetails student : students) {
                student.displayDetails();
                System.out.println("************************");
            }
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentRecord studentRecord = new StudentRecord();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Student Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Read Student Details");
            System.out.println("5. List All Students");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    studentRecord.addStudent();
                    break;
                case 2:
                    studentRecord.updateStudent();
                    break;
                case 3:
                    studentRecord.deleteStudent();
                    break;
                case 4:
                    studentRecord.listStudents();
                    break;
                case 5:
                    studentRecord.listStudents();
                    break;
                case 6:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
