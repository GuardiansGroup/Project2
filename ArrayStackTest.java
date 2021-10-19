public class ArrayStackTest 
{
   public static void main(String[] args)
   {
      var stacktest = new ResizeableArrayStack<Integer>();
      String form = "23*42-/56*+";
      int evaluatePostfix = stacktest.evaluatePostfix(form);
      // print the value of the postfix expression
      System.out.println(evaluatePostfix);
   }   
}
