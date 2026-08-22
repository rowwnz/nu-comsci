public class Problem1_Enrollment {
    public static void main(String[] args) {

        
        String studentName = "Juan Dela Cruz";
        int studentID = 202610001;
        String course = "BS Computer Science";

        
        int unitsEnrolled = 24;
        double tuitionFeePerUnit = 1850.75;
        double miscellaneousFee = 6500.00;
        double laboratoryFee = 2500.00;

        
        double scholarshipDiscount = 25.0; 

       
        double tuitionFee = unitsEnrolled * tuitionFeePerUnit;
        double GrossAmount  = tuitionFee + miscellaneousFee + laboratoryFee;
        double ScholarshipDiscount = GrossAmount * (scholarshipDiscount / 100);
        double NetTuition = GrossAmount - ScholarshipDiscount;

        int NetTuitionint =(int) NetTuition;

        int RemainingUnits = (unitsEnrolled % 5);
        
        System.out.println ("=========================================");
        System.out.println ("UNIVERSITY ENROLLMENT SYSTEM");
        System.out.println ("=========================================");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentID);
        System.out.println("Course: " + course);
        System.out.println ("=========================================");
        System.out.println("Units Enrolled: " + unitsEnrolled);
        System.out.println ("Tuition Per Unit: " + tuitionFeePerUnit);
        System.out.println ("=========================================");
        System.out.println("Tuition Fee: ₱" + tuitionFee);   
        System.out.println("Miscellaneous Fee: ₱" + miscellaneousFee);
        System.out.println("Laboratory Fee: ₱" + laboratoryFee);
        System.out.println ("=========================================");
         System.out.println ("Gross Amount: " + GrossAmount);
        System.out.println("Scholarship Discount(25%): " + ScholarshipDiscount);
        System.out.println("Amount to Pay: ₱" + NetTuition);
        System.out.println ("=========================================");
        System.out.println ("Net Tuition: " + NetTuition );
        System.out.println ("Net Tuition: " + NetTuitionint );
        System.out.println ("Remaining Units (24 % 5) : " + RemainingUnits);
    }
}