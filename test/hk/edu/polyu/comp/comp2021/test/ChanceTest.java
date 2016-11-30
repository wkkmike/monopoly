package hk.edu.polyu.comp.comp2021.test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import hk.edu.polyu.comp.comp2021.monopoly.*;

/**
 * Created by 亦凡 on 2016/11/30.
 */
public class ChanceTest {
    Chance testC ;
    character a;

    /**
     * set up
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        a = new character("wkk", 2000, 1);
        testC = new Chance(9,"Chance");
    }

    /**
     * test conductor
     * @throws Exception
     */
    @Test
    public void action() throws Exception {
        testC = new Chance(9,"Chance");
    }

    /**
     * test whether the  number between -300 to 200
     * @throws Exception
     */
    @Test
    public void changeMoney() throws Exception {
        assertTrue(testC.changeMoney() >= -300 && testC.changeMoney() <= 200);
    }

    /**
     * test whether can output the information
     * @throws Exception
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

    @Test
    public void testAction() throws Exception {
        Map m = new Map();

    }

    /**
     * test whether toIcon() method can can output right information
     * @throws Exception
     */
    @Test
    public void toIcon() throws Exception {
        Chance test1 = new Chance(9,"Chance");
        Chance test2 = new Chance(19,"Chance");
        Chance test3 = new Chance(13,"Chance");
        assertEquals(test1.toIcon(),"?         ");
        assertEquals(test2.toIcon(),"?\n");
        assertEquals(test3.toIcon(),"? ");
    }

    /**
     * test whether toString() can output right information
     * @throws Exception
     */
    @Test
    public void testToString() throws Exception {
        assertEquals(testC.toString(), "Chance: \n" + "Character lands on this block may get -300 to 200 money randomly.\n");
    }

}