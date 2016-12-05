package hk.edu.polyu.comp.comp2021.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import hk.edu.polyu.comp.comp2021.monopoly.*;
/**
 * Created by michael on 2016/11/28.
 */
public class PropertyTest {
    private Property testP;
    private character a;
    private final int initMoney = 1500;
    private final int initRent = 60;
    /**
     * test
     *
     */
    @Before
    public void setUp(){
        testP = new Property(initMoney, initRent, 6, "WangJing");
        final int initMoney = 2000;
        a = new character("wkk", initMoney, 2);
    }
    /**
     * test
     *
     */
    @After
    public void clear(){
        if(testP.getOwner() != null)
            testP.dismissOwner(a);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void action() throws Exception {
        testP = new Property(initMoney, initRent, 6, "WangJing");
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void getPrice() throws Exception {
        assertEquals(initMoney, testP.getPrice());
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void getRent() throws Exception {
        assertEquals(initRent, testP.getRent());
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void setOwner() throws Exception {
        testP.setOwner(a);
        assertEquals(testP.getOwner(), a);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void dismissOwner() throws Exception {
        testP.setOwner(a);
        testP.dismissOwner(a);
        assertNull(testP.getOwner());
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void testAction() throws Exception{
        Map m = new Map();
        //test for buy a property
        String data = "y\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        testP.action(a, m);
        assertEquals(testP.getOwner(), a);
        final int newCash = 500;
        assertEquals(a.getCash(), newCash);

        //test for land in himself property
        OutputStream op = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testP.action(a, m);
        assertTrue(outContent.toString().contains("This is you property."));
        System.setOut((PrintStream) op);
        final int initPM = 4000;
        //test for pay rent when the person land in have enough money
        character d = new character("pq", initPM, 1);
        testP.action(d, m);
        assertEquals(d.getCash(), initPM - initRent);
        final int newCash2 = 560;
        assertEquals(a.getCash(), newCash2);
        final int reduceMoney = -3900;
        d.setCash(reduceMoney);

        //test for pay rent when the person land in without enough money
        testP.action(d, m);
        final int newCash3 = 600;
        assertEquals(a.getCash(), newCash3);
        assertTrue(d.isRetire());
        testP.dismissOwner(a);

        //no owner property, character don't have enough money to buy;
        ByteArrayOutputStream outContent1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent1));
        testP.action(a, m);
        assertTrue(outContent1.toString().contains("You don't have enough money to buy this property."));
        assertEquals(a.getCash(), newCash3);
        assertNull(testP.getOwner());
        System.setOut((PrintStream) op);

        //test for don't buy property when there is no owner.
        data = "n\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        final int initPM2 = 3000;
        character e = new character("kk", initPM2, 3);
        ByteArrayOutputStream outContent4 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent4));
        testP.action(e,m);
        assertTrue(outContent4.toString().contains("You don't buy this property"));
        assertNull(testP.getOwner());
        System.setOut((PrintStream) op);

        //test for invalid input;
        data = "b\n" + "y\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ByteArrayOutputStream outContent3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent3));
        testP.action(e, m);
        assertTrue(outContent3.toString().contains("Would you want to buy this property? Input end by return.Y/N: "));
        assertEquals(testP.getOwner(), e);
        System.setOut((PrintStream) op);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void testtoString() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Property\n");
        sb.append("Owner: No owner\n");
        sb.append("Price: $1500\n");
        sb.append("Rent: $60\n");
        sb.append("Position: 6\n");
        String s = sb.toString();
        assertEquals(testP.toString(), s);
        testP.setOwner(a);
        sb= new StringBuilder();
        sb.append("Property\n");
        sb.append("Owner: " + a.getName() + "\n");
        sb.append("Price: $1500\n");
        sb.append("Rent: $60\n");
        sb.append("Position: 6\n");
        s = sb.toString();
        assertEquals(testP.toString(), s);
    }
    /**
     * test
     * @throws Exception a
     */
    @Test
    public void toIcon() throws Exception {
        Property test1 = new Property(initMoney, initRent, 3, "HK");
        Property test2 = new Property(initMoney, initRent, 8, "hk");
        final int B12 = 12;
        final int B20 = 20;
        final int R23 = 23;
        Property test3 = new Property(initMoney, initRent, B12, "hk");
        Property test4 = new Property(initMoney - 100, R23, B20, "hk");
        Property test[] = new Property[]{test1, test2, test3, test4};
        String s1 = "0 ";
        String s2 = "0         ";
        String s3 = "0 ";
        String s4 = "0\n";
        String s[] = new String[]{s1, s2, s3, s4};
        for (int i = 0; i < 4; i++)
            assertEquals(test[i].toIcon(), s[i]);
        s1 = "2 ";
        s2 = "2         ";
        s3 = "2 ";
        s4 = "2\n";
        s = new String[]{s1, s2, s3, s4};
        for (int i = 0; i < 4; i++)
            test[i].setOwner(a);
        for (int i = 0; i < 4; i++)
            assertEquals(test[i].toIcon(), s[i]);
    }
}