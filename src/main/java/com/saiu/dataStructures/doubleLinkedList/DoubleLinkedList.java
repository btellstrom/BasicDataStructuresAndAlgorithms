package com.saiu.dataStructures.doubleLinkedList;

import com.saiu.dataStructures.exceptions.MistakenIndex;

/**
 * Created by Artyom Karnov on 26.11.16.
 * artyom-karnov@yandex.ru
 **/

/**
 * Typical com.saiu.dataStructures.doubleLinkedList
 *
 * @param <T> object type for storing in com.saiu.dataStructures.doubleLinkedList
 */
public class DoubleLinkedList<T> {

    private class List<T> {
        public T data;
        public List next;
        public List previous;

        public List(List previous) {
            next = null;
            this.previous = previous;
        }
    }

    private List<T> firstList = new List(null);
    private List<T> tempList;
    private int size;

    /**
     * Constructor with begin initialization
     */
    public DoubleLinkedList() {
        size = 0;
    }

    /**
     * Adding element to com.saiu.dataStructures.doubleLinkedList
     *
     * @param element element for adding
     */
    public void add(T element) {
        tempList = firstList;
        while (tempList.next != null) {
            tempList = tempList.next;
        }
        tempList.data = element;
        tempList.next = new List(tempList);
    }

    /**
     * Displaying com.saiu.dataStructures.doubleLinkedList from index = 0
     */
    public void displayFromStarch() {
        tempList = firstList;
        while (tempList.next != null) {
            System.out.println(tempList.data);
            tempList = tempList.next;
        }

    }

    /**
     * Displaying com.saiu.dataStructures.doubleLinkedList from last index
     */
    public void displayFromEnd() {
        tempList = firstList;
        while (tempList.next != null) {
            tempList = tempList.next;
        }
        tempList = tempList.previous;//?
        while (tempList != null) {
            System.out.println(tempList.data);
            tempList = tempList.previous;
        }
    }

    /**
     * Removing element with index = 0
     */
    public void removeFirst() {
        if (size() > 0) {
            firstList = firstList.next;
        } else {
            throw new MistakenIndex("Index couldn't be <0");
        }
    }

    /**
     * Removing element with last index
     */
    public void removeLast() {
        if (size() > 1) {
            tempList = firstList;
            while (tempList.next.next != null) {
                tempList = tempList.next;
            }
            tempList.next = null;
        } else if (size() == 1)
            removeFirst();
        else {
            throw new MistakenIndex("Index couldn't be <0");
        }
    }

    /**
     * Removing element with adjusted index
     *
     * @param index index for removing
     */

     /*
        * There are 3 situations when is needed to remove list from com.saiu.dataStructures.doubleLinkedList
        * 1 - needed element is first - checking by "if"
        * ([X][][][][])
        * 2 - is needed to remove last element - checking by "else if"
        * ([][][][][X])
        * 3 - is needed to remove element which "surrounded" by others - on last "else"
        * ([][][X][][])
     */
    public void remove(int index) {
        checkingIndex(index);
        if (index == 0) {
            removeFirst();
        } else if (index == size) {
            removeLast();
        } else {
            tempList = firstList;
            for (int i = 0; i < index - 1; i++) {
                tempList = tempList.next;
            }
            tempList.next = tempList.next.next;
        }

    }

    /**
     * Checking correctness of index
     *
     * @param index index for checking
     */
    private void checkingIndex(int index) {
        this.size = size();
        if (index < 0) {
            throw new MistakenIndex("Index couldn't be <0");
        } else if (index >= size) {
            throw new MistakenIndex("Index couldn't be more than list size-1");
        }
    }

    /**
     * Checking linkedList on elements presence
     *
     * @return true - if linkedList has elements, false - if linkedList is empty
     */
    public boolean isEmpty() {
        if (size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Getting size of linkedList
     *
     * @return number of elements
     */
    public int size() {
        int i = 0;
        tempList = firstList;
        while (tempList.next != null) {
            i++;
            tempList = tempList.next;
        }
        return i;
    }

    /**
     * Checking elements storing in linkedList
     *
     * @param element element for checking
     * @return true - if array contain adjusted element, false - if doesn't
     */
    public boolean contains(T element) {
        tempList = firstList;
        while (tempList.next != null) {
            if (tempList.data.equals(element)) {
                return true;
            }
            tempList = tempList.next;
        }
        return false;
    }
}