Let's take a closer look at what is going on in the code of [ArrayIndex.java](/exercises/code/Indexing/ArrayIndex.java)

### Executing the code
Executing the code will produce an error: 
```Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5 at Indexing.ArrayIndex.main(ArrayIndex.java:14)```

### Examining the error message
`Exception in thread "main"`:
*Exception*: This indicates that an exception (a type of error) has occurred during the execution of the program.
`thread "main"`: In Java, the main method is typically the entry point of the program. The thread called "main" is the one executing this method. The error occurred within this main thread.

`java.lang.ArrayIndexOutOfBoundsException` contains *java.lang* which is simply the core classes within Java (exceptions are one of these classes).  

`ArrayIndexOutOfBoundsException`: The type of exception that was thrown. Reading the error message out loud will give you a hint of what type of error this is. An Array which Index is out of bounds. Out of bounds meaning that the program wants to access an index of an array which does not exist. 

`Index 5 out of bounds for length 5`: The cause of the out of bound exception is at index number 5. for length 5 indicates that the length of the array is 5. But wait, if the code tries to access index 5 in an array of length 5, why does it complain? Remember that we start at index 0, which means that we loop over index 0,1,2,3,4,5 (6 times, despite there only being 5 elements). 

`at Indexing.ArrayIndex.main`: This tells you the location in your code where the exception occurred. Specifically, it happened in the main method of the ArrayIndex class, which is part of the Indexing package.
`(ArrayIndex.java:14)`: This provides more precise information by pointing to the exact line number in the ArrayIndex.java file where the exception was thrown. In this case, it’s line 14.

### Examining the code
` int[] numbers = {1, 2, 3, 4, 5}; `
The above line states that we are creating an array containing integer values. There is a total of 5 elements in the array. Remember that the length of an array can be printed to the terminal by typing:   
`System.out.println(numbers.length);`  
`int number = 0;` simply creates a variable of type int and assigns the value 0 to it.  
```java
for (int i = 0; i <= numbers.length; i++) {
    number = numbers[i];
}
```  
Since we have examined the error message, we have figured out that the issue seems to be within the loop. After all, that is where we are trying to access the array index, which throws us an error. If we comment out the line of code that assigns the value `numbers[i]` to `number` and instead add a print statement, the output shows us that the loop runs 6 times. Remember that the length of `numbers` is 5, so the loop will go from 0-5, while our array only has elements at indices 0-4.

Output from printing the value of i:
```
0
1
2
3
4
5
```
Looking closer at our for-loop, we see that we start by creating the variable `i` of type `int` and give it the value 0. We then say `i <= numbers.length`, which means that we run the loop as long as the value of i is less than or equal to the length of our numbers array (which is of length 5). We also have `i++` which says that for each loop, we increment the value of `i` by 1. Let's quickly just look at the way the computer thinks of this loop (in simplified terms). 
```
0 -> Check index 0 in numbers -> number = 1
1 -> Check index 1 in numbers -> number = 2 
2 -> Check index 2 in numbers -> number = 3
3 -> Check index 3 in numbers -> number = 4
4 -> Check index 4 in numbers -> number = 5
5 -> Check index 5 in numbers -> There is no such index! -> number = ... Uhoh ... Throw ArrayIndexOutOfBoundsException error
```
Well, it seems like we've found the cause for our trouble! 

### Fixing the issue
This particular error is an easy error to fix, but it's also an easy error to make! Since we write `<=` we will increment the value for `i` one step too far. Instead, we want to just use `<` which produces the output: 
```
0
1
2
3
4
```
And just to be super clear about this, here is the computers way once more: 
```
0 -> Check index 0 in numbers -> number = 1
1 -> Check index 1 in numbers -> number = 2 
2 -> Check index 2 in numbers -> number = 3
3 -> Check index 3 in numbers -> number = 4
4 -> Check index 4 in numbers -> number = 5
```

Make sure that you're always careful when writing for-loops so that you stay within your bounds (or don't get stuck in an endless loop)


### Final thoughts
This may seem daunting in the beginning, but don't worry, in most cases, it's better to do some extra reading and understand the concepts and reasons behind something as trivial as an error message. Days, weeks or months from now, you'll be looking at issues like this, scratch your head and tell yourself "Why do I get this error?!". That will hopefully be followed by you reading the error message properly, then go fix that error! 

