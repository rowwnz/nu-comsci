public class Main {
    public static void main(String[] args) {

        String studentName = "Maria Santos";
        int midtermGrade = 91;
        int finalGrade = 88;
        int conductRating = 95;
        double familyIncome = 28000;
        boolean requirementsComplete = true;
        boolean noDisciplinaryCase = true;

        int totalGrade = midtermGrade + finalGrade;
        int difference = midtermGrade - finalGrade;
        double average = (midtermGrade + finalGrade) / 2.0;

        boolean averageCheck = average >= 90;
        boolean conductCheck = conductRating >= 90;
        boolean incomeCheck = familyIncome <= 30000;

        boolean scholarshipQualified = averageCheck &&
                                       conductCheck &&
                                       incomeCheck &&
                                       requirementsComplete &&
                                       noDisciplinaryCase;

        int averageInt = (int) average;

        System.out.println("=========================================");
        System.out.println("   STUDENT SCHOLARSHIP EVALUATION");
        System.out.println("=========================================");
        System.out.println();

        System.out.println("Student Name            : " + studentName);
        System.out.println();

        System.out.println("Midterm Grade           : " + midtermGrade);
        System.out.println("Final Grade             : " + finalGrade);
        System.out.println();

        System.out.println("Total Grade             : " + totalGrade);
        System.out.println("Difference              : " + difference);
        System.out.println();

        System.out.println("Average                 : " + average);
        System.out.println("Average (int)           : " + averageInt);
        System.out.println();

        System.out.println("Conduct Rating          : " + conductRating);
        System.out.println("Family Income           : ₱" + familyIncome);
        System.out.println();

        System.out.println("Requirements Complete   : " + requirementsComplete);
        System.out.println("No Disciplinary Case    : " + noDisciplinaryCase);
        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println("Average >= 90           : " + averageCheck);
        System.out.println("Conduct >= 90           : " + conductCheck);
        System.out.println("Income <= 30000         : " + incomeCheck);
        System.out.println("-----------------------------------------");
        System.out.println();

        System.out.println("Scholarship Qualified   : " + scholarshipQualified);
        System.out.println();

        System.out.println("Reason:");

        if (!averageCheck) {
            System.out.println("Average grade did not meet the required 90%.");
        } else if (!conductCheck) {
            System.out.println("Conduct rating did not meet the required 90%.");
        } else if (!incomeCheck) {
            System.out.println("Family income exceeds ₱30,000.");
        } else if (!requirementsComplete) {
            System.out.println("Requirements are incomplete.");
        } else if (!noDisciplinaryCase) {
            System.out.println("Student has a disciplinary case.");
        } else {
            System.out.println("Student meets all scholarship requirements.");
        }

        System.out.println();
        System.out.println("=========================================");
    }
}