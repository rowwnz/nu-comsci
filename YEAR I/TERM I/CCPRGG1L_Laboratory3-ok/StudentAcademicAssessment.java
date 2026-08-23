import java.util.Scanner;

public class StudentAcademicAssessment{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            // Step 2 – Main Menu
     
            System.out.println();
            System.out.println("==============================================");
            System.out.println("       STUDENT ACADEMIC ASSESSMENT SYSTEM");
            System.out.println("==============================================");
            System.out.println();
            System.out.println("[1] Evaluate Student");
            System.out.println("[2] Display Academic Criteria");
            System.out.println("[3] Exit");
            System.out.println();
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // CASE 1 – Evaluate Student

                case 1:

                    // Step 3 – Enter Student Information

                    System.out.println();
                    System.out.println("==============================================");
                    System.out.println("                EVALUATE STUDENT");
                    System.out.println("==============================================");

                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();

                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();

                    System.out.println();
                    System.out.println("Select Program:");
                    System.out.println();
                    System.out.println("[1] BS Computer Science");
                    System.out.println("[2] BS Information Technology");
                    System.out.println("[3] BS Information Systems");
                    System.out.println("[4] BS Cybersecurity");
                    System.out.println();

                    System.out.print("Enter program choice: ");
                    int programChoice = scanner.nextInt();

                    String program = "";
                    boolean programSelected = true;

                    switch (programChoice) {

                        case 1:
                            program = "BS Computer Science";
                            break;

                        case 2:
                            program = "BS Information Technology";
                            break;

                        case 3:
                            program = "BS Information Systems";
                            break;

                        case 4:
                            program = "BS Cybersecurity";
                            break;

                        default:
                            System.out.println("Invalid program choice.");
                            programSelected = false;
                            break;
                    }

                // Do not continue if program choice is invalid
                    if (!programSelected) {
                        break;
                    }

                    System.out.println("Selected Program: " + program);

                    // Step 4 – Enter Academic Data

                    System.out.println();
                    System.out.println("========== ENTER ACADEMIC DATA ==========");

                    System.out.print("Enter Final Grade: ");
                    double finalGrade = scanner.nextDouble();

                    System.out.print("Enter Attendance Percentage: ");
                    double attendancePercentage = scanner.nextDouble();

                    System.out.print("Enter Laboratory Performance: ");
                    double laboratoryPerformance = scanner.nextDouble();

                    System.out.print("Enter Major Examination Score: ");
                    double majorExaminationScore = scanner.nextDouble();

                    System.out.print("Enter Number of Failed Subjects: ");
                    int failedSubjects = scanner.nextInt();

                    // =================================================
                    // Step 5 – Validate the Input
                    // =================================================

                    boolean validInput =
                            finalGrade >= 0 && finalGrade <= 100 &&
                            attendancePercentage >= 0 && attendancePercentage <= 100 &&
                            laboratoryPerformance >= 0 && laboratoryPerformance <= 100 &&
                            majorExaminationScore >= 0 && majorExaminationScore <= 100 &&
                            failedSubjects >= 0;

                    if (!validInput) {

                        System.out.println();
                        System.out.println("Invalid input.");
                        System.out.println("Please enter a valid value.");

                        break;
                    }

                    // Step 6 – Classify the Final Grade


                    String gradeClassification;

                    if (finalGrade >= 95 && finalGrade <= 100) {
                        gradeClassification = "OUTSTANDING";

                    } else if (finalGrade >= 90) {
                        gradeClassification = "EXCELLENT";

                    } else if (finalGrade >= 85) {
                        gradeClassification = "VERY GOOD";

                    } else if (finalGrade >= 80) {
                        gradeClassification = "GOOD";

                    } else if (finalGrade >= 75) {
                        gradeClassification = "PASSED";

                    } else {
                        gradeClassification = "FAILED";
                    }

                    // Step 7 – Determine Pass or Fail


                    String status;

                    if (finalGrade >= 75) {
                        status = "PASSED";
                    } else {
                        status = "FAILED";
                    }

                    // Step 8 – Evaluate Attendance

                    String attendanceStatus;

                    if (attendancePercentage >= 95) {

                        if (attendancePercentage <= 100) {
                            attendanceStatus = "EXCELLENT ATTENDANCE";
                        } else {
                            attendanceStatus = "INVALID ATTENDANCE";
                        }

                    } else {

                        if (attendancePercentage >= 90) {
                            attendanceStatus = "VERY GOOD ATTENDANCE";

                        } else {

                            if (attendancePercentage >= 80) {
                                attendanceStatus = "SATISFACTORY ATTENDANCE";

                            } else {

                                if (attendancePercentage >= 75) {
                                    attendanceStatus = "ATTENDANCE WARNING";

                                } else {
                                    attendanceStatus = "CRITICAL ATTENDANCE WARNING";
                                }
                            }
                        }
                    }

                    // Step 9 – Evaluate Performance

                    String performance;

                    if (laboratoryPerformance >= 85 &&
                        majorExaminationScore >= 85) {

                        performance = "STRONG";

                    } else if (laboratoryPerformance >= 75 ||
                               majorExaminationScore >= 75) {

                        performance = "SATISFACTORY";

                    } else {

                        performance = "NEEDS IMPROVEMENT";
                    }

                    // Step 10 – Determine Academic Standing
                    // Nested if statements

                    String academicStanding;

