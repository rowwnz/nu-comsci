import java.util.Scanner;
public class StudentEnrollmentSystem {

    // Variables

    static final int Max_students   = 50;
    static final double TUITION_RATE = 1850.0;   
    static final int MIN_UNITS      = 12;
    static final int MAX_UNITS      = 30;
    static final double MAX_LAB_FEE  = 5000.0;
    static final double MAX_MISC_FEE = 10000.0;

    static int[]    studentIds   = new int[Max_students];
    static String[] studentNames = new String[Max_students];
    static String[] courses      = new String[Max_students];
    static int[]    yearLevels   = new int[Max_students];
    static int[]    units        = new int[Max_students];
    static double[] tuitionFees  = new double[Max_students];
    static double[] labFees      = new double[Max_students];
    static double[] miscFees     = new double[Max_students];
    static double[] totalFees    = new double[Max_students];
    static String[] statuses     = new String[Max_students]; 

    static int studentCount = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = readInt("Enter Choice : ");

            switch (choice) {
                case 1: registerStudent();     break;
                case 2: enrollStudent();       break;
                case 3: displayStudents();     break;
                case 4: searchStudent();       break;
                case 5: enrollmentSummary();   break;
                case 6: exitProgram();         break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }

        } while (choice != 6);
    }

    static void displayMenu() {
        System.out.println("=========================================================");
        System.out.println("      STUDENT ENROLLMENT MANAGEMENT SYSTEM");
        System.out.println("=========================================================");
        System.out.println("[1] Register Student");
        System.out.println("[2] Enroll Student");
        System.out.println("[3] Display All Students");
        System.out.println("[4] Search Student");
        System.out.println("[5] Enrollment Summary");
        System.out.println("[6] Exit");
        System.out.println("=========================================================");
    }

    static void registerStudent() {
        System.out.println("=============== REGISTER STUDENT ===============");

        if (studentCount >= Max_students) {
            System.out.println("Registration failed. Maximum number of students (50) reached.");
            return;
        }

        int id;
        while (true) {
            id = readInt("Student ID                    : ");
            if (linearSearch(id) != -1) {
                System.out.println("Student ID already exists. Please enter a unique ID.");
            } else {
                break;
            }
        }

        String name = readNonEmptyString("Student Name: ");
        String course = readNonEmptyString("Course: ");

        int year;
        while (true) {
            year = readInt("Year Level                   : ");
            if (year < 1 || year > 4) {
                System.out.println("Invalid year level. Must be between 1 and 4.");
            } else {
                break;
            }
        }

        studentIds[studentCount]   = id;
        studentNames[studentCount] = name;
        courses[studentCount]      = course;
        yearLevels[studentCount]   = year;
        units[studentCount]        = 0;
        tuitionFees[studentCount]  = 0;
        labFees[studentCount]      = 0;
        miscFees[studentCount]     = 0;
        totalFees[studentCount]    = 0;
        statuses[studentCount]     = "NOT ENROLLED";

        studentCount++;

        System.out.println("Student successfully registered.");
        System.out.println("Enrollment Status: NOT ENROLLED");
    }


    // Module 2 

    static void enrollStudent() {
        System.out.println("================ ENROLL STUDENT ================");
        int id = readInt("Enter Student ID: ");

        int index = linearSearch(id);
        if (index == -1) {
            System.out.println("Student record not found.");
            return;
        }

        System.out.println("Student Found!");
        System.out.println("Student Name: " + studentNames[index]);

        int numUnits = readInt("Number of Units: ");

        if (numUnits < MIN_UNITS || numUnits > MAX_UNITS) {
            System.out.println("Maximum units exceeded.");
            System.out.println("Enrollment cancelled.");
            return;
        }

        double lab;
        while (true) {
            lab = readDouble("Laboratory Fee: ");
            if (lab < 0 || lab > MAX_LAB_FEE) {
                System.out.println("Invalid amount. Laboratory Fee must be between 0 and " + (MAX_LAB_FEE) );
            } else {
                break;
            }
        }

        double misc;
        while (true) {
            misc = readDouble("Miscellaneous Fee: ");
            if (misc < 0 || misc > MAX_MISC_FEE) {
                System.out.println("Invalid amount. Miscellaneous Fee must be between 0 and " + (MAX_MISC_FEE) );
            } else {
                break;
            }
        }

        double tuition = numUnits * TUITION_RATE;
        double total = tuition + lab + misc;

        units[index]       = numUnits;
        tuitionFees[index] = tuition;
        labFees[index]     = lab;
        miscFees[index]    = misc;
        totalFees[index]   = total;
        statuses[index]    = "ENROLLED";

        System.out.println("----------------------------------------");
        System.out.println("Tuition Fee: " + (tuition));
        System.out.println("Total Fees: " + (total));
        System.out.println("Enrollment Successful!");
        System.out.println("Enrollment Status: ENROLLED");
    }


    // Module 3 

    static void displayStudents() {
        System.out.println("================ ALL REGISTERED STUDENTS ================");

        if (studentCount == 0) {
            System.out.println("No students registered yet.");
            return;
        }

        for (int i = 0; i < studentCount; i++) {
            System.out.println("----------------------------------------");
            System.out.println("ID         : " + studentIds[i]);
            System.out.println("Name       : " + studentNames[i]);
            System.out.println("Course     : " + courses[i]);
            System.out.println("Year Level : " + yearLevels[i]);
            System.out.println("Units      : " + units[i]);
            System.out.println("Tuition    : " + (tuitionFees[i]));
            System.out.println("Total Fees : " + (totalFees[i]));
            System.out.println("Status     : " + statuses[i]);
        }
        System.out.println("----------------------------------------");
    }


    // Module 4 

    static void searchStudent() {
        System.out.println("================ SEARCH STUDENT ================");
        int id = readInt("Enter Student ID : ");

        int index = linearSearch(id);
        if (index == -1) {
            System.out.println("Student record not found.");
            return;
        }

        System.out.println("---------------------------------------");
        System.out.println("STUDENT INFORMATION");
        System.out.println("---------------------------------------");
        System.out.println("Student ID: " + studentIds[index]);
        System.out.println("Student Name: " + studentNames[index]);
        System.out.println("Course: " + courses[index]);
        System.out.println("Year Level: " + yearLevels[index]);
        System.out.println();
        System.out.println("Units: " + units[index]);
        System.out.println("Tuition Fee: " + (tuitionFees[index]));
        System.out.println("Laboratory Fee: " + (labFees[index]));
        System.out.println("Miscellaneous Fee: " + (miscFees[index]));
        System.out.println("Total Fees: " + (totalFees[index]));
        System.out.println("Enrollment Status: " + statuses[index]);
    }


    // Module 5 

    static void enrollmentSummary() {
        System.out.println("==================================================");
        System.out.println("         ENROLLMENT SUMMARY REPORT");
        System.out.println("==================================================");

        if (studentCount == 0) {
            System.out.println("No students registered yet.");
            System.out.println("==================================================");
            return;
        }

        int enrolledCount = 0;
        double totalTuitionCollected = 0;
        double highest = -1;
        double lowest = -1;

        for (int i = 0; i < studentCount; i++) {
            if (statuses[i].equals("ENROLLED")) {
                enrolledCount++;
                totalTuitionCollected += tuitionFees[i];

                if (highest == -1 || tuitionFees[i] > highest) {
                    highest = tuitionFees[i];
                }
                if (lowest == -1 || tuitionFees[i] < lowest) {
                    lowest = tuitionFees[i];
                }
            }
        }

        int notEnrolledCount = studentCount - enrolledCount;
        double average = (enrolledCount > 0) ? (totalTuitionCollected / enrolledCount) : 0;
        if (highest == -1) highest = 0;
        if (lowest == -1)  lowest = 0;

        System.out.println("Total Students Registered:  " + studentCount);
        System.out.println("Enrolled Students: " + enrolledCount);
        System.out.println("Not Enrolled: " + notEnrolledCount);
        System.out.println("Average Tuition: " + (average));
        System.out.println("Highest Tuition: " + (highest));
        System.out.println("Lowest Tuition: " + (lowest));
        System.out.println("Total Tuition Collection: " + (totalTuitionCollected));
        System.out.println("==================================================");
    }


    // Module 6 

    static void exitProgram() {
        System.out.println("==================================================");
        System.out.println("        Program Terminated Successfully.          ");
        System.out.println("==================================================");
    }



    static int linearSearch(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (studentIds[i] == id) {
                return i;
            }
        }
        return -1;
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("This field cannot be empty.");
        }
    }

        static String formatAmount(double amount) {
        double rounded = Math.round(amount * 100) / 100.0;
        return String.valueOf(rounded);
    }

}
