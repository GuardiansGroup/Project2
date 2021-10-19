import java.util.Arrays;
import java.util.EmptyStackException;

/** A class of stacks whose entries are stored in an array. */
public final class ResizeableArrayStack<T> implements StackInterface<T>  
{
   private T[] stack;
   private int topIndex;
   private boolean integrityOK = false;
   private static final int DEFAULT_CAPACITY = 50;
   private static final int MAX_CAPACITY = 10000;

   public ResizeableArrayStack()
   {
      this(DEFAULT_CAPACITY);
   } //end default constructor

   public ResizeableArrayStack(int initialCapacity)
   {
      integrityOK = false;

      @SuppressWarnings("unchecked")
      T[] tempStack = (T[]) new Object[initialCapacity];
      stack = tempStack;
      topIndex = -1;
      integrityOK = true;
   } //end constructor

   private void ensureCapacity()
   {
      if (topIndex >= stack.length - 1)
      {
         int newLength = 2 * stack.length;
         stack = Arrays.copyOf(stack, newLength);
      }
   }

   public void push(T newEntry)
   {
      ensureCapacity();
      stack[topIndex + 1] = newEntry;
      topIndex++;
   }

   public T pop()
   {
      if (isEmpty())
      {
         throw new EmptyStackException();
      }
      else
      {
         T top = stack[topIndex];
         stack[topIndex] = null;
         topIndex--;
         return top;
      }
   } //end pop

   public T peek()
   {
      if (isEmpty())
      {
         throw new EmptyStackException();
      }
      else
      {
         return stack[topIndex];
      }
   } //end peek

   public boolean isEmpty()
   {
      return topIndex < 0;
   } //end isEmpty

   public void clear()
   {
      //Remove references to the objects in the stack,
      // but do not deallocate the array
      while (topIndex > -1)
      {
         stack[topIndex] = null;
         topIndex--;
      }
   } //end clear

   public int evaluatePostfix(String postfix)
   {
      //creating an empty stack
      ResizeableArrayStack<Integer> valueStack = new ResizeableArrayStack<Integer>();
      //going through each character in string
      for(int i = 0; i < postfix.length(); i++)
      {
         char pos = postfix.charAt(i);
         if (Character.isDigit(pos))
         {
            valueStack.push(pos - '0');
         }
         else
         {
            int operandTwo = valueStack.pop();
            int operandOne = valueStack.pop();
            //creating instances of operations to compute
            switch(pos)
            {
               case '+' : valueStack.push(operandTwo + operandOne);
               break;

               case '-' : valueStack.push(operandOne - operandTwo);
               break;

               case '*' : valueStack.push(operandTwo * operandOne);
               break;

               case '/' : valueStack.push(operandOne / operandTwo);
               break;

               case '^' : valueStack.push(operandTwo * operandTwo);
               break;
               default: valueStack.push(operandTwo); valueStack.push(operandOne);
               break;
            }
         }
      }
      //printing the value of the postfix expression
      return valueStack.peek();
   }
}
