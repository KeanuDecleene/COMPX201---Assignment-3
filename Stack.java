/*
 * Linked list that processes commands in LIFO order (Stack)
 * 
 * @author Keanu De Cleene
 */
public class Stack{

    private Node head;

    /*
     * adds an item to the front of the list (bottom of the stack)
     * 
     * @param s the string to add
     */
    public void push(String s){
        Node n = new Node(s);
        if(head == null){
            head = n;
            return;
        }
        n.next = head;
        head = n;
    }

    /*
     * remove a node and return an item from the front of the list (bottom of the stack), 
     *
     *
     * @return the item that was removed from the stack
     */
    public String pop(){
        if (head == null) {
            System.out.println("Stack is empty");
            return null;
        }
        Node current = head;
        head = current.next;
        return current.value;
    }

    /*
     * Looks at the first item of the stack and returns the value 
     * 
     * @return the value of the first item in the stack
     */
    public String peek(){
        if (head == null) {
            System.out.println("Stack is empty");
            return null;
        }
        return head.value;
    }

    /*
     * counts the number of items currently in the stack 
     * 
     * @return the number of items currently in the stack
     */
    public int length(){
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /*
     * Looks at first item in the stack to see if the stack is empty. If it is empty returns True otherwise returns False
     * 
     * @return True if the stack is empty, False otherwise
     */
    public Boolean isEmpty(){
        if(head == null){
            return true;
        }
        return false;
    }

    /*
     * prints all the items in the stack to the terminal
     */
    public void dump() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.println();
    }
    
/*
 * A node that stores a datum and its pointer
 */
public class Node{
    private String value;
    private Node next;

    /*
     * takes a string and puts that value into value variable, intialises next to null
     * 
     * @param the string value to be stored
     */
    public Node(String s){
        value = s;
        next = null;
    }
}
}