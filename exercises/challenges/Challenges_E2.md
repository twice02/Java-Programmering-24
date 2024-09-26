# Challenging Exercises Lecture 2 
> This file contain **challenging exercises** that test knowledge on the following topics:
> * Code blocks
> * If/Else & elseif
> * Switch cases
> * For, while and do-while loops
> * Branching statements  

> It's not meant to be standard, quickly solvable exercises, may introduce new topics and invite you to expand beyond what is explicity mentioned during lectures. 

## C2.1 - Nested loops  

> Questions:   
`a. Why should nested loops generally be avoided?`  
`b. Give an example of when a nested loop is necessary to use, why?`  

> Code  
>a. `Implement a nested loop structure that simulates a multiplication table from 1 to 10.`  
>b. `Write a nested loop to generate the following pyramid pattern (up to 5 rows):`  
>```
>        1  
>      1 2 1  
>    1 2 3 2 1  
>  1 2 3 4 3 2 1  
> 1 2 3 4 5 4 3 2 1  
> ```
>c. > **This one is a tough challenge, proceed at your own demise, you have been warned.**   
`Print a` [Triforce](https://en.wikipedia.org/wiki/Triforce) `to the terminal using loops.`   
>Example output of a decent Triforce:
> ```
>          1     
>         111
>        11111
>       1111111
>      111111111
>     1         1
>    111       111
>   11111     11111
>  1111111   1111111
> 111111111 111111111
>```

___ 
## 2.2 - Switch-cases 

a. `Complete the "To do" in the following code:`
>```java
>import java.util.Scanner;
>
>public class MenuSelection {
>    public static void main(String[] args) {
>        Scanner scanner = new Scanner(System.in);
>        
>        System.out.println("Choose an option:");
>        System.out.println("1. Start");
>        System.out.println("2. Settings");
>        System.out.println("3. Exit");
>        
>        int choice = scanner.nextInt();
>        
>        switch (choice) {
>           // To do: Implement a switch case which displays a message depending on user input
>        }
>        
>        scanner.close();
>    }
>}
> // For clarity, this comment is here to show that the MenuSelection code ends here. 
>```
b. `Convert the following if/else-statement to a switch case and ensure that the program works correctly with `char` input. Also make sure that the student enters the grade that it actually have received:`
>```java
> import java.util.Scanner;
>
>public class GradingSystem {
>    public static void main(String[] args) {
>        Scanner scanner = new Scanner(System.in);
>        char actualGrade = 'C';
>
>        System.out.print("Enter your grade (A, B, C, D, or F): ");
>        char grade = scanner.next().charAt(0);
>
>        // Task 1: Check if grade actually matches the input.
>        // Task: Convert the if/else into a switch case structure.
>        if (grade == 'A') {
>            System.out.println("Excellent! You scored above 90.");
>        } else if (grade == 'B') {
>            System.out.println("Well done! You scored between 80 and 90.");
>        } else if (grade == 'C') {
>            System.out.println("Good effort! You scored between 70 and 80.");
>        } else if (grade == 'D') {
>            System.out.println("You passed, but consider improving. You scored between 60 and 70.");
>        } else if (grade == 'F') {
>            System.out.println("Unfortunately, you failed. You scored below 60.");
>        } else {
>            System.out.println("Invalid grade input.");
>        }
>
>        scanner.close();
>    }
>}
> // End of code
c. `Your task is to build a program based on the users specifications and description below. This assignment may take a bit of extra effort.`

>A customer has hired you to build a function as part of a larger e-commerce software system!
>
>Your function is responsible for calculating prices based on product categories and applying discounts.
>
>The system must allow users to input a product category and quantity, and based on the category, the price should be calculated with different discounts. The system should keep asking for new products until the user decides to exit.  
>
>**Product categories and discounts**: 
>1. **Electronics**:  
    - *Base price*: $100/item  
    - *Discount*: 10% if quantity > 5
>
>2. **Furniture**:  
    - *Base price**: $500/item  
    - *Discount*: 10% if quantity > 3
>
>3. **Groceries**:  
    - *Base price*: $20/item  
    - *Discount*: 5% if quantity > 10  
>
>4. **Others**:  
    - No discounts, base price determined by user input.  
>
>**Other customer demands**:
>Use a `switch case` to handle the product categories and a `do-while loop` to allow multiple transactions.
___

## 2.3 - Branching statements
a.
>Write a program that iterates through numbers 1 to 100 and checks if a number is divisible by both 3 and 7. Once it finds such a number, the program should print the number and immediately stop the loop using the **break** statement.

b. 
>Write a program that iterates through numbers 1 to 50. If the number is divisible by 5 or 3, the program should skip the number and **continue** to the next iteration using the continue statement. Print all the numbers that are not divisible by 5 or by 3.

c. 
>It's time to put your understanding of break, continue and loops to the test!  
>For this, I will provide you with some incomplete code that contains a nested loop and a description of the product that is to be build. 

>**Scenario:** A customer is running a warehouse and has ordered an inventory management system from your company `Where House Inc.`. The owner of the warehouse has noticed two main issues with her warehouse production line:
>
>The first issue is that she supplies an uneven number of screws to a large furniture company, which have garnered complaints from the furniture company's economics department. She needs a system that marks orders with an uneven number of items. She specifically requested that whenever an uneven amount of screws are detected, there should be a message printed: "Batch with {batch number} has an odd number of items, marking for manual inspection."    
>
>The second issue is that some of her warehouse machines are getting old. This leads to them sometimes placing too many screws within a batch (weirdly enough, this hasn't lead to any complaints from the furniture company's economics department) which has started to become noticable in her balance sheet. This is such a crucial issue that once a bag of screws that contain more than 100 screws have been found, the entire product line for that particular product line needs to be halted and investigated. It should print out a message that looks something like this example: "Critical Error for Product 40, Batch 6. It has too many items (104). Possible counting error! Halting production line for further investigation."
>
> Luckily for you, the customer had previously hired a programmer that started working on the product. Unfortunately for the customer, the other programmer decided to go on a vacation in the Bermuda Triangle. However, they left some boilerplate code that the warehouse owner wants you to use as the base of your program, which can be seen below. The customer has also complained about some weird messages in the product when she copy+pasted it for you to work on, make sure to clean up the code comments. 
>
> For this product to be successful, it has the following requirements (**some** of which may have been mentioned in the above text):
> * Skip over batches with an odd number of items, they need manual inspection
> * If number of items in a batch exceeds 100, halt product checks due to potential error
> * Extra challenge: Print all products that are ready for shipment (items marked for manual inspection is OK)  

>The code:
>```java
>import java.util.Scanner;
>
>public class WarehouseInventory {
>    public static void main(String[] args) {
>        // You don't need to care about these variables for now
>       
>        Scanner scanner = new Scanner(System.in);
>       // Note to self, this lady doesn't seem to like paying programmers
>       // To do: Sue her so I can extend my vacation
>        int maxItems = 110;
>        int minItems = 15;
>        int maxBatch = 10;
>        int minBatch = 3;
>
>        // Play around with different amounts of products to check
>        System.out.print("Enter the number of products to check: ");
>        int numProducts = scanner.nextInt();
>
>        // Loop through each product
>        for (int product = 1; product <= numProducts; product++) {
>            System.out.println("\nChecking product " + product);
>
>            // Sets the number of matches between minBatch and maxBatch
>            int numBatches = minBatch + (int) (Math.random() * ((maxBatch - minBatch) + 1));
>            System.out.println("This product has a total of " + numBatches + " batches.");
>
>            // Loop through each batch for the current product
>            for (int batch = 1; batch <= numBatches; batch++) {
>                // Just anouther 120 hours and I will be in the Beeeermuuuuudaaa Triaaangllleee   
>                int numItems = minItems + (int) (Math.random() * ((maxItems - minItems) + 1));
>
>                // To do: Skip batches with an odd number of items, they need manual inspection
>                // Use branch statements to stop the current iteration of this loop.
>
>                // To do: If number of items exceeds 100, halt checks due to potential error
>                // This should halt any further inspections of this product. 
>
>                // Otherwise, print the number of items in the batch
>                ;
>            }
>        }
>       // I can't wait to go on my vacation in the Bermuda Triangle 
>        System.out.println("Warehouse inventory check complete.");
>        System.out.println("Now can you please pay your programmer?!");
>        // Extra challenge: Print all products that are ready for shipment (items marked for manual inspection is OK)
>        // Should probably close the Scanner, I'll do it when I get paid, lol. 
>    }
>}

