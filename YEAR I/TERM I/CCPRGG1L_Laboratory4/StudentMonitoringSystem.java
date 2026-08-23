import java.util.Scanner;

public class StudentMonitoringSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // STEP 2 - STUDENT DATA


        String[] studentNames = {
            "Ana", "Ben", "Carlo", "Diana", "Ella",
            "Frank", "Grace", "Henry", "Ivy", "John"
        };

        int[] grades = {
            92, 85, 78, 95, 89,
            72, 91, 76, 87, 68
        };

        int[] attendance = {
            95, 90, 88, 97, 92,
            80, 94, 85, 91, 75
        };

        int choice;

        // STEP 3 - MAIN MENU

        do {

            System.out.println("=============================================");
            System.out.println("     STUDENT MONITORING AND ACADEMIC");
            System.out.println("             REPORTING SYSTEM");
            System.out.println("=============================================");
            System.out.println();
            System.out.println("[1] Display Student Records");
            System.out.println("[2] Generate Academic Report");
            System.out.println("[3] Search Student");
            System.out.println("[4] Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println();


            // STEP 4 - DISPLAY STUDENT RECORDS


            if (choice == 1) {

                System.out.println("=============================================");
                System.out.println("             STUDENT RECORDS");
                System.out.println("=============================================");

                for (int i = 0; i < studentNames.length; i++) {

                    System.out.println(
                        (i + 1) + ". " +
                        studentNames[i] +
                        "    Grade: " +
                        grades[i] +
                        "    Attendance: " +
                        attendance[i] + "%"
                    );
                }

                System.out.println("=============================================");
                System.out.println();
            }


            // STEP 5 & 6 - ACADEMIC REPORT



            else if (choice == 2) {


            // STEP 5 - ACADEMIC REPORT


                System.out.println("=============================================");
                System.out.println("             ACADEMIC REPORT");
                System.out.println("=============================================");
                System.out.println();

                int index = 0;

                for (String student : studentNames) {

                    System.out.println(student);
                    System.out.println("Grade: " + grades[index]);

                    if (grades[index] >= 75) {
                        System.out.println("Status: PASSED");
                    } else {
                        System.out.println("Status: FAILED");
                    }

                    if (attendance[index] >= 85) {
                        System.out.println(
                            "Attendance: " +
                            attendance[index] +
                            "% - GOOD"
                        );
                    } else {
                        System.out.println(
                            "Attendance: " +
                            attendance[index] +
                            "% - LOW"
                        );
                    }

                    System.out.println();

                    index++;
                }


            // STEP 6 - ACADEMIC SUMMARY



                int totalStudents = studentNames.length;
                int totalPassed = 0;
                int totalFailed = 0;
                int goodAttendance = 0;

                int i = 0;

                while (i < studentNames.length) {

                    if (grades[i] >= 75) {
                        totalPassed++;
                    } else {
                        totalFailed++;
                    }

                    if (attendance[i] >= 85) {
                        goodAttendance++;
                    }

                    i++;
                }

                System.out.println("=============================================");
                System.out.println("             ACADEMIC SUMMARY");
                System.out.println("=============================================");
                System.out.println();
                System.out.println("Total Students: " + totalStudents);
                System.out.println("Total Passed: " + totalPassed);
                System.out.println("Total Failed: " + totalFailed);
                System.out.println(
                    "Attendance 85% and Above: " + goodAttendance
                );
                System.out.println();
                System.out.println("=============================================");
                System.out.println();
            }


            // STEP 7, 8 & 9 - SEARCH STUDENT

            else if (choice == 3) {

                System.out.print("Enter student name: ");
                String searchName = scanner.nextLine();

                boolean found = false;

                System.out.println();
                System.out.println("Starting search...");
                System.out.println();

                for (int i = 0; i < studentNames.length; i++) {

                    // STEP 8 - CONTINUE
                    // Skip students with attendance below 80%

                    if (attendance[i] < 80) {

                        System.out.println(
                            "Skipping " +
                            studentNames[i] +
                            " - Attendance below 80%"
                        );

                        continue;
                    }

                    System.out.println("Checking: " + studentNames[i]);

                    // STEP 7 & 9 - BREAK
                    // Stop the search when student is found

                    if (studentNames[i].equalsIgnoreCase(searchName)) {

                        System.out.println();
                        System.out.println("Student Found!");
                        System.out.println();
                        System.out.println("Name: " + studentNames[i]);
                        System.out.println("Grade: " + grades[i]);
                        System.out.println(
                            "Attendance: " + attendance[i] + "%"
                        );
                        System.out.println();

                        found = true;

                        break;
                    }
                }

                System.out.println();

                if (found) {

                    System.out.println(
                        "BREAK: Search stopped because the student was found."
                    );

                } else {

                    System.out.println("Student not found.");
                }

                System.out.println();
            }


            // STEP 10 - EXIT PROGRAM
          

            else if (choice == 4) {

                System.out.println("=============================================");
                System.out.println();         
                System.out.println("            Program terminated.");
                System.out.println();
                System.out.println("=============================================");
    
            }

            // INVALID CHOICE


            else {

                System.out.println("Invalid choice. Please select 1-4.");
                System.out.println();
            }


        } while (choice != 4);

        scanner.close();
    }
}