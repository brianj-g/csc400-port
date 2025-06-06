package portfolioproject;

import java.util.Comparator;
import java.util.Iterator;

/* Person Class: Define a data type to hold first name, last name, and age */
class Person {
    
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

    @Override
    public int compare(Person o1, Person o2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}

/* Age Comparator Class: For sorting by age */
class AgeDescendingComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}

/* Sorting implementation (QuickSort) */
class QuickSort {
    public static <T> void quickSort(T[] itemArray, int p, int r, Comparator<T> comparator) {
        // Magic sorting
    }
    
    private <T> int partition(T[] itemArray, int p, int r, Comparator<T> comparator){
        // Magic partitioning
        return 0;
    }
}

public class PersonMain {    
    public static void main(String[] args) {
        // main things
    }
}
