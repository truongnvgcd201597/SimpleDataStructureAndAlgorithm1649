package ASM2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MessageProcess {
    static Queue queue = new Queue();
    static Stack stack = new Stack();
    Scanner sc = new Scanner(System.in);

        public void ReadInput() {
        try {
            System.out.print("Please enter the short message: ");
            String messValue = sc.nextLine().trim();
            if (messValue.length() > 250) {
                throw new Exception("Message is too long! Please enter again!");
            } else if (messValue.length() == 0 || messValue == "" || messValue.isEmpty() || messValue == null) {
                throw new Exception("Message is empty! Please enter again!");
            }
            else if (messValue.matches("[0-9]+")) {
                throw new Exception("Invalid message because the whole string is numeric! Please enter again!");
            }
            else {
                System.out.println("=\t=\t=\t=\t=\t=\t=\t=\t=\t=\t=\t=\t=\t=\t=\t=\t=\t=\t=\t");
                System.out.println("Typed message : " + messValue);
                ProcessMessage(messValue);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid message! Please enter again!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void ProcessMessage(String messValue) {
        try {
            String[] splitMess = messValue.split("[.,]");
            for (String mess : splitMess) {
                if (mess.length() > 250) {
                    throw new Exception("Message is too long! Please enter again!");
                }
                if (mess.length() == 0 || mess == "") {
                    throw new Exception("Message is empty! Please enter again!");
                }
                if (mess.length() > 0 && mess.length() <= 250) {
                    queue.push(mess);
                    PushStack();
                }
            }
        }catch(InputMismatchException | IllegalArgumentException e) {
            System.out.println("Invalid message! Please enter again!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void PushStack() {
        while (!queue.isEmpty()) {
            stack.push(queue.pop());
        }
    }

    public void DisplayOutput() {
        try {
            stack.print();
        } catch (Exception e) {
            System.out.println("An error occurred while printing the stack: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MessageProcess im = new MessageProcess();
        im.ReadInput();
        // Start the timer
        long startTime = System.nanoTime();
        im.DisplayOutput();
        // Stop the timer
        long endTime = System.nanoTime();
        // Calculate the elapsed time
        long elapsedTime = endTime - startTime;
        // Print the elapsed time
        System.out.println("Elapsed time: " + elapsedTime + " nanoseconds");
        System.out.println("Elapsed time: " + elapsedTime / 1000000000.0 + " seconds");
    }
}


