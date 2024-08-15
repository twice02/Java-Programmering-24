package SumThingsWrong;

public class DoubleTrouble {
    public static void main(String[] args){
  
        double a = 1 / 2;
        System.out.println("1 / 2 = "+ a);

        int b = 7;
        int c = 2;

        double sum2 = b / c;
        System.out.println("7 / 2 = " + sum2);

        double sum3 = 7 / 2;
        System.out.println("7 / 2 = "+sum3);

        double sum4 = 7.0 / 2.0;
        System.out.println("7.0 / 2.0 = " + sum4);

        int sum5 = 7 / 2;
        System.out.println("7 / 2 = " + sum5);

        double a1 = 0.1;
        double a2 = 0.2;
        Boolean a3 = false;

        double sum = a1 + a2;
        if (sum == 0.3){
            a3 = true;
        }
        System.out.println("Should be true, is: " + a3);
    }
    
}