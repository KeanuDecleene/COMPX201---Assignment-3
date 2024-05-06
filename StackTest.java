import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import java.io.*;
import org.junit.jupiter.api.DisplayName;

public class StackTest {
    private Stack stackTest;
    private final PrintStream output = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    @DisplayName("Resetting stack before each Test")
    public void resetStack() {
        stackTest = new Stack();
        System.setOut(new PrintStream(outputStream));
    }

    //Push function Tests
    @Test
    @DisplayName("Stack is pushing correctly")
    public void testPushStack() {
        buildStack();
        stackTest.dump();
        Assertions.assertEquals("A->B->C->D", outputStream.toString().trim());
    }


    

    /*
     * Builds the stack with some string values.
     */
    private void buildStack(){
        stackTest.push("A");
        stackTest.push("B");
        stackTest.push("C");
        stackTest.push("D");
    }
}


