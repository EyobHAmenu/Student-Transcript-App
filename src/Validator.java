
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
        if(grade == 'A' || grade == 'a' || grade == 'B' || grade == 'b' || grade == 'C' || grade == 'c' ||
                grade == 'D' || grade == 'd' || grade == 'F' || grade == 'f'){
            return false;
        }
        return true;
    }

}
