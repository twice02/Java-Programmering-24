package StringComparing;
/* 
* Explain why the results are different when calling 
* isGreetingsHello with "the same" string. 
 */

 public class StringComparison {

    public static void isGreetingsHello(String greeting) {
        if (greeting == "Hello") {
            System.out.println("Greeting is Hello");
        } else {
            System.out.println("Greeting is not Hello");
        }

    }
    public static void main(String[] args) {
        String greeting = "Hello";
        String greetings = new String("Hello");

        isGreetingsHello(greeting);
        isGreetingsHello(greetings);
    }
}
