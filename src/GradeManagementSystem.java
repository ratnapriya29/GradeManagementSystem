import java.util.Scanner;

public class GradeManagementSystem {

    static final int MAX_STUDENTS = 100;
    static final int SUBJECTS = 5;

    static String[] names = new String[MAX_STUDENTS];
    static double[][] marks = new double[MAX_STUDENTS][SUBJECTS];
    static int studentCount = 0;

    static String[] subjects = {"Math","Science","English","History","Computer"};
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.Exit");
            System.out.println("4.Search Student");
            System.out.println("5.Top Performer");
            System.out.println("6.Report");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) addStudent();
            else if (choice == 2) viewStudents();
            else if (choice == 3) break;
            else if (choice == 4) searchStudent();
            else if (choice == 5) topPerformer();
            else if (choice == 6) report();
        }
    }

    static void addStudent() {

        System.out.print("Enter name: ");
        names[studentCount] = sc.nextLine();

        for (int i = 0; i < SUBJECTS; i++) {
            System.out.print("Enter " + subjects[i] + " marks: ");
            marks[studentCount][i] = sc.nextDouble();
        }
        sc.nextLine();

        studentCount++;
        System.out.println("Student added!");
    }

    static void viewStudents() {

        for (int i = 0; i < studentCount; i++) {

            double avg = 0;
            for (int j = 0; j < SUBJECTS; j++)
                avg += marks[i][j];

            avg /= SUBJECTS;

            System.out.println(names[i] + " Average=" + avg + " Grade=" + getGrade(avg));
        }
    }

    // ✅ MOVE FUNCTION HERE (inside class)
    static String getGrade(double avg) {
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }
    static void searchStudent() {

    System.out.print("Enter name: ");
    String n = sc.nextLine();

    for (int i = 0; i < studentCount; i++) {
        if (names[i].equalsIgnoreCase(n)) {

            double avg = 0;
            for (int j = 0; j < SUBJECTS; j++)
                avg += marks[i][j];

            avg /= SUBJECTS;

            System.out.println("Found!");
            System.out.println("Average=" + avg);
            System.out.println("Grade=" + getGrade(avg));
            return;
        }
    }

    System.out.println("Student not found");
}
static void topPerformer() {

    double highest = 0;
    int index = 0;

    for (int i = 0; i < studentCount; i++) {

        double avg = 0;
        for (int j = 0; j < SUBJECTS; j++)
            avg += marks[i][j];

        avg /= SUBJECTS;

        if (avg > highest) {
            highest = avg;
            index = i;
        }
    }

    System.out.println("Topper: " + names[index] + " Avg=" + highest);
}
static void report() {

    double highest = 0;
    double lowest = 100;

    for (int i = 0; i < studentCount; i++) {

        double avg = 0;
        for (int j = 0; j < SUBJECTS; j++)
            avg += marks[i][j];

        avg /= SUBJECTS;

        if (avg > highest) highest = avg;
        if (avg < lowest) lowest = avg;
    }

    System.out.println("Highest Avg=" + highest);
    System.out.println("Lowest Avg=" + lowest);
}
}