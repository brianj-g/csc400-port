package portfolioproject;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* Person Class: Define a data type to hold first name, last name, and age */
class Person {
    // Set private attributes
    private String firstName;
    private String lastName;
    private int age;
    
    // Constructor, no args
    public Person() {
        // Nothing to do here
    }
    
    // Constructor
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    // Getters & Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }
    
    // Override method to return a nicely formatted output
    @Override
    public String toString() {
        return String.format("%s, %s: %d", lastName, firstName, age);
    }
}

/* Queue Interface: An abstract data type for Queue */
interface Queue<T>{
    public void enqueue(T item);
    public T dequeue();
    public T peek();
    public int size();
    public boolean isEmpty();
    public void printQueue();
    public T[] toArray();
    public void fromArray(T[] itemArray);
}

/* PersonQueue class: An implementation of Queue using the Person class */
class PersonQueue implements Queue<Person>{
    // Initialize linked list to use for Queue
    private LinkedList<Person> llQueue = new LinkedList<>();
    
    // Initialize size counter
    private int size = 0;

    /* Add a person to the end of the list */
    @Override
    public void enqueue(Person person) {
        llQueue.addLast(person);
        size++; // Size increases when a Person is enqueued
    }

    /* Remove a person from the front of the list and return the object */
    @Override
    public Person dequeue() {
        // Safety check
        if (!llQueue.isEmpty()) {
            throw new NoSuchElementException("Error: Queue is empty");
        }
        
        Person person = llQueue.getFirst();
        llQueue.removeFirst();
        size--; // Size decreases when a Person is dequeued
        
        return person;
    }

    /* Return the object at the front of the list without removing it */
    @Override
    public Person peek() {
        // Safety check
        if (!llQueue.isEmpty()) {
            throw new NoSuchElementException("Error: Queue is empty");
        }
        
        return llQueue.getFirst();
    }

    /* Return the size of the queue (number of objects) */
    @Override
    public int size() {
        return size;
    }

    /* Return true if queue is empty, false if not */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /* Prints out all of the elements in the queue */
    @Override
    public void printQueue() {
        // Use the linked list's iterator
        for(Person p : llQueue) {
            System.out.println(p.toString());
        }
    }

    /* Copy the contents of the queue into an array */
    @Override
    public Person[] toArray() {
        // Initialize new array sized at the queue size
        Person[] personArray = new Person[llQueue.size()];
        
        // Initialize manual iterator for queue
        Iterator<Person> queueIter = llQueue.iterator();
        
        // Traverse linked list and populate the array
        int i = 0; // Array indexer
        while(queueIter.hasNext()) {
            personArray[i] = queueIter.next();
            i++;
        }
        
        return personArray;
    }

    /* Copy the contents of the passed array into the queue */
    @Override
    public void fromArray(Person[] personArray) {
        // Iterate through the array and populate a temporary list
        LinkedList<Person> tempQueue = new LinkedList<>();
        for (int i = 0; i < personArray.length; ++i) {
            tempQueue.addLast(personArray[i]);
        }
        
        // Set llQueue reference to tempQueue, replacing the contents
        llQueue = tempQueue;
    }
}

/* Last Name Comparator Class: For sorting by last name */
class LastNameDescendingComparator implements Comparator<Person>{
    // Return the comparison value of lastName strings
    @Override
    public int compare(Person p1, Person p2) {
        return p2.getLastName().compareTo(p1.getLastName());
    }
}

/* Age Comparator Class: For sorting by age */
class AgeDescendingComparator implements Comparator<Person>{
    // Return the comparison value of age strings
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p2.getAge(), p1.getAge());
    }
}

/* Sorting implementation (QuickSort) */
class QuickSort {
    public static <T> void quickSort(T[] itemArray, int p, int r, Comparator<T> comparator) {
        // base case
        if (p >= r) return;
        
        // Find the new pivot 'q'
        int q = partition(itemArray, p, r, comparator);
        
        // Recursive calls
        quickSort(itemArray, p, q, comparator); // Sort left side of pivot
        quickSort(itemArray, q + 1, r, comparator); // Sort right side of pivot
        
    }
    
    private static <T> int partition(T[] itemArray, int p, int r, Comparator<T> comparator){
        // Pivot is the last element in the partition
        T pivot = itemArray[r];
        
        int i = p - 1; // max index on the left side of pivot
        
        // Check all elements until pivot (right-most)
        for(int j = p; j < r; ++j) {
            if (comparator.compare(itemArray[j], pivot) <= 0 ) {
                // Swap the value at 'i' to the left side of the pivot
                i++; // Advance 'i' to the current position
                T tempVal = itemArray[i]; // Store element 'i' for swapping
                itemArray[i] = itemArray[j];
                itemArray[j] = tempVal;
            }
        }
        
        // Swap the existing pivot into the position between left and right sides
        T tempVal = itemArray[i + 1]; // Store element 'i + 1' for swapping
        itemArray[i + 1] = itemArray[r];
        itemArray[r] = tempVal;
        
        // Return new index of the pivot
        return i + 1;
    }
}

public class PersonMain {    
    public static void main(String[] args) {
        // Initialize queue of Person objects
        PersonQueue personQueue = new PersonQueue();
        
        // Set queue sizes
        final int QUEUE_SIZE = 5;
        final int QUEUE_START = 0;
        final int QUEUE_END = QUEUE_SIZE - 1;
        
        // Initialize scanner to read input
        Scanner scanner = new Scanner(System.in);
        
        // Input loop
        for (int i = 0; i < QUEUE_SIZE; ++i) {
            // Create and populate a new Person
            Person person = new Person();
            System.out.print("First name: ");
            person.setFirstName(scanner.next());
            System.out.print("Last name: ");
            person.setLastName(scanner.next());
            System.out.print("Age: ");
            person.setAge(scanner.nextInt());
            
            personQueue.enqueue(person);
        }
        
        // Inspect the current queue order
        personQueue.printQueue();
        
        // Initialize sorting array
        Person[] sortedArray;
        
        // Sort the queue by last name (descending)
        sortedArray = personQueue.toArray();
        QuickSort.quickSort(sortedArray, QUEUE_START, QUEUE_END, new LastNameDescendingComparator());
        personQueue.fromArray(sortedArray);
        personQueue.printQueue();
        System.out.println();
        
        sortedArray = personQueue.toArray();
        QuickSort.quickSort(sortedArray, QUEUE_START, QUEUE_END, new AgeDescendingComparator());
        personQueue.fromArray(sortedArray);
        personQueue.printQueue();
        System.out.println();
        
    }
}
