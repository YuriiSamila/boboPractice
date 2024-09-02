package com.bobocode.cs;

import java.util.NoSuchElementException;

/**
 * {@link ArrayList} is an implementation of {@link List} interface. This resizable data structure
 * based on an array and is simplified version of {@link java.util.ArrayList}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 * <p>
 *
 * @author Serhii Hryhus
 */
public class ArrayList<T> implements List<T> {

    private static Object[] array;
    private int size;

    /**
     * This constructor creates an instance of {@link ArrayList} with a specific capacity of an array inside.
     *
     * @param initCapacity - the initial capacity of the list
     * @throws IllegalArgumentException – if the specified initial capacity is negative or 0.
     */
    public ArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        array = new Object[initCapacity];
    }

    /**
     * This constructor creates an instance of {@link ArrayList} with a default capacity of an array inside.
     * A default size of inner array is 5;
     */
    public ArrayList() {
        array = new Object[5];
    }


    /**
     * Creates and returns an instance of {@link ArrayList} with provided elements
     *
     * @param elements to add
     * @return new instance
     */
    public static <T> List<T> of(T... elements) {
        int length = elements.length;
        ArrayList<T> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(elements[i]);
        }
        arrayList.size = length;
        return arrayList;
    }

    public static void main(String[] args) {
        int[] ints = new int[8];
        System.out.println(ints.length);
    }

    /**
     * Adds an element to the array.
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        if (array[array.length - 1] == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = element;
                    size++;
                    break;
                }
            }
        } else {
            Object[] tempArray = new Object[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
            tempArray[array.length - 1] = element;
            array = tempArray;
            size++;
        }
    }

    /**
     * Adds an element to the specific position in the array where
     *
     * @param index   index of position
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (index >= size + 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] tempArray = new Object[array.length + 1];
        for (int i = 0; i < index; i++) {
            tempArray[i] = array[i];
        }
        tempArray[index] = element;
        for (int i = index; i < array.length; i++) {
            tempArray[i + 1] = array[i];
        }
        array = tempArray;
        size++;
    }

    /**
     * Retrieves an element by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index index of element
     * @return en element
     */
    @Override
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    /**
     * Returns the first element of the list. Operation is performed in constant time O(1)
     *
     * @return the first element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return (T) array[0];
    }

    /**
     * Returns the last element of the list. Operation is performed in constant time O(1)
     *
     * @return the last element of the list
     * @throws java.util.NoSuchElementException if list is empty
     */
    @Override
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return (T) array[array.length - 1];
    }

    /**
     * Changes the value of array at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   position of value
     * @param element a new value
     */
    @Override
    public void set(int index, T element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (array[index] == null) {
            array[index] = element;
            return;
        }
        Object[] tempArray = new Object[array.length];
        for (int i = 0; i < index; i++) {
            tempArray[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        tempArray[index] = element;
        array = tempArray;
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return deleted element
     */
    @Override
    public T remove(int index) {
        if (index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] tempArray = new Object[array.length - 1];
        for (int i = 0; i < index; i++) {
            tempArray[i] = array[i];
        }
        T deletedElement = (T) array[index];
        for (int i = index; i < array.length - 1; i++) {
            tempArray[i] = array[i + 1];
        }
        array = tempArray;
        size--;
        return deletedElement;
    }

    /**
     * Checks for existing of a specific element in the list.
     *
     * @param element is element
     * @return If element exists method returns true, otherwise it returns false
     */
    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return amount of saved elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        if (!isEmpty()) {
            array = new Object[]{};
            size = 0;
        }
    }

}
