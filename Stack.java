package ASM2;

import java.util.EmptyStackException;

public class Stack implements IStackQueue{
    Node<String> top;
    private class Node<String>{
        String value;
        Node<String> next = null;

        public Node(String value) {
            this.value = value;
        }
    }
    public Stack() {
        top = null;
    }

    @Override
    public void push(Object textValue) {
        if(isFull()){
            throw new StackOverflowError();
        }else{
            Node newNode = new Node((String) textValue);
            if(isEmpty()) top = newNode;
            else{
                newNode.next = top;
                top = newNode;
            }
        }
    }

    @Override
    public Object pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            Node<String> temp = top;
            top = top.next;
            return temp.value;
        }
    }

    @Override
    public void peek() {
        System.out.println("Peek value is: " + top.value);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public void print() {
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return;
        }
        Node<String> temp = top;
        int count = 1;
        System.out.println("Value of the stack: ");
        while(temp != null){
            System.out.println("Stack data element " + (count++) + ": " + temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public int size() {
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return 0;
        }
        Node<String> temp = top;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[]args){
        Stack stack = new Stack();
    }
}
