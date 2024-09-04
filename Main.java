import java.util.Scanner;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        System.out.print("Enter an integer value for n: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();
        }
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            // Step 1: Add 1 to the current value of i
            int step1Value = i + 1;

            // Step 2: Multiply the value from step 1 by -3
            int step2Value = step1Value * -3;

            // Step 3: Subtract the value from step 1 by 2, then multiply by 2
            int step3Value = (step1Value - 2) * 2;

            // Step 4: Add a random number between -n and +n to the total
            int randomValue = random.nextInt(-n, n);
            int total = step3Value + step2Value + randomValue;

            // Output the steps and total for the iteration
            System.out.println("Iteration " + i + ": Step 1 value = " + step1Value + 
                               ", Step 2 value = " + step2Value + 
                               ", Step 3 value = " + step3Value + 
                               ", Random Value = " + randomValue + 
                               ", Total = " + total);
        }

        scanner.close();
    }
}
