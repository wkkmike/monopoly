package hk.edu.polyu.comp.comp2021.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import hk.edu.polyu.comp.comp2021.monopoly.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by 亦凡 on 2016/11/30.
 */
public class GoToJailTest {
    private GoToJail testG;
    private character a;
    private final int blockNum = 16;
    /**
     * set up
     * @throws Exception a
     */
    @Before
    public void setUp() throws Exception {
        testG = new GoToJail(blockNum,"Go");
        final int initMoney = 2000;
        a = new character("wkk", initMoney, 1);
    }
    /**
     * test conductor
     * @throws Exception a
     */
    @Test
    public void action() throws Exception {
        testG = new GoToJail(blockNum,"Go");
    }
    /**
     * test action() method
     * @throws Exception a
     */
    @Test
    public void testAction() throws Exception {
        Map m = new Map();
        OutputStream op = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testG.action(a, m);
        assertTrue(outContent.toString().contains("You are in the GoToJail Block, you will be sent to the jail."));
        System.setOut((PrintStream) op);

        assertEquals(a.getPostion(), 6);

    }
    /**
     * test whether can output the information
     * @throws Exception a
     */
    @Test
    public void printInfo() throws Exception {
        OutputStream op = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testG.printInfo();
        assertTrue(outContent.toString().contains("You are in the GoToJail Block, you will be sent to the jail."));
        System.setOut((PrintStream) op);
    }

    /**
     * test whether toString() can output right information
     * @throws Exception a
     */
    @Test
    public void testToString() throws Exception {
        assertEquals(testG.toString(), "GoToJail:\n" + "Send character land on this place to Jail.\n");
    }

    /**
     * test whether toIcon() method can can output right information
     * @throws Exception a
     */
    @Test
    public void toIcon() throws Exception {
        assertEquals(testG.toIcon(), "=\n");
    }

}