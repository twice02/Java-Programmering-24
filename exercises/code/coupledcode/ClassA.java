package coupledcode;

public class ClassA {
    int num1 = 2;
    String str1 = "3";
    boolean flag = true;

    public ClassA(int x, String y, boolean z) {
        this.num1 = x;
        this.str1 = y;
        this.flag = z;
    }

    public String doThing1() {
        if (flag) {
            return Integer.toString(num1) + str1;
        } else {
            return str1 + num1;
        }
    }

    public void doThing2() {
        System.out.println("Doing thing with: " + str1);
    }
}

