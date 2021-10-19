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
Algorithm convertToPostfix(infix)
// Converts an infix expression to an equivalent postfix expression.
operatorStack = a new empty stack
postfix = a new empty string
    while (infix has characters left to parse)
        {
    nextCharacter = next nonblank character of infix
    switch (nextCharacter)
        {
    case variable:
    Append nextCharacter to postfix
        break
    case '^' :
    operatorStack.push(nextCharacter)
        break
    case '+' : case '-' : case '*' : case '/' :
        while (!operatorStack.isEmpty() and
        precedence of nextCharacter <= precedence of operatorStack.peek())
    {
    Append operatorStack.peek() to postfix
    operatorStack.pop()
    }
    operatorStack.push(nextCharacter)
        break
    case '( ' :
        operatorStack.push(nextCharacter)
    break
    case ')' : // Stack is not empty if infix expression is valid
        topOperator = operatorStack.pop()
        while (topOperator != '(')
    {
    Append topOperator to postfix
    topOperator = operatorStack.pop()
    }
        break
    default: break // Ignore unexpected characters
    }
}
    while (!operatorStack.isEmpty())
        {
    topOperator = operatorStack.pop()
    Append topOperator to postfix
}
return postfix

//  . . .

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
//  . . .

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