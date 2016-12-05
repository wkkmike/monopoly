package hk.edu.polyu.comp.comp2021.test;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import hk.edu.polyu.comp.comp2021.monopoly.*;

/**
 * Created by 亦凡 on 2016/11/30.
 */
public class ChanceTest {
    private Chance testC ;
    private character a;
    private final int initMoney = 2000;
    private final int maxMoney = 200;
    private final int minMoney = -300;
    private final int B13 = 13;
    private final int B19 = 19;
    /**
     * set up
     * @throws Exception a
     */
    @Before
    public void setUp() throws Exception {
        a = new character("wkk", initMoney, 1);
        testC = new Chance(9,"Chance");
    }

    /**
     * test conductor
     * @throws Exception a
     */
    @Test
    public void action() throws Exception {
        testC = new Chance(9,"Chance");
    }

    /**
     * test whether the  number between -300 to 200
     * @throws Exception a
     */
    @Test
    public void changeMoney() throws Exception {
        assertTrue(testC.changeMoney() >= minMoney && testC.changeMoney() <= maxMoney);
    }

    /**
     * test whether can output the information
     * @throws Exception a
     */
    @Test
    public void printInfo() throws Exception {
        Map m = new Map();
        OutputStream op = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testC.printInfo();
        assertTrue(outContent.toString().contains("You are in a Chance Box, you may win or lose money"));
        System.setOut((PrintStream) op);
    }

    /**
     * test
     * @throws Exception a
     */
    @Test
    public void testAction() throws Exception {
        Map m = new Map();

    }

    /**
     * test whether toIcon() method can can output right information
     * @throws Exception a
     */
    @Test
    public void toIcon() throws Exception {
        Chance test1 = new Chance(9,"Chance");
        Chance test2 = new Chance(B19,"Chance");
        Chance test3 = new Chance(B13,"Chance");
        assertEquals(test1.toIcon(),"?         ");
        assertEquals(test2.toIcon(),"?\n");
        assertEquals(test3.toIcon(),"? ");
    }

    /**
     * test whether toString() can output right information
     * @throws Exception a
     */
    @Test
    public void testToString() throws Exception {
        assertEquals(testC.toString(), "Chance: \n" + "Character lands on this block may get -300 to 200 money randomly.\n");
    }

}