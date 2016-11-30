package hk.edu.polyu.comp.comp2021.test;

import hk.edu.polyu.comp.comp2021.monopoly.GoToJail;
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
    Parking testP;
    character a;
    /**
     * set up
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        testP = new Parking(11, "FreeParking");
        a = new character("wkk", 2000, 1);
    }
    /**
     * test conductor
     * @throws Exception
     */
    @Test
    public void action() throws Exception {
        testP = new Parking(11, "FreeParking");

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
        testP.action(a, m);
        assertTrue(outContent.toString().contains("You are in the free parking block, no effect to you."));
        System.setOut((PrintStream) op);
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
        testP.printInfo();
        assertTrue(outContent.toString().contains("You are in the free parking block, no effect to you."));
        System.setOut((PrintStream) op);
    }

    /**
     * test whether toString() can output right information
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {
        assertEquals(testP.toString(), "FreeParking:\n" + "This block has no effect");
    }

    /**
     * test whether toIcon() method can can output right information
     * @throws Exception
     */
    @Test
    public void toIcon() throws Exception {
        assertEquals(testP.toIcon(), "F ");
    }

}