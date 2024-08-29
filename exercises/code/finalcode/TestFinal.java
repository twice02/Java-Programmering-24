package finalcode;

// Todo: Fix the compile time error

public class TestFinal {
    static final String firstName = "Maximilian";
    static final int grade = 67;

    public static void increaseGradeByTen(){
        TestFinal.grade = TestFinal.grade + 10;
    }

    public static void introduceByShortenedName(){
        String firstNameLong = TestFinal.firstName;
        TestFinal.firstName = "Max";
        System.out.println("Hey my name is " + firstNameLong + " but most people just say " + TestFinal.firstName + "!"); 
    }
    public static void main(String[] args) {
        increaseGradeByTen();
        introduceByShortenedName();


    
    }
}
