package com.company;

import java.util.NoSuchElementException;

public class LinkedIntList {
    private ListNode front;

    public LinkedIntList(){
        front = null;
    }

    public void add(int value){
        if(front == null){
            front = new ListNode(value);
        }
        else{
            ListNode current = front;
            while(current.next != null){
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    public int get(int index){
        ListNode current = front;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    public void add (int index, int value){
        if(index == 0){
            front = new ListNode(value, front);
        }
        ListNode current = front;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }
        current.next = new ListNode(value, current.next);
    }

    public int remove (){
        if(front == null){
            throw new NoSuchElementException();
        }
        else {
            int value = front.data;
            front = front.next;
            return value;
        }
    }

    public void remove(int index){
        if(index == 0){
            front = front.next;
        }
        else{
            ListNode current = front;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public void addSorted(int value){
        if(value <= front.data || front == null){
            front = new ListNode(value, front);
        }
        else{
            ListNode current = front;
            while (current.next != null && current.next.data < value){
                current = current.next;
            }
            current.next = new ListNode(value, current.next);
        }
    }

    public int size() {
        int count = 0;
        ListNode current = front;
        while(current.next != null){
            current = current.next;
            count++;
        }
        return count;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void clear (){
        while(front.next != null){
            front = front.next;
        }
        front = null;
    }

    /*public void toString (){
        System.out.print("[");
        ListNode current = front;
        while(current.next != null){
            System.out.print(current + ", ");
            current = current.next;
        }
        System.out.println(current + " ]");
    }*/

}
