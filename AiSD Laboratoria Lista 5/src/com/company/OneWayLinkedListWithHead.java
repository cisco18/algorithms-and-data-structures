package com.company;

import java.io.Serializable;
import java.util.AbstractList;

public class OneWayLinkedListWithHead<E> extends AbstractList<E> implements Serializable{
    private class Element implements Serializable {
        private E value;
        private Element next;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        Element(E data) {
            this.value = data;
        }
    }

    Element head = null;

    public OneWayLinkedListWithHead() {
    }

    public int size() {
        int pos = 0;
        Element actElem = head;
        while (actElem != null) {
            pos++;
            actElem = actElem.getNext();
        }
        return pos;
    }


    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
    }


    @Override
    public E get(int index) {
        Element actElem = getElement(index);
        return actElem == null ? null : actElem.getValue();
    }

    public boolean add(E element) {
        Element newElem = new Element(element);

        if (head == null) {
            head = newElem;
            return true;
        }

        Element tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }

        tail.setNext(newElem);
        return true;
    }

    public void delete(E value) {
        Element temp = head, prev = null;

        if (temp != null && temp.getValue() == value) {
            head = temp.next; // Changed head
            return;
        }

        while (temp != null && temp.getValue() != value) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        prev.next = temp.next;
    }

    public void add(int index, E element) {
        if (index < 0) return;

        Element newElem = new Element(element);

        if (index == 0) {
            newElem.setNext(head);
            head = newElem;
            return;
        }

        Element actElem = getElement(index - 1);

        if (actElem == null)
            return;

        newElem.setNext(actElem.getNext());
        actElem.setNext(newElem);
    }

    private Element getElement(int index) {
        Element actElement = head;
        while (index > 0 && actElement != null) {
            index--;
            actElement = actElement.getNext();
        }
        return actElement;
    }


}