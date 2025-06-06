package portfolioproject;

import java.util.Comparator;
import java.util.Iterator;

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
        return String.format("%s, %s: %d\n", lastName, firstName, age);
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
    public Iterator<T> iterator();
    public T[] toArray();
    public void fromArray(T[] itemArray);
}

/* PersonQueue class: An implementation of Queue using the Person class */
class PersonQueue implements Queue<Person>{

    @Override
    public void enqueue(Person item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Person dequeue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Person peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void printQueue() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Iterator<Person> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Person[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void fromArray(Person[] itemArray) {
        // TODO Auto-generated method stub
        
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
        // main things
    }
}
