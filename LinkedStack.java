import java.util.EmptyStackException;
/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode; // References the first node in the chain
  
   public LinkedStack()
   {
      topNode = null;
   } // end default constructor
  
//  < Implementations of the stack operations go here. >
   public void push(T newEntry)
   {
      Node newNode = new Node(newEntry, topNode);
      topNode = newNode;
   }

   public T pop()
   {
      T top = peek();
      topNode = topNode.getNextNode();

      return top;
   }

   public T peek()
   {
      if (isEmpty())
      {
         throw new EmptyStackException();
      }
      else
      {
         return topNode.getData();
      }
   }

   public boolean isEmpty()
   {
      return topNode == null;
   }

   public void clear()
   {
      topNode = null;
   }

   //algo to help with operations for the postfix equation
   public static int operandSolve(char n)
   {
      switch(n)
      {
         case'(':

         return 0;

         case'/':

         case'*':
         return 2;

         case'+':

         case'-':
         return 1;

         default:
         return 4;
      }
   }

   //convert to postfix algorithm

   public static String convertToPostfix(String convert)
   {
      LinkedStack<Character> cpf = new LinkedStack<Character>();

      cpf.push('(');

      String eval = "";

      for(int i = 0; i < convert.length(); i++)
      {
         char append = convert.charAt(i);

         if (Character.isLetter(append))
         {
            eval = eval + append + "";
         }
         else if (append == '(')
         {
            cpf.push(append);
         }
         else if (append == ')')
         {
            while (cpf.peek() != '(')
            {
               eval = eval + cpf.peek() + "";
               cpf.pop();
            }
            cpf.pop();
         }
         else 
         {
            int oneOpp = operandSolve(append);
            int twoOpp = operandSolve(cpf.peek());
            while (oneOpp <= twoOpp)
            {
               eval = eval + cpf.peek() + "";
               cpf.pop();
               twoOpp = operandSolve(cpf.peek());
            }
            cpf.push(append);
         }
      }
      return eval;
   }

	private class Node
	{
      private T    data; // Entry in stack
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      } // end constructor
      
      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private void setData(T newData)
      {
         data = newData;
      } // end setData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
      private void setNextNode(Node nextNode)
      {
         next = nextNode;
      } // end setNextNode
	} // end Node
} // end LinkedStack
