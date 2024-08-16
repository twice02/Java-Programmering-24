## Table of Contents
1. [Introduction](#introduction)
2. [Executing the code](#executing-the-code)  
3. [Examining the code](#examining-the-code)  
4. [Refactoring](#refactoring)  


### Introduction
Let's have a look at the code that is found inside of the [Confusing](/exercises/code/Confusing/) folder of this repository.
There's 2 classes, [Confusing.java](/exercises/code/Confusing/Confusing.java) and [Mysterious.java](/exercises/code/Confusing/Mysterious.java) in this folder.

### Executing the code
Just like what we did in the exercises of understanding error messages, we can start by simply executing the code to see if that provides us with anything of value. Running [Confusing.java](/exercises/code/Confusing/Confusing.java) we get the output:
```
Result: 15
variable3: Hello
```
So, what does this tell us? Well, it produces a result and prints out a variable with a short message. However, since we want to be thorough, we can’t base all our assumptions on the output alone. For example, the output 15 might look like an integer, but that doesn’t necessarily mean it is one—it could also be a string that happens to contain numeric characters. Without examining the code more closely, we don’t know for sure what data types are involved or if the printed result is logically correct.

*Note: While executing the code as a start is one technique to understand the code, it may also be misleading. It should be just one tool in your toolkit, not the only one. Always make sure you examine the code whenever possible.*

### Examining the code
Let's take a look at the code to see what we can gather from it. If we look at [Confusing.java](/exercises/code/Confusing/Confusing.java), we notice something immediately within the constructor of the class:
```java
public class Confusing {
    Mysterious mysterious;
    
    public Confusing(int varX, String varY, String varZ) {
        mysterious = new Mysterious(varX, varY, varZ);
    }
    // Some more code
}
```
`Mysterious mysterious;`, This line declares a reference variable named mysterious that will point to an instance of the Mysterious class. However, at this point, it hasn't been initialized yet (being, it hasn't happened in the code we have read thus far) because we haven’t created an instance of the Mysterious class. 

This class doesn't have a lot of code, so it may be intriguing to simply start from the top and read it through to the bottom, that's generally not best practice, as code is written in many different ways and forms depending on who wrote it, its purpose and so on.   

```java
    public static void main(String[] args) {
        Confusing confusing = new Confusing(10, "5", "Hello");
        confusing.start();
    }
```

Let's instead have a look at the `main method` of the class. First thing it does is creating a new object of the type Confusing, naming it confusing and passing it the arguments `(10, "5", "Hello");`. That tells us that there are 3 values being passed as arguments to the constructor of `Confusing`, an int and two strings. 

```java
    public Confusing(int varX, String varY, String varZ) {
        mysterious = new Mysterious(varX, varY, varZ);
    }
```
So, the arguments `(10, "5", "Hello")` are passed to the `Confusing` class constructor, which creates an object of the type `Mysterious` and passes the values that are in the argument to the constructor of that class. We now know that these arguments are passed down the chain, from the Confusing class constructor to the Mysterious class constructor, showing how data flows between these classes. 

Let's dive into [Mysterious.java](/exercises/code/Confusing/Mysterious.java) next. 
```java
public class Mysterious {
    int variable1 = 1;
    String variable2 = "1";
    String variable3 = "variable1";

    public Mysterious(int varA, String varB, String varC) {
        this.variable1 = varA;
        this.variable2 = varB;
        this.variable3 = varC;
    }
    // More code... 
}
```

Seems familiar now, doesn't it? We can see that the constructor of this class contain one int and two strings, just like the arguments we passed to the Confusing class. There are a few issues that may instantly cause extra confusion here. For starters, the variable names doesn't really describe anything about what they are used for, instead, they're just named `variable1`, `variable2` and `variable3`. Well, it's our task to figure out what they do by looking at how they are used in the code!  

Since the constructor didn't give us much more information about the output, let's revisit the Confusing class to see what else it might reveal about how the output is generated.
```java
    public static void main(String[] args) {
        Confusing confusing = new Confusing(10, "5", "Hello");
        confusing.start();
    }
```
After an object of the type Confusing (which in turn creates and maintains a reference to an object of the type Mysterious, named mysterious) has been created, it calls the `start` method.

```java
    public void start() {
        mysterious.doSomething();
    }
```

Alright, we're starting to see some sort of pattern here or at least we're hopefully getting somewhere by stepping through the code. The `start` method uses a method from the `mysterious` object, which is of the type `Mysterious`, right? So, let's look for a method called `doSomething();` inside [Mysterious.java](/exercises/code/Confusing/Mysterious.java). 

```java
    public void doSomething() {
        int result = Integer.parseInt(variable2) + variable1;
        System.out.println("Result: " + result);
        System.out.println("variable3: " + variable3);
    }
```
Let's quickly break this down. The `line int result = Integer.parseInt(variable2) + variable1;` parses the string stored in `variable2` to read it as an integer using `Integer.parseInt()`. This parsed integer is then added to `variable1`, which is already an integer, hence there is no need for parsing it. The result of this addition is stored in the variable `result`.  

`System.out.println("Result: " + result);` prints the value of result to a new line. Does this seem familiar? Good! Remember the constructor of the Mysterious that hold `variable1` and `variable2`? Sounds like they are actually used to perform simple arithmetic between a number written as a String and an integer. Write that down!

We can perform a simple test to see if changing the values passed to the Confusing constructor will also change the output as we would expect. By changing the arguments passed to the Confusing constructor, we confirm that these values directly influence the output. Specifically, variable1 and variable2 are involved in the arithmetic operation, while variable3 is printed directly as a string is what we currently believe will happen. So we try it out by changing the arguments: `Confusing confusing = new Confusing(10, "4", "Hello");`. This results in the following output:
```
Result: 14
variable3: Hello
```
Changing the string value back and the int value to 8 as such `Confusing confusing = new Confusing(8, "5", "Hello");` will produce the output: 
```
Result: 13
variable3: Hello
```
It seems like we found out what this method does. At least the first part of it! What is called `variable3` is printed directly without any further alterations, but let's test changing it just to make sure. We now have  `Confusing confusing = new Confusing(10, "5", "Good Bye!");`, executing the code results in: 
```
Result: 15
variable3: Good Bye!
```

So, this means that we've found out what the methods do. That means we now just memorize that and proceed with our day, right? Now that wouldn't be fair to ourselves or the next person that needs to go through the same steps as we just did to figure this mystery code out. 

### Refactoring
At this point, we have figured the functionality out and understand what the code does. Let's refactor the code so that others can read and understand the code more easily. 

We'll start with [Confusing.java](/exercises/code/Confusing/Confusing.java) which we can give a more telling name. Since we know it implements a method that performs a calculation, it is a form of calculator, there is a possibility that there will be other functionality implemented at some later stage. Naming this class `Calculator` seems reasonable. Below is an example of the refactored code:  

```java
package CalculatorApp;

public class Calculator {
    Addition addition;

    public Calculator(int num1, String num2, String message) {
        addition = new Addition(num1, num2, message);
    }

    public void start() {
        addition.calculate();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(10, "5", "Hello");
        calculator.start();
    }
}
```

*Note: I didn't change the second argument to an integer in this example, simply due to the fact that such a change would also change functionality.*  

Notice how we now have Mysterious instead being called addition. Basically, that is what the Mysterious class was doing, performing addition. 

This is an example of a refactored version of [Mysterious.java](/exercises/code/Confusing/Mysterious.java): 
```java
package CalculatorApp;

public class Addition {
    int number1;
    String number2;
    String message;

    public Addition(int num1, String num2, String message) {
        this.number1 = num1;
        this.number2 = num2;
        this.message = message;
    }

    public void calculate() {
        int result = Integer.parseInt(number2) + number1;
        System.out.println("Result: " + result);
        System.out.println(message);
    }
}
```

