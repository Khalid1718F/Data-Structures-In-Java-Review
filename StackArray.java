/*
This program shows how to implement a stack by using an array
The requirements of implementing a stack using an array are the following:
1) The stack has a constructor which accepts a number to initialize its size.
2) The stack can hold any type of elements.
3) The stack has a push(), pop(), peek(), and isEmpty() methods.
4) The stack will be using a regular integer array (int[]) and not an Arraylist,
   This is to be able to handle the scenario where  the stack gets full.
----------------------------------------------------------------------------------------------------------------
Here is the Algorithm for our program:
Suppose we have an array of 5 elements that will initially look like this: [0, 0, 0, 0, 0]
Now suppose we call our push method and pass 10 as an argument: push(10)
Now the value 10 that was pushed should be stored in the first index position of our array: [10, 0, 0, 0, 0]
If we push 20 using the same push() method it would be stored in the next index position: [10, 20, 0, 0, 0]
The steps above can be done by declaring a count variable and setting it to 0: count = 0;
When we call push(10); we will set array of count to 10: array[count] = 10;
We use the count variable to determine the index of the count item that we will set.
This will allow 10 to be set in the first index position as stated above: [10, 0, 0, 0, 0]
Then we will increment our count variable by one to go to the next index position.
When we call push(20) we will set array of count to 20: array[count] = 20;
This will allow 20 to be set as in second index position as stated above: [10, 20, 0, 0, 0]
Again, we increment our count variable byy one to go to the next index position.
In order to pop items from our array we decrement our count variable by 1 and it will remove that item from our stack.
The count variable is used to determine where the end of our stack is like a pointer as we push or pop items.
 */

package com.company;

import java.util.Arrays;

public class StackArray
{
    //Here we declare a private field/attribute of integer arrays called items.
    //We initialize this array of integers to have a length of 5 in the index.
    private int[] items = new int[5];
    //We declare another private field of type int called count to use as our reference variable or pointer.
    private int count;


    //Here we declare our push method and pass it an integer variable named item as a parameter.
    public void  push(int item)
    {
        //If our stack is full and we try to push an item we must use the an if statement.
        //If the number of items is equal to the length of the array then we throw an exception.
        //This StackOverflowError indicates that our stack is full.
        //Here count will denote the number of items that we have.
        if(count == items.length)
            throw new StackOverflowError();

        //Now we set items of count to this new item parameter and increment count by 1.
        //There are two ways to achieve this:
        //      1- items[count] = item;
        //      2- count++;
        //Or we can simply increment count inside the index and take out the 2nd line like so:
        items[count++] = item;
    }

    //Now we implement the pop method in order to remove items from our array Stack.
    //This is pubic method with a return type of int and takes in no parameters.
    //We use this method to return the item on top of the stack.
    public int pop()
    {
        //If our stack is empty and we try to pop an item we must use the an if statement.
        //If the number of items is equal to 0 then we throw an exception.
        //This IllegalStateException exception indicates that our stack is empty.
        //Here count will denote the number of items that we have.
        if(count == 0)
            throw new IllegalStateException();

        //In order to accomplish this we decrement our count variable by 1 and return its index post decrementing.
        //This can be done in two ways:
        //      1- count--;
        //      2- return items[count];
        //Or we can decrement  count inside the index by putting the -- before count like so:
        return items[--count];
    }

    //In order to endure that our implementation is correct we must override the toString() method of this class.
    //Overriding means changing the implementation of a method that we inherit from a base class.
    //In java all classes directly or indirectly inherit from the object class.
    //From example this StackArray class's parent or base class is the Object class.
    //The object class has a toString() method that is inherited in the StackArray class.
    //Here we can change that implementation and return the content of our stack.
    //We do this by creating a toString class that has a String return type and takes in no parameters.
    //We also annotate this method withe override annotation.
    //This tells the java compiler that you are overriding a method inherited from the base class.
    @Override
    public String toString()
    {
        //We will copy the content of our stack into a separate array and then convert that array into a string.
        //Once again we use the Arrays object and access the copyOfRange() method and pass the items array.
        //We then specify the range of items we want to copy inside the copyOfRange() method.
        //We do this by starting from the index 0 all the way to count which will return a new array as a value.
        //We now store that value inside a variable called content by assigning it the expression above.
        //We do this so we see the exact number of arrays displayed without any empty indexes after we use pop or push.
        var content = Arrays.copyOfRange(items, 0, count);


        //Now we want to return the content of this array represented as a String.
        //We can do this by using the Arrays class and access the toString() method and pass content as our parameter.
        return Arrays.toString(content);
    }

    //Now we implement our peek method which allows us to see the last item in our stack without removing it.
    public int peek()
    {
        //If our stack is empty which means its at index [0] with no value,
        //We will not be able to peek and [count - 1] will return -1 as an index.
        //This will cause an error so we must throw and exception using an if statement.
        //If the count field/attribute is 0 then we throw a new IllegalStateException();
        if(count == 0)
            throw new IllegalStateException();

        //We want to return items of count minus 1.
        return items[count - 1];
    }

    //Finally we implement the isEmpty() method which returns a boolean value.
    //If our stack is empty it will return count == 0.
    public boolean isEmpty()
    {
        return count == 0;
    }
}
