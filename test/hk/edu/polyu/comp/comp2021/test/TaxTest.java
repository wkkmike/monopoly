package hk.edu.polyu.comp.comp2021.test;

import hk.edu.polyu.comp.comp2021.monopoly.Map;
import hk.edu.polyu.comp.comp2021.monopoly.Tax;
import hk.edu.polyu.comp.comp2021.monopoly.character;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by 亦凡 on 2016/11/30.
 */
public class TaxTest {
    private Tax testT;
    private character a;
    private final int initMoney = 2000;
    /**
     * set up
     * @throws Exception a
     */
    @Before
    public void setUp() throws Exception {
        testT = new Tax(4, "Income Tax");
        a = new character("wkk", initMoney, 1);
    }
    /**
     * test conductor
     * @throws Exception a
     */
    @Test
    public void action() throws Exception {
        testT = new Tax(4, "Income Tax");
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
        testT.action(a, m);
        assertTrue(outContent.toString().contains("You are in  Income Tax block, you will be charged 10% income tax."));
        assertTrue(outContent.toString().contains("You are charged $200. You have $1800 now."));
        System.setOut((PrintStream) op);
        final int newMoney = 1800;
        assertEquals(a.getCash(), newMoney);

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
        testT.printInfo();
        assertTrue(outContent.toString().contains("You are in  Income Tax block, you will be charged 10% income tax."));
        System.setOut((PrintStream) op);

    }

    /**
     * test whether toString() can output right information
     * @throws Exception a
     */
    @Test
    public void testToString() throws Exception {
        assertEquals(testT.toString(), "Tax:\n" + "Charge character who lands on this block 10% of his money.\n");
    }

    /**
     * test whether toIcon() method can can output right information
     * @throws Exception a
     */
    @Test
    public void toIcon() throws Exception {
        assertEquals(testT.toIcon(), "$ ");
    }
}