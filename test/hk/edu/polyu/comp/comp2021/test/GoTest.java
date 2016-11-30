package hk.edu.polyu.comp.comp2021.test;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import hk.edu.polyu.comp.comp2021.monopoly.*;
/**
 * Created by michael on 2016/11/28.
 */
public class GoTest {
    Go testG;
    character a;

    /**
     * set up
     * @throws Exception
     */
    @Before
    public void setup()throws Exception{
        testG = new Go(1,"Go");
        a = new character("wkk", 2000, 1);
    }

    /**
     * test conductor
     * @throws Exception
     */
    @Test
    public void action() throws Exception {
        testG = new Go(1,"Go");
    }
    /**
     * test whether can output the information
     * @throws Exception
     */
    @Test
    public void printInfo() throws Exception {
        OutputStream op = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testG.printInfo();
        assertTrue(outContent.toString().contains("You are in the Go block."));
        System.setOut((PrintStream) op);
    }

    /**
     * test action() method
     * @throws Exception
     */
    @Test
    public void testAction() throws Exception {
        Map m = new Map();
        OutputStream op = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testG.action(a, m);
        assertTrue(outContent.toString().contains("You are in the Go block."));
        System.setOut((PrintStream) op);
    }

    /**
     * test whether toString() can output right information
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {
        assertEquals(testG.toString(), "Go:\n" + "Give $1500 to everyone pass through this block.\n");
    }

    /**
     * test whether toIcon() method can can output right information
     * @throws Exception
     */
    @Test
    public void toIcon() throws Exception {
        assertEquals(testG.toIcon(), "G\n");
    }

}