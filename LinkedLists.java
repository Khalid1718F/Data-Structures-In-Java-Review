/*
A LinkedList is a Data Structure that is used to store a list of items/objects in sequence.
Unlike Arrays/ArrayLists LinkedList can shrink and grow automatically and are not contiguous.
This means that Arrays/ArrayLists are stored where they have a common border or are touching.
A linked list consists of a group of nodes in sequence.
A node holds two pieces of data:
First, a value (Ex. String, int, char, double, object, etc...)
Second, a pointer/reference to the address for the next node in the LinkedList.
A LinkedList is a useful data structure in situations where frequent modification occurs.
LinkedLists are also dynamic in size and efficient in memory allocation/utilization.
This means that memory allocation is done at the run time by the compiler,
and we do not need to mention the size of the list during LinkedList declaration.
The first node in the LinkedList is called the head and the last one is called the tail.
The head of the LinkedList only contains the Address of the First element of the List.
The Last element of the LinkedList contains null in the pointer part of the node,
this is because it is the end of the List so it doesn’t point to anything.
A LinkedList in Java in an abstract data type.
An abstract data type has a set of data and a set of operations.
It’s a type defined in terms of its data items and associated operations, not its implementation.
It’s a way of looking at data structure focusing on what it does, ignoring how it does its job.
Abstract Data Type specification is called an interface.
 */

package com.company;

import java.util.Arrays;

public class LinkedLists {

    public static void main(String[] args) {
        // Creating a LinkedList object from the ListBuild class.
        ListBuild listObject = new ListBuild();

        // Here we use our addLast method to add elements to the end of our list.
        listObject.addLast(40);
        listObject.addLast(50);
        listObject.addLast(60);

        // Here we use our addFirst method to add items to the beginning of our list.
        listObject.addFirst(30);
        listObject.addFirst(20);
        listObject.addFirst(10);

        // Now we remove the first and last items from our LinkedList using the
        // corresponding methods.
        listObject.removeFirst();
        listObject.removeLast();
        // Now we print out the result of our LinkedList after the modifications have
        // been made.
        System.out.println(listObject);

        // We check our indexOf method using the print statement with the LinkedList
        // object.
        System.out.println(listObject.indexOf(20));
        // We check our contains method using the print statement and the LinkedList
        // object.
        System.out.println(listObject.contains(50));
        // We check the size of our LinkedList using the size method.
        System.out.println(listObject.size());

        // We declare our array of integers in our main method and set it equal to,
        // our listObject that accesses the toArray method to convert the values to an
        // array.
        // These new values are now stored in out array object and can be referenced.
        int[] array = listObject.toArray();

        // Now we import the Arrays class and use it to access the toString method.
        // Inside the toString method we pass our arrays object as an argument.
        // The expression gets evaluated and printed using the println method.
        System.out.println(Arrays.toString(array));

    }
}
