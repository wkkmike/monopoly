package hk.edu.polyu.comp.comp2021.test;

import hk.edu.polyu.comp.comp2021.monopoly.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

/**
 * test
 *
 */
public class GameTest {

    private character player = new character();
    private Map m = new Map();
    private Block[] b=m.getBlockList();
    private final int initMoney = 1500;
    /**
     * test
     * @throws Exception a
     */
    @org.junit.Before
    public void setUp() throws Exception {
        player.setName("Hello_world");
        String data = "6\na\nb\nc\nd\ne\nf\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        //System.setIn(new FileInputStream(".\\input2.txt"));
    }
    /**
     * test
     *
     */
    @Test
    public void test_retire() {
        assertEquals(false, player.isAuto());
        assertEquals(false, player.isRetire());
        assertEquals(initMoney,player.getCash());

        String op = "Y\n";
        System.setIn(new ByteArrayInputStream(op.getBytes()));
        b[1].action(player, m);
        final int newMoney = 700;
        assertEquals(newMoney,player.getCash());

        character checker = new character();
        final int turn = 16;
        final int pay = 90;
        for(int i=1;i<=turn;i++){
           b[1].action(checker, m);
           int std_b = initMoney-i*pay>=0?initMoney-i*pay:-1;
           assertEquals(std_b,checker.getCash());
       }

       assertEquals(false, checker.isRetire());
        b[1].action(checker, m);
        assertEquals(true, checker.isRetire());
        final int newMoney2 = 2200;
        assertEquals(newMoney, player.getCash());
    }
    /**
     * test
     *
     */
    @Test
    public void testRent_in_jail() {
        b[1].action(player, m);
        player.goJail();
        character checker = new character();

        b[1].action(checker, m);
        assertEquals(initMoney, checker.getCash());
    }
    /**
     * test
     *
     */
    @Test
    public void testBasic(){
        //Test the basic Block module
        assertEquals("Central",b[1].getName());
        assertEquals(3 ,b[2].getPosition());
        final int newMoney500 = 500;
        player.setCash(newMoney500);
        assertEquals(newMoney500 + initMoney, player.getCash());

        //Test the tax module
        final int newMoney1800 = 1800;
        final int newMoney1620 = 1620;
        final int newMoney1458 = 1458;
        final int newMoney1313 = 1313;
        b[3].action(player, m);
        assertEquals(newMoney1800, player.getCash());
        b[3].action(player, m);
        assertEquals(newMoney1620, player.getCash());
        b[3].action(player, m);
        assertEquals(newMoney1458, player.getCash());
        b[3].action(player, m);
        assertEquals(newMoney1313, player.getCash());
    }

    /**
     * test
     *
     */
    @Test
    public void testGame() {
        Game.main(null);
    }

}