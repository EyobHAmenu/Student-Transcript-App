import java.util.ArrayList;
import java.util.Scanner;

public class TranscriptApp {
    /*
        Contains the main method ofr the Transcript application.
        case 1:
        ********** Welcome to the Transcript Application. ***********
        Enter Student ID number: 123
        Enter Student's first name: Eyob
        Enter Student's last name: Amenu
        Enter course: Java1001
        Enter credits: 4
        Enter grades: b
        Another course (y/n): n
        Another Student (y/n): n
        ******** Transcript **********
        Eyob Amenu
        Student ID 	123
         Course   Credits     Grade      Quality Points
         ------   -------     -----      --------------
        Java1001      4        B            3.0

        GPA: 3.00


        case 2:
        ********** Welcome to the Transcript Application. ***********
        Enter Student ID number: Hx63893
        Enter Student's first name: Eyob
        Enter Student's last name: Amenu
        Enter course: Java1001
        Enter credits: 6
        credits should be between 1 - 4. Enter again please.0
        credits should be between 1 - 4. Enter again please.4
        Enter grades: w
        Grade should be A, B, C, D or F. Enter again please.c
        Another course (y/n): y
        Enter course: Java1002
        Enter credits: 4
        Enter grades: d
        Another course (y/n): n
        Another Student (y/n): y
        Enter Student ID number: hx12346
        Enter Student's first name: Henok
        Enter Student's last name: Amenu
        Enter course: Bio1001
        Enter credits: 3
        Enter grades: a
        Another course (y/n): y
        Enter course: Phy204
        Enter credits: 2
        Enter grades: f
        Another course (y/n): n
        Another Student (y/n): n
        ******** Transcript **********
        Eyob Amenu
        Student ID 	Hx63893
         Course   Credits     Grade      Quality Points
         ------   -------     -----      --------------
        Java1001      4        C            2.0
        Java1002      4        D            1.0

        GPA: 1.50
        ******** Transcript **********
        Henok Amenu
        Student ID 	hx12346
         Course   Credits     Grade      Quality Points
         ------   -------     -----      --------------
        Bio1001      3        A            4.0
         Phy204      2        F            0.0

        GPA: 2.40
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
                    System.out.print("credits should be between 1 - 4. Enter again please.");
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
