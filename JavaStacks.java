/*
The Java collection framework provides a Stack class which models and implements the Stack Data Structure.
This class is based on the elementary principal of LIFO (Last-in-First-Out).
This means that the element which is inserted first in the stack, will be deleted last from the stack.
Think of a can of pringle chips. The first chip to go in the can will be the last one out of it.
Stack is an ordered list in which, insertion and deletion can be performed only at one end that is called top.
Stack is a recursive data structure having pointer to its top element.
Stacks can be applied in recursion, parsing, browsers, editors, tree traversals, expression evaluation and conversion.
The class supports one default constructor Stack() which is used to create an empty stack.
The stack class provides 5 basic methods which are as follows:
1) Object push(Object element) : Pushes an element on the top of the stack.
2) Object pop() : Removes and returns the top element of the stack.
An ‘EmptyStackException’ exception is thrown if we call pop() when the invoking stack is empty.
3) Object peek() : Returns the element on the top of the stack, but does not remove it.
4) boolean empty() : It returns true if nothing is on the top of the stack. Else, returns false.
5) int search(Object element) : It determines whether an object exists in the stack.
If the element is found, it returns the position of the element from the top of the stack. Else, it returns -1.
 */

package com.company;

public class JavaStacks {

    public static void main(String[] args) {
        // Creating a string object that needs to be reversed.
        String str = "ABCDEFG";
        // Creating a string object that needs to check and see if its balanced.
        String myStr = "{1[2)3}";
        // Creating an object from the String reverser class to access the reverse
        // method for our string.
        StringReverser reverser = new StringReverser();
        // Creating a variable named result and assigning it to the reverser object.
        // This accesses the reverse method and is passed the str string object as an
        // argument.
        // The value is stored in our result variable and is then displayed on the
        // console.
        var result = reverser.reverse(str);
        System.out.println(result);

        // Here we create an object from the BalancedStack class call exp
        BalancedStack exp = new BalancedStack();
        // We use the object to access the isBalanced() method and pass the string
        // object myStr as an argument.
        // We store the result which is a boolean into a variable called myResult and
        // display the result on the console.
        var myResult = exp.isBalanced(myStr);
        System.out.println(myResult);

        // Creating an object from the Stack array class to access methods and fields of
        // that class.
        StackArray stack = new StackArray();
        // Now we push items into our stack.
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        // Now we display the results of our stack array.
        System.out.println(stack);
        // Now we display the result of our peek() method.
        System.out.println(stack.peek());
        // Now we pop items from our stack.
        stack.pop();
        // Now we see the result of our stack array after popping an item.
        System.out.println(stack);
        // Now we check our isEmpty() method.
        System.out.println(stack.isEmpty());
    }
}
