package hk.edu.polyu.comp.comp2021.test;

import hk.edu.polyu.comp.comp2021.monopoly.Block;
import hk.edu.polyu.comp.comp2021.monopoly.Map;
import hk.edu.polyu.comp.comp2021.monopoly.character;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michael on 2016/12/5.
 */
public class characterTest {
    private character p = new character();
    private final int initMoney = 5000;
    /**
     * test
     * @throws Exception a
     */
    @Before
    public void setUp() throws Exception {
        p = new character("test", initMoney, 3);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void setName() throws Exception {
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void getName() throws Exception {
        p.setName("test1");
        assertEquals(p.getName(), "test1");
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void getNo() throws Exception {
        assertEquals(p.getNo(), 3);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void getPostion() throws Exception {
        assertEquals(p.getPostion(), 1);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void buyHouse() throws Exception {
        Block b = new Block(4, "testP");
        p.buyHouse(b);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void setAuto() throws Exception {

    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void isAuto() throws Exception {
        p.setAuto();
        assertTrue(p.isAuto());
    }

    /**
     * test
     * @throws Exception a
     */
    @Test
    public void getCash() throws Exception {

    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void isRetire() throws Exception {

    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void retire() throws Exception {
        Map a = new Map();
        Block b = new Block(1,"sdf");
        p.buyHouse(b);
        p.retire(a);
        assertEquals(p.getCash(), -1);
        assertTrue(p.isRetire());
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void setCash() throws Exception {
        p.setCash(100);
        assertEquals(p.getCash(), initMoney + 100);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void rollDice() throws Exception {
        assertTrue(p.rollDice() >= 1);
        assertTrue(p.rollDice() <= 4);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void injail() throws Exception {
        assertTrue(!p.injail());
        p.goJail();
        assertTrue(p.injail());
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void decreaseJailRound() throws Exception {
        p.goJail();
        assertEquals(p.decreaseJailRound(), 1);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void outJail() throws Exception {
        p.goJail();
        p.outJail();
        assertTrue(!p.injail());
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void move() throws Exception {
        final int turn = 20;
        for(int i=0; i<turn; i++)
            p.move();
        assertTrue(p.getCash()>initMoney);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void testtoString() throws Exception {
        Map a = new Map();
        assertTrue(p.toString(a).contains("Character"));
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void goJail() throws Exception {

    }

}