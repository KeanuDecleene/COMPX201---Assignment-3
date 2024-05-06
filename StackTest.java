import java.io.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

public class StackTest {
    private Stack stackTest;
    private final PrintStream output = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void resetStack() {
        stackTest = new Stack();
        System.setOut(new PrintStream(outputStream));
    }

    //Push function tests

    /*
     * Testing pushing to an empty stack
     */
    @Test
    @DisplayName("Push Empty stack ")
    public void testPushToEmptyStack() {
        stackTest.push("A");
        stackTest.dump();
        Assertions.assertEquals("A", stackTest.pop());
    }

    /*
     * Testing pushing multiple items to a stack and if the order is maintained
     */
    @Test 
    @DisplayName("Push Multiple items maintaining correct order")
    public void testPush(){
        buildStack();
        stackTest.dump();
        Assertions.assertEquals("D->C->B->A->", outputStream.toString().trim());
        Assertions.assertEquals("D", stackTest.peek());
    }

    //Pop function tests

    /*
     * testing pop function when stack is empty
     */
    @Test
    @DisplayName("Pop Empty stack")
    public void testEmptyPop(){
        Assertions.assertNull(stackTest.pop());
    }

    /*
     * testing pop function returns correct item and if item is removed correctly
     */
    @Test
    @DisplayName("Pop Non-empty stack")
    public void testPop(){
        buildStack();
        Assertions.assertEquals("D", stackTest.pop());
        stackTest.dump();
        Assertions.assertEquals("C->B->A->", outputStream.toString().trim());
    }

    /*
     * Testing if pop ensures head is null when popping last item
     */
    @Test
    @DisplayName("Pop Last item")
    public void testPopLastItem(){
        stackTest.push("D");
        stackTest.pop();
        Assertions.assertTrue(stackTest.isEmpty());
    }

    //Peek function tests

    /*
     * testing peek function when stack is empty
     */
    @Test
    @DisplayName("Peek Empty stack")
    public void testEmptyPeek(){
        Assertions.assertNull(stackTest.peek());
    }

    /*
     * testing peek function when stack is not empty
     */
    @Test
    @DisplayName("Peek Non-empty stack")
    public void testPeek(){
        buildStack();
        Assertions.assertEquals("D", stackTest.peek());
        stackTest.pop();
        Assertions.assertEquals("C", stackTest.peek());
    }
    
    //isEmpty function tests

    /*
     * Tests if a stack is empty
     */
    @Test
    @DisplayName("isEmpty Empty stack returns True")
    public void testEmptyStack(){
        Assertions.assertTrue(stackTest.isEmpty());
    }

    /*
     * tests that a stack that is not empty returns false 
     */
    @Test
    @DisplayName("isEmpty Non-empty stack returns False")
    public void testStack(){
        buildStack();
        Assertions.assertFalse(stackTest.isEmpty());
    }

    //Dump function tests

    /*
     * Tests that a stack that is empty dumps an empty string
     */
    @Test
    @DisplayName("dump Empty stack")
    public void testEmptyDump(){
        stackTest.dump();
        Assertions.assertEquals("", outputStream.toString().trim());
    }
    

    /*
     * Tests that a stack that is not empty dumps the correct string
     */
    @Test
    @DisplayName("dump Non-empty stack")
    public void testNonEmptyDump(){
        buildStack();
        stackTest.dump();
        Assertions.assertEquals("D->C->B->A->", outputStream.toString().trim());
    }


    /*
     * Builds the stack by pushing some string values.
     */
    private void buildStack(){
        stackTest.push("A");
        stackTest.push("B");
        stackTest.push("C");
        stackTest.push("D");
    }
}
