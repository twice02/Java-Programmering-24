package coupledcode;

public class ClassB {
    ClassA classA;
    String str2 = "ClassB";

    public ClassB(int a, String b, boolean c) {
        classA = new ClassA(a, b, c);
    }

    public void method1() {
        String result = classA.doThing1();
        System.out.println("Result from the Class: " + result);
    }

    public void method2() {
        classA.doThing2();
        System.out.println("Class method executed with " + str2);
    }
}

