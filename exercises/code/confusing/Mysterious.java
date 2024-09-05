package confusing;
/*
 * This exercise is meant to give you a first glance at trying to 
 * read and interpret code that lack proper variable names,
 * has a confusing structure and is tightly coupled with the
 * Confusing.java class. 
 */
public class Mysterious {
    int variable1 = 1;
    String variable2 = "1";
    String variable3 = "variable1";

    public Mysterious(int varA, String varB, String varC) {
        this.variable1 = varA;
        this.variable2 = varB;
        this.variable3 = varC;
    }

    public void doSomething() {
        int result = Integer.parseInt(variable2) + variable1;
        System.out.println("Result: " + result);
        System.out.println("variable3: " + variable3);
    }
}


