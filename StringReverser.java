//This class will demonstrate how to use a stack to reverse a String.

package com.company;

import java.util.Stack;

public class StringReverser
{
    //Creating a method called reverse of return type string that has a string variable named input as the parameter.
    //The goal of the method is to iterate over the String that we want to reverse in order to get each individual char.
    //After we get each individual char we will then be able to store it in the stack.
    //Then we will be able to pop each character and they will come out in the reverse order.
    public String reverse(String input)
    {
        //We add an illegal argument exception just in case the argument we pass in our main method is null.
        //We do this using an if statement to check if input is equivalent to null.
        //If that is the case then an new illegal argument exception will be thrown.
        if (input == null)
            throw new IllegalArgumentException();
        //Creating a stack to hold each character in the string that we want to reverse.
        Stack<Character> stack = new Stack<>();

        //There are two ways to iterate over the string the first is using a traditional for loop.
        //We initialize i to 0 and as long as i is less than the length of our input parameter then we increment by 1.
        //for (int i = 0; i < input.length(); i++)
            //For each iteration we use the push method of the stack and pass it the index of the character we are
            //currently at by using the charAt() method of the string class and passing it the int i as a parameter.
            //This way we get the character at the given index and are then able to push it into the stack.
            //stack.push(input.charAt(i));

        //There is a more efficient way to perform this same iteration using a for each loop.
        //We must also keep in mind that in java we cannot use a for each loop on a string, only on an array.
        //In order to do this we must first convert that string to a character array and that will allow us to
        //use a for each loop for our iteration. This can be done using the toCharArray() method of the string class.
        //This will give us an array of characters that will allow us to use our for each loop to iterate over the array.
        for (char ch: input.toCharArray())
        {
            //Now we can use the push method and pass it a character over each iteration of the for each loop.
            //Unlike the previous solution we don't have to work with an index and our loop is cleaner.
            //We have now pushed each character into our stack and now we must pop them 1 by 1 and add them to a string.
            stack.push(ch);
        }

        //We first declare a string variable called reversed and assign it to an empty string.
        //String reversed = "";
        //We use a while loop to make sure that or stack is not empty.
        //As long as our stack is not empty we can keep popping a character at a time.
        //while (!stack.empty())
            //We then call the pop() method of the stack data structure which returns the character at the top.
            //We then append our stack.pop() to a our reversed string.
            //reversed += stack.pop();
            //This is one way to approach this problem however an issue arises.
            //The problem with this issue is that we have many string concatenations.
            //If our input was very large all our concatenations would be very costly.
            //This is due to the fact that every time this statement is run a new string object is created in memory.
            //Recall that strings are immutable in Java and cannot be modified.
            //When a string is modified a new memory is allocated and characters are copied nto that new memory space.

        //In order to solve this issue that we are having above we must use a string buffer class.
        //This class is used in  situations where there are many string manipulation operations taking place.
        StringBuffer reversed = new StringBuffer();
        while (!stack.empty())
            reversed.append(stack.pop());
        //Now we must convert this String Buffer into a string using our return statement.
        //We do this by returning the value of the reversed variable converted to a string using the .toString() method.
        return reversed.toString();

    }
}
