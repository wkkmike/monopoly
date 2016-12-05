package hk.edu.polyu.comp.comp2021.test;

import hk.edu.polyu.comp.comp2021.monopoly.Block;
import hk.edu.polyu.comp.comp2021.monopoly.character;
import hk.edu.polyu.comp.comp2021.monopoly.Map;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michael on 2016/12/5.
 */
public class BlockTest {
    private Block testb = new Block(5, "test");
    private character testa = new character();
    private Map a = new Map();

    /**
     * test
     * @throws Exception a
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * test
     * @throws Exception a
     */
    @Test
    public void getName() throws Exception {
        assertEquals(testb.getName(),"test");
    }

    /**
     * test
     * @throws Exception a
     */
    @Test
    public void getPosition() throws Exception {
        assertEquals(testb.getPosition(), 5);
    }

    /**
     * test
     * @throws Exception a
     */
    @Test
    public void printInfo() throws Exception {
        testb.printInfo();
    }

    /**
     * test
     * @throws Exception a
     */
    @Test
    public void dismissOwner() throws Exception {
        testb.dismissOwner(testa);
    }

    /**
     * test
     * @throws Exception a
     */
    @Test
    public void action() throws Exception {
        testb.action(testa, a);
    }

    /**
     * test
     * @throws Exception a
     */
    @Test
    public void toIcon() throws Exception {
        assertNull(testb.toIcon());
    }

}