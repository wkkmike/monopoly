package hk.edu.polyu.comp.comp2021.test;

import hk.edu.polyu.comp.comp2021.monopoly.Map;
import hk.edu.polyu.comp.comp2021.monopoly.Parking;
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
public class ParkingTest {
    private Parking testP;
    private character a;
    private final int blockNum = 11;
    /**
     * set up
     * @throws Exception a
     */
    @Before
    public void setUp() throws Exception {
        testP = new Parking(blockNum, "FreeParking");
        final int initMoney = 2000;
        a = new character("wkk", initMoney, 1);
    }
    /**
     * test conductor
     * @throws Exception a
     */
    @Test
    public void action() throws Exception {
        testP = new Parking(blockNum, "FreeParking");

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
        testP.action(a, m);
        assertTrue(outContent.toString().contains("You are in the free parking block, no effect to you."));
        System.setOut((PrintStream) op);
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
        testP.printInfo();
        assertTrue(outContent.toString().contains("You are in the free parking block, no effect to you."));
        System.setOut((PrintStream) op);
    }

    /**
     * test whether toString() can output right information
     * @throws Exception a
     */
    @Test
    public void testToString() throws Exception {
        assertEquals(testP.toString(), "FreeParking:\n" + "This block has no effect");
    }

    /**
     * test whether toIcon() method can can output right information
     * @throws Exception a
     */
    @Test
    public void toIcon() throws Exception {
        assertEquals(testP.toIcon(), "F ");
    }

}