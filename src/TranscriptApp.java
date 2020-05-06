import java.util.ArrayList;
import java.util.Scanner;

public class TranscriptApp {
    /*
        Contains the main method ofr the Transcript application.
     */
    public static void main(String[] args) {

        String firstName;
        String lastName;
        String studentID;
        String stop1 = "y";
        String stop2;


        Validator validatetCourseList = new Validator();
        ArrayList<Transcript> transcriptList = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        System.out.println("********** Welcome to the Transcript Application. ***********");
        while(stop1.equalsIgnoreCase("y")) {
            stop2 = "y";
            System.out.print("Enter Student ID number: ");
            studentID = in.nextLine();
            System.out.print("Enter Student's first name: ");
            firstName = in.nextLine();
            System.out.print("Enter Student's last name: ");
            lastName = in.nextLine();

            Transcript transcript = new Transcript(firstName, lastName, studentID);
            transcriptList.add(transcript);

            while (stop2.equalsIgnoreCase("y")){
                CourseEnrollment courseEnrollment = new CourseEnrollment();
                System.out.print("Enter course: ");
                courseEnrollment.setCourse(in.nextLine());

                System.out.print("Enter credits: ");
                double credit = in.nextDouble();
                while (validatetCourseList.validateCredit(credit)){
                    System.out.print("credits should be between 1-4. Enter again please.");
                    credit = in.nextDouble();
                }
                courseEnrollment.setCredits(credit);
                in.nextLine();

                System.out.print("Enter grades: ");
                char grade = in.next().charAt(0);
                in.nextLine();
                while (validatetCourseList.validateGrade(grade)){
                    System.out.print("Grade should be A, B, C, D or F. Enter again please.");
                    grade = in.next().charAt(0);
                    in.nextLine();
                }

                courseEnrollment.setGrades(grade);


                courseEnrollment.setCoursePoint(courseEnrollment.getGrades());

                transcript.addCourse(courseEnrollment);

                System.out.print("Another course (y/n): ");
                stop2 = in.nextLine();
            }

            System.out.print("Another Student (y/n): ");
            stop1 = in.nextLine();
        }

        for(Transcript stud : transcriptList) {
            System.out.println("******** Transcript **********" );
            stud.getFormattedGPA();
        }
    }
}
