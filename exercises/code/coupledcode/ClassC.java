package coupledcode;
public class ClassC {
    ClassB classB;
    int counter = 0;

    public ClassC(int d, String e, boolean f) {
        classB = new ClassB(d, e, f);
        counter++;
    }

    public void doStuff() {
        classB.method1();
        classB.method2();
        System.out.println("Counter in the class: " + counter);
    }

    public static void main(String[] args) {
        ClassC classC = new ClassC(5, "Hello", false);
        classC.doStuff();
    }
}

