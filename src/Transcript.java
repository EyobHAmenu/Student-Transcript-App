import java.util.ArrayList;

public class Transcript {
    /*
        Represents a single student's transcript. The course enrollments are represented by an array list.
        Methods:
            void addCourse(CourseEnrollment course)
            ArrayList getCourses()
            double getOverallGPA()
            String getFormattedGPA()
     */
    private ArrayList<CourseEnrollment> courses = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String studentID;

    public Transcript(){ }
    public Transcript(String firstName, String lastName, String studentID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }


    public void addCourse(CourseEnrollment course){
        courses.add(course);
    }

    public ArrayList getArrayLists(){
        return courses;
    }
    public double getOverallGPA(){
        double gpa;
        double totalGrade = 0;
        double totalCredits = 0;
        for(CourseEnrollment cour : courses){
        totalGrade += (cour.getCredits() *cour.getCoursePoint());
        totalCredits += cour.getCredits();
        }
        gpa = totalGrade / totalCredits;
        return gpa;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String studentName) { this.firstName = studentName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }


    public String getFormattedGPA(){
        String output = "";
        System.out.println(getFirstName() + " " + getLastName());
        System.out.println("Student ID \t" + getStudentID());
        System.out.printf("%7s%10s%10s%20s","Course", "Credits", "Grade", "Quality Points");
        System.out.println();
        System.out.printf("%7s%10s%10s%20s","------", "-------", "-----", "--------------");
        System.out.println();
        for (CourseEnrollment course : courses){
            System.out.printf("%7s%7.0f%9c%15.1f", course.getCourse(), course.getCredits(), course.getGrades(), course.getCoursePoint());
            System.out.println();
        }
        System.out.println();
        System.out.printf("GPA: %.2f",getOverallGPA());
        System.out.println();
        return output;
    }
}
