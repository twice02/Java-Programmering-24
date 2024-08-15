package Indexing;
/* 
 * Running this code will produce an error.
 * Your task is to identify the issue,
 * understand why it happens and fix it.
 */

public class ArrayIndex {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int number = 0;

        for (int i = 0; i <= numbers.length; i++) {
            number = numbers[i];
        }
    }
}