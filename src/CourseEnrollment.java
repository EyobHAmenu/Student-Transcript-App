
public class CourseEnrollment {
    /*
        Represents a course enrollment, which includes a course code, credits, and grade
     */
    private String course;
    private double credits;
    private char grades;
    private double coursePoint;


    public CourseEnrollment(){ }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public double getCredits() { return credits; }
    public void setCredits(double credits) { this.credits = credits; }

    public char getGrades() { return grades; }
    public void setGrades(char grades) { this.grades = grades; }

    public double getCoursePoint() { return coursePoint; }
    public void setCoursePoint(char grades) {
        if(grades=='A' || grades=='a'){
            this.coursePoint = 4;
        }else if(grades=='B' || grades=='b'){
            this.coursePoint = 3;
        }else if(grades=='C' || grades=='c'){
            this.coursePoint = 2;
        }else if(grades=='D' || grades=='d'){
            this.coursePoint = 1;
        }else{
            this.coursePoint = 0;
        }
    }

    public String toString(){
        String courses;
        courses = getCourse() + "\t" + getCredits() + "\t" + getGrades() + "\t" + getCoursePoint();
        return courses;
    }
}
