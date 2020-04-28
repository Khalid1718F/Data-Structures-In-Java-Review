/*
A node is a class of its own since a LinkedList can be known as a collection of objects.
Below we also have a example of a self referential class.
The Node class has a field/attribute called next that is an object of it's self.
This is because it is declared using the 'Node' class after the variable is called next.
It is called self referential because it contains the same type of field as it's class.
The variable 'next' for each node contains an integer for a memory address.
Whenever a link object is created it's reference is initially null.
 */

package com.company;

import java.util.NoSuchElementException;

public class ListBuild
{
    private class Node
    {
        //Here we add two fields/attributes to the Node class.
        private int data;
        //In this field Node points to the next node when it is linked to the next variable.
        private Node next;

        //Here we create a Node class constructor in order to Make the private Node class accessible.
        //This allows the private fields/attributes of 'data' & 'next' to be accessed by other methods and classes.
        public Node(int data)
        {
            this.data = data;
        }

    }

    //These private fields of the Node class refer to the head and tails of our LinkedList.
    private Node first;
    private Node last;
    //In this field we declare a private int type variable to keep track of the size of our LinkedList.
    private int size;

    //Here we are creating an addLast method that takes an int called item as a parameter.
    public void addLast(int item)
    {
        //First we wrap the value of this integer 'item' inside a Node object.
        //We do this by first creating a node object from he Node class.
        //Then we pass the myNode object the value of the item parameter.
        //This put our 'myNode' object in a valid state because it now has a value.
        Node myNode = new Node(item);

        //Now we write an if-else statement to check if our LinkedList is empty.
        //If it is empty then we need to set 'first' and 'last' (head & tail) to myNode object because it has a value.
        //This lets the 'first' & 'last' (head & tail) point to the myNode (new node) object.
        //If it's not empty then we append the myNode (new node) object to the tail at the end of the list.
        if(isEmpty())
            first = last = myNode;
        else {
            last.next = myNode;
            //Now we update 'last' (tail) to point to the myNode (new node) object.
            //This is because we now have one new node in this list.
            last = myNode;
        }

        //We now increment the size of our LinkedList by one since we added an item at the end.
        size++;

    }

    //Here we create an addFirst method that takes an int called item as a parameter.
    public void addFirst(int item)
    {
        //Just like in our previous method we wrap the value of this integer 'item' in our myNode object.
        //This is done by passing the Node constructor class the item variable as an argument.
        Node myNode = new Node(item);

        //We write another if-else statement to check if our LinkedList is empty again.
        //If it is empty then we need to set 'first' and 'last' (head & tail) to myNode object because it has a value.
        //If its not empty then we prepend the myNode (new node) object to the head at the front of the list.
        //If it's not empty then we prepend the myNode (new node) object to the front of the list.
        if(isEmpty())
            first = last = myNode;
        else{
            //We want the head myNode object to point to the 'first' node or in this case the head.
            myNode.next = first;
            //Now we set the 'first' (head) field to point to the 'myNode' object.
            first = myNode;
        }

        //We now increment the size of our LinkedList by one since we added an item at in the beginning.
        size++;
    }

    //We create a private method that checks if our list is empty.
    //It's return type is boolean and returns if the head 'first' is empty or not.
    //If the list is empty then it wont have a head or 'first' that is the logic here.
    //This method can now be called inside the 'if' block of our methods.
    private boolean isEmpty()
    {
        return first == null;
    }

    //This method traverses our LinkedList from the beginning to the end.
    //When we find an element of our list that has the value of 'item' we need to return the index of that element.
    public int indexOf(int item)
    {
        //Since we don't have indexes here we can declare an index variable of type int and initialize it to 0.
        //It is of type int because our item parameter is of type int.
        int index = 0;
        //We create a new object that checks our 'current' node while we traverse our list and assign it to 'first'.
        Node current = first;
        //Now we use a while loop to make sure if we reached the end of the list or not.
        //As long as 'current' object isn't empty or equal to null we will compare it's value to item (list element).
        while (current != null)
        {
            //Here we use an if statement to check if the value of the 'current' node is the same as 'item' (element).
            //We use the 'data' field/attribute of our node object 'current' that we created from the Node class.
            //If it is the same as our item element then we return the current index of that item.
            if(current.data == item) return index;
            //If it is not equal to the 'current' node then we set our current node to the next node.
            current = current.next;
            //Then we increment our index variable by one.
            index++;
        }
        //If we reach the end of our list and traverse through every element and we can't find a node that
        //has that value then we need to return -1.
        return -1;
    }

    //Here we have another method to check if our list contains a certain element within it.
    //This method has a boolean return type and a parameter of type int using our 'item' variable.
    //This method follows the same logic as the indexOf method in that we first traverse our list.
    //If we find the item then we return true if not it should return false.
    public boolean contains(int item)
    {
        //We reuse our indexOf method in a return statement by calling the method and passing item as an argument.
        //We set that value that we get after passing item to indexOf to not equal -1.
        //If the expression is true then we get a true and that means the item is in our list.
        //If the expression is false then we false and it means the item is not in our list.
        return indexOf(item) != -1;
    }