                    if (finalGrade >= 90) {

                        if (attendancePercentage >= 90 &&
                            laboratoryPerformance >= 85 &&
                            majorExaminationScore >= 85 &&
                            failedSubjects == 0) {

                            academicStanding = "DEAN'S LIST";

                        } else {

                            if (finalGrade >= 75 &&
                                attendancePercentage >= 80 &&
                                failedSubjects <= 1) {

                                academicStanding = "GOOD ACADEMIC STANDING";

                            } else {

                                academicStanding = "ACADEMIC MONITORING";
                            }
                        }

                    } else {

                        if (finalGrade >= 75) {

                            if (attendancePercentage >= 80 &&
                                failedSubjects <= 1) {

                                academicStanding = "GOOD ACADEMIC STANDING";

                            } else {

                                academicStanding = "ACADEMIC MONITORING";
                            }

                        } else {

                            academicStanding = "ACADEMIC INTERVENTION";
                        }
                    }

                    // Step 11 – Determine Scholarship Status

                    String scholarshipStatus;

                    if (finalGrade >= 90 &&
                        attendancePercentage >= 90 &&
                        laboratoryPerformance >= 85 &&
                        majorExaminationScore >= 85 &&
                        failedSubjects == 0) {

                        scholarshipStatus = "ELIGIBLE";

                    } else if (finalGrade >= 90 &&
                               attendancePercentage >= 85 &&
                               majorExaminationScore >= 85 &&
                               failedSubjects == 0) {

                        scholarshipStatus = "CONDITIONAL ELIGIBILITY";

                    } else {

                        scholarshipStatus = "NOT ELIGIBLE";
                    }

                    // Step 12 – Determine Academic Risk

                    String riskLevel;

                    if (finalGrade >= 85 &&
                        attendancePercentage >= 85 &&
                        failedSubjects == 0) {

                        riskLevel = "LOW RISK";

                    } else if (finalGrade >= 75 &&
                               attendancePercentage >= 80 &&
                               failedSubjects <= 1) {

                        riskLevel = "MODERATE RISK";

                    } else if (finalGrade < 75 ||
                               attendancePercentage < 75 ||
                               failedSubjects >= 3) {

                        riskLevel = "HIGH RISK";

                    } else {

                        // Fallback for cases not covered by the
                        // specified conditions
                        riskLevel = "MODERATE RISK";
                    }

                    // Step 13 – Determine Recommended Action

                    String recommendation;

                    if (academicStanding.equals("DEAN'S LIST")) {

                        recommendation =
                                "Maintain excellent academic performance.";

                    } else if (academicStanding.equals("GOOD ACADEMIC STANDING")) {

                        recommendation =
                                "Continue your current academic performance.";

                    } else if (academicStanding.equals("ACADEMIC MONITORING")) {

                        recommendation =
                                "Consult your academic adviser and improve weak areas.";

                    } else {

                        recommendation =
                                "Immediate academic intervention is required.";
                    }

                    // =================================================
                    // Step 14 – Display Final Report
                    // =================================================

                    System.out.println();
                    System.out.println("==============================================");
                    System.out.println("              STUDENT EVALUATION");
                    System.out.println("==============================================");
                    System.out.println();

                    System.out.println("Student Name      : " + studentName);
                    System.out.println("Student ID        : " + studentID);
                    System.out.println("Program           : " + program);

                    System.out.println();

                    System.out.println("Final Grade       : " + finalGrade);
                    System.out.println("Classification    : " + gradeClassification);
                    System.out.println("Status            : " + status);

                    System.out.println();

                    System.out.println("Attendance        : " + attendancePercentage + "%");
                    System.out.println("Attendance Status : " + attendanceStatus);

                    if (attendancePercentage < 75) {
                        System.out.println();
                        System.out.println("WARNING:");
                        System.out.println("Student may require attendance intervention.");
                    }

                    System.out.println();

                    System.out.println("Laboratory        : " + laboratoryPerformance);
                    System.out.println("Major Examination : " + majorExaminationScore);
                    System.out.println("Performance       : " + performance);

                    System.out.println();

                    System.out.println("Academic Standing : " + academicStanding);
                    System.out.println("Scholarship       : " + scholarshipStatus);
                    System.out.println("Risk Level        : " + riskLevel);

                    System.out.println();

                    System.out.println("Recommendation:");
                    System.out.println(recommendation);

                    System.out.println();
                    System.out.println("==============================================");

                    break;

                // =====================================================
                // CASE 2 – Display Academic Criteria
                // =====================================================

                case 2:

                    System.out.println();
                    System.out.println("==============================================");
                    System.out.println("              ACADEMIC CRITERIA");
                    System.out.println("==============================================");

                    System.out.println();
                    System.out.println("FINAL GRADE CLASSIFICATION");
                    System.out.println("95-100 : OUTSTANDING");
                    System.out.println("90-94  : EXCELLENT");
                    System.out.println("85-89  : VERY GOOD");
                    System.out.println("80-84  : GOOD");
                    System.out.println("75-79  : PASSED");
                    System.out.println("Below 75 : FAILED");

                    System.out.println();
                    System.out.println("ATTENDANCE CLASSIFICATION");
                    System.out.println("95-100 : EXCELLENT ATTENDANCE");
                    System.out.println("90-94  : VERY GOOD ATTENDANCE");
                    System.out.println("80-89  : SATISFACTORY ATTENDANCE");
                    System.out.println("75-79  : ATTENDANCE WARNING");
                    System.out.println("Below 75 : CRITICAL ATTENDANCE WARNING");

                    System.out.println("==============================================");

                    break;

                // =====================================================
                // CASE 3 – Exit
                // =====================================================

                case 3:

                    System.out.println();
                    System.out.println("Thank you for using the system.");
                    System.out.println("Program terminated.");

                    running = false;

                    break;

                // =====================================================
                // Invalid Menu Choice
                // =====================================================

                default:

                    System.out.println();
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");

                    break;
            }
        }

        scanner.close();
    }
}