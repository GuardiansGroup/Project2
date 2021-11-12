public class LinkedStackedTest {
   public static void main(String[] args) 
   {
      String expression = "a*b/(c-a)+d*e";
      var linkedtest = new LinkedStack<Integer>(); 
      String output = LinkedStack.convertToPostfix(expression);
      System.out.println(output);
   }
}
