package ASM2;

interface IStackQueue<String> {
   public void push(String textValue);
   public String pop();
   public void peek();
   public boolean isFull();

   boolean isEmpty();
   public void print();
   public int size();
}
