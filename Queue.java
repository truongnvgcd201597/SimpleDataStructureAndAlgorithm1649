package ASM2;

import java.util.NoSuchElementException;

public class Queue implements IStackQueue {
    Node<String> head, tail;
    public class Node<String>{
        String value;
        Node<String> next = null;

        public Node(String value) {
            this.value = value;
        }
    }
    public Queue() {
        head = tail = null;
    }

    @Override
    public void push(Object textValue) {
        Node newNode = new Node((String) textValue);
        if(textValue == null) throw new NullPointerException();
        if(isFull()){
            throw new StackOverflowError();
        }else{
            if(isEmpty()) head = tail = newNode;
            else tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public Object pop() {
        if(isEmpty()){
            throw new NoSuchElementException("The queue is empty.");
        }else{
            Node<String> temp = head;
            head = head.next;
            if(head == null) tail = null;
            return temp.value;
        }
    }

    @Override
    public void peek() {
        System.out.println("Peek front value is: " + head.value);
    }
    public void peekBack(){
        System.out.println("Peek tail value is: " + tail.value);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if(isEmpty()){
            System.out.println("The queue is empty!");
            return;
        }
        Node<String> temp = head;
        System.out.print("Value of the queue: ");
        while(temp != null){
            System.out.print(temp.value + " | ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public int size() {
        if(isEmpty()){
            System.out.println("The queue is empty!");
            return 0;
        }
        Node<String> temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
