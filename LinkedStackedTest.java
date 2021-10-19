public class LinkedStackedTest {
    public static void main(String[] args) {
        var linkedtest = new LinkedStack<Integer>(); 
        String expression = "a*b/(c-a)+d*e"; 
        int convertToPostfix = linkedtest.convertToPostfix(expression);  
        System.out.println(convertToPostfix); 
    }
}