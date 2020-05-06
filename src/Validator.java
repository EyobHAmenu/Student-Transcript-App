
public class Validator extends Transcript{
    /*
        Provides methods that accept and validate user input
     */

    public boolean validateCredit(double credit){
        if(credit > 4 || credit <= 0){
            return true;
        }
        return false;
    }

    public boolean validateGrade(char grade){
        grade = Character.toUpperCase(grade);
        if(grade == 'A' || grade == 'B' ||  grade == 'C' || grade == 'D' || grade == 'F' ){
            return false;
        }
        return true;
    }

}
