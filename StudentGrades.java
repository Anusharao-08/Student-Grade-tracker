import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt(); // Use nextInt() instead of nextline()
        scanner.nextLine(); // Consume the newline character left by nextInt()

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student " + (i + 1) + "'s name: ");
            String name = scanner.nextLine(); // Use nextLine() to handle names with spaces

            System.out.print("Enter student " + (i + 1) + "'s grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character left by nextDouble()
            students.add(new Student(name, grade));
        }

        double average = calculateAverage(students);
        double highest = findHighestGrade(students);
        double lowest = findLowestGrade(students);

        System.out.println("\nStudent Grades:");
        for (Student student : students) {
            System.out.println(student.name + ": " + student.grade);
        }

        System.out.println("\nAverage Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);

        scanner.close(); // Close the scanner to release resources
    }

    private static double calculateAverage(ArrayList<Student> students) {
        if (students.isEmpty()) { // Handle the case where there are no students
            return 0; // Or throw an exception, depending on your requirements
        }
        double sum = 0;
        for (Student student : students) {
            sum += student.grade;
        }
        return sum / students.size();
    }

    private static double findHighestGrade(ArrayList<Student> students) {
        if (students.isEmpty()) { // Handle the case where there are no students
            return 0; // Or throw an exception, depending on your requirements
        }
        double highest = students.get(0).grade;
        for (Student student : students) {
            if (student.grade > highest) {
                highest = student.grade;
            }
        }
        return highest;
    }

    private static double findLowestGrade(ArrayList<Student> students) {
        if (students.isEmpty()) { // Handle the case where there are no students
           return 0; // Or throw an exception, depending on your requirements
        }
        double lowest = students.get(0).grade;
        for (Student student : students) {
            if (student.grade < lowest) {
                lowest = student.grade;
            }
        }
        return lowest;
    }
}