    //Here we have another method where we remove the first item in a LinkedList.
    //Suppose our list looks like this [10->20->30] 10 points to 20 and 20 points to 30.
    //We have a field called 'first'(head) which points/refers to 10. first->10,
    //We wan't this field to point to 20 so it can be like this first->20.
    //This will shift our list so that it could look like this [20->30].
    //However we have an issue where this object 'first' is pointing to 20 and first is 10.
    //The garbage collector in java will not be able to remove this reference object from memory.
    //To solve this problem we must remove the link in this list [10 '->' 20->30].
    //If we remove this link we cant have first point to the second node [10 20->30].
    //The moment we remove this link we will lose track of the second node.
    //To solve this problem we need two references 'first' and 'second'.
    public void removeFirst()
    {
        //We want to throw an exception in case our LinkedList is empty.
        //We can do this  by using an if statement and using the isEmpty method from earlier.
        //This will return a value of true if our list is empty and false if its not.
        //After that we throw a new NoSuchElementException so our program can catch it.
        if(isEmpty())
            throw new NoSuchElementException();

        //We use another if statement in case we have a single item in our list.
        //We do this by setting the 'first' equal to the 'last' inside the parenthesis of our if statement.
        //If there is one item on the list then logically 'first' and 'last' will be equivalent.
        //If there is a single item we then set 'first' and 'last' equal to null so we can initialize the value.
        if(first == last)
            first = last = null;
        //If there is more than one item we implement the else block.
        else {
            //First we declare a reference variable of the Node class called second and assign it first.next.
            //This way our new reference variable 'second' will point to 20 after it is assigned first.next
            Node second = first.next;
            //Now we remove the link between first.next by assigning it null as a value [10 ' ' 20->30].
            first.next = null;
            //Now we update our 'first' reference variable by setting it to our 'second' reference variable.
            //Remember that our 'second' reference variable now points/refers to 20 and holds 10 as it's value.
            //Our 'second' reference variable is like a place holder for the 'first' while we unlink first from 10.
            //When we reattach 'first' to our list and give it the value of 'second' instead of null,
            //It will have 20 as a value and shift over one and point to 30 now like so [20 -> 30].
            first = second;
        }

        //Now we decrement the size of our LinkedList by 1.
        size--;

    }

    //Here we have another method where we remove the last item from a LinkedList.
    //Suppose our list looks like this [10->20->30] 10 points to 20 and 20 points to 30.
    //We have a field called 'last' (tail)  which points/refers to 30. last->30,
    //To remove this item we want to find the previous node which is pointing to 20.
    //In order to find this previous item we must traverse our list and locate it's position.
    //After we locate the position of the previous node we need to keep a reference to it.
    //This is so we can update last and set it to point to the same node which is 20.
    public void removeLast()
    {
        //We want to throw an exception if our list is empty using an if statement.
        if(isEmpty())
            throw new NoSuchElementException();

        //Another edge case if there is a single item in our LinkedList.
        //If there is a single item in our linked list then the logic below won't work.
        //This is because there is no such thing as a node before the last one since there is only one.
        //Therefore the logic below assumes our list has at least two nodes to work with.
        //We use another if-else statement here to check if first is equivalent to last.
        //If first is equal to last then we will set both 'first' and 'last' equal to null.
        if(first == last)
            first = last = null;
        //Otherwise we implement this else block.
        else{
            //Now we can call our getPrevious method and pass it the last node as an argument.
            //Then we will store the result of that in a Node reference variable called 'previous'
            Node previous = getPrevious(last);
            //In order to shrink our list we will assign 'last' the value of 'previous'
            last = previous;
            //To remove the link we set last.next to null.
            last.next = null;
        }

        //We now decrement the size of our list by 1.
        size--;
    }

    //Here we have a private method that returns a node object and takes in the myNode object as a parameter.
    //Whatever node we give this method it will return the previous node.
    private Node getPrevious(Node myNode)
    {
        //We start this by declaring a reference variable 'current' and assign it 'first'.
        Node current = first;
        //Now we use a while loop to check if our 'current' reference variable/node is equal to null.
        //As long as 'current' is not equal to null we can enter the while loop.
        while (current != null)
        {
            //Now we use a if statement to check if the next value of the 'current' reference variable/node,
            //is equal to 'myNode' parameter. If that's the case then we return the current node.
            //If it is not the case then we set 'current' to point to the 'next' node.
            if(current.next == myNode) return current;
            //At this point we have the node that is current to the last one.
            current = current.next;

        }
        //If we traverse the list and cannot find the node before the last we should return null in this method.
        return null;
    }

    //Here we have another method that gives us the size of our LinkedList.
    //This method has public access modifier and it has has a return type of int.
    //This method will return the size of our LinkedList when it is called.
    public int size()
    {
        return size;
    }

    //This method converts a LinkedList into an array.
    //This method is public and has a return type of an integer array.
    public int[] toArray(){
        //We create a new array object and assign it the value of the size of the array.
        //We do this by passing the size field in our new integer of arrays index.
        //This will assign the size of the new array of integers to our array object.
        int[] array = new int[size];
        //We need to traverse this LinkedList and as we discover each node we add it to our array.
        //We create an object from the Node class that tracks our current point in our traversal.
        //After that we set 'current' to the 'first' (head) node.
        Node current = first;
        //As long as current is not null in each iteration we will add our current node to our array.
        //We must first create another reference variable to keep track of the index and initialize it to zero.
        int index = 0;
        //Now we create a while loop to make sure that our current reference variable is not null.
        while (current != null){
            //If current is not null we set the index of our array object to the value of current.
            array[index] = current.data;
            //At ths point we must increment the index variable by 1.
            index++;
            //Finally we need to set our 'current' node to reference our next node.
            current = current.next;
        }
        //Once we have passed through the while loop we must return the value of our array.
        return array;
    }


}
