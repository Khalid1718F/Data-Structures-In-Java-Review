/*
In the class below we will demo how to check for balanced delimiters in a string.
The delimiters are the braces { and }, brackets [ and ], and parentheses ( and ), and angle brackets < and >.
Each opening or left delimiter should be matched by a closing or right delimiter;
that is, every { should be followed by a matching } and so on.
Also, opening delimiters that occur later in the string should be closed before those occurring earlier.
Here are some examples:
c[d]        //Correct
a{b[c]d}e   //Correct
a{b(c]d}e   //Incorrect because ] does not match (
a[b{c}d]e}  //Incorrect because there is nothing that matches the final }
a{b(c)      //Incorrect because there is nothing that matches the opening brace.
---------------------------------------------------------------------------------------------------------------
There is a general algorithm that we follow when it comes to bracket matching:
1- Read each character from the string one at a time.
2- If the character is an opening delimiter then place it on the stack.
3- If it is a closing delimiter then pop it out of the stack.
4- If the stack is empty then there is an error.
5- If the delimiters match then continue the process.
6- If the delimiter does not match then the result will yield an error.
7- If the end is reached and the stack is not empty then there is an error.
 */

package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedStack
{
    //Here we declare an Array list of characters to help us store the left/open brackets & the right/closing brackets.
    //We cannot pass a list of left or right brackets to the constructor of Array lists but we have another class which
    //allows us to do so. We have a class called Arrays declared in the java.util package. This class has a very useful
    //method called asList(). This method allows us to pass a variety of different arguments inside of it. We declare
    //this method as a private field and initialize it once so that it does not have to consume memory if it were called
    //inside any of our isLeftBracket() and  isRightBracket() methods. This would waste too much memory. This list of
    //Arrays is assigned to the list of characters object called leftBrackets and is declared using the final keyword.
    private final List<Character> leftBrackets
            = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets
            = Arrays.asList(')', '>', ']', '}');

    //Here we create a public method that adds a boolean value and takes a String parameter called input.
    public boolean isBalanced(String input)
    {
        //Here we create a stack object that has character data type as a wrapper'.
        //We create this stack object in order to store our left/opening brackets.
        Stack<Character> stack = new Stack<>();

        //Here we are using a for each loop to iterate over our character array.
        //So for each character in our input array we enter the body of our for loop.
        //When we enter the body of our for loop we check if our character is our left bracket.
        for (char ch : input.toCharArray())
        {
            //In this line we call the is leftBracket method and pass it our current char variable as an argument.
            //If the current character is a left/open brace then the we will push it into the top of our stack.
            //This is done by calling our stack object and accessing the push method to pass ch as an argument.
            if (isLeftBracket(ch))
                stack.push(ch);

            //In this line we call the rightBracket method and pass it our current char variable as an argument.
            //If current character turns out to be a right/closing brace then we will enter into the body of the if.
            if (isRightBracket(ch))
            {
                //We then check to see if our stack is empty after seeing if we entered the
                if (stack.empty()) return false;

                //We create a variable called top and assign it the value of the item we popped to the top of the stack.
                //We do this in order to compare it with our current character to make sure these pairs match.
                var top = stack.pop();

                //In this line we call the bracketsMatch method to check if our top item matches our current character.
                //If the top item that we popped doesnt match our current item then it will return false.
                if (!bracketsMatch(top, ch)) return false;
            }
        }

        return stack.empty();
    }

    //This is a private method that returns a boolean value and is being passed a char as a parameter.
    //We declare this method as private because it is going to be an implementation detail. We dont want other classes
    //in our program to access this method. Its only to be used internally inside the BalancedStack class.
    //The purpose of this method is to see if this character is an opening or left bracket.
    private boolean isLeftBracket(char ch)
    {
        //Then we return a boolean value to see if our character contains a left/opening brace.
        return leftBrackets.contains(ch);
    }
    //This is a private method that returns a boolean value and is being passed a char as a parameter.
    //We declare this method as private because it is going to be an implementation detail. We dont want other classes
    //in our program to access this method. Its only to be used internally inside the BalancedStack class.
    //The purpose of this method is to see if this character is an closing or right bracket.
    private boolean isRightBracket(char ch)
    {
        //Then we return the a boolean value to see if our character contains a right/closing brace.
        return rightBrackets.contains(ch);
    }

    //Here we have another private method that returns a boolean value and takes in two char parameters.
    //These parameter names identify the corresponding left and right characters that we are evaluating.
    //This method will check if the left and right characters match one another.
    //In other words is the left/open equivalent to the right/close brace.
    private boolean bracketsMatch(char left, char right)
    {
        //We go to our leftBrackets array and find the index of this left character.
        //We do the same for the rightBrackets array and find the index of the right character.
        //Finally we compare both oof these indexes and get a return value of true or false.
        //If the indexes are equal then that means that these brackets match.
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}