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
 * Created by michael on 2016/11/28.
 */
public class PropertyTest {
    Property testP;
    character a;
    @Before
    public void setUp(){
        testP = new Property(1500, 60, 6, "WangJing");
        a = new character("wkk", 2000, 2);
    }

    @After
    public void clear(){
        if(testP.getOwner() != null)
            testP.dismissOwner(a);
    }
    @Test
    public void action() throws Exception {
        testP = new Property(1500, 60, 6, "WangJing");
    }

    @Test
    public void getPrice() throws Exception {
        assertEquals(1500, testP.getPrice());
    }

    @Test
    public void getRent() throws Exception {
        assertEquals(60, testP.getRent());
    }

    @Test
    public void setOwner() throws Exception {
        testP.setOwner(a);
        assertEquals(testP.getOwner(), a);
    }

    @Test
    public void dismissOwner() throws Exception {
        testP.setOwner(a);
        testP.dismissOwner(a);
        assertNull(testP.getOwner());
    }

    @Test
    public void testAction() throws Exception{
        Map m = new Map();
        //test for buy a property
        String data = "y\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        testP.action(a, m);
        assertEquals(testP.getOwner(), a);
        assertEquals(a.getCash(), 500);

        //test for land in himself property
        OutputStream op = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testP.action(a, m);
        assertTrue(outContent.toString().contains("This is you property."));
        System.setOut((PrintStream) op);

        //test for pay rent when the person land in have enough money
        character d = new character("pq", 4000, 1);
        testP.action(d, m);
        assertEquals(d.getCash(), 3940);
        assertEquals(a.getCash(), 560);
        d.setCash(-3900);

        //test for pay rent when the person land in without enough money
        testP.action(d, m);
        assertEquals(a.getCash(), 600);
        assertTrue(d.isRetire());
        testP.dismissOwner(a);

        //no owner property, character don't have enough money to buy;
        ByteArrayOutputStream outContent1 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent1));
        testP.action(a, m);
        assertTrue(outContent1.toString().contains("You don't have enough money to buy this property."));
        assertEquals(a.getCash(), 600);
        assertNull(testP.getOwner());
        System.setOut((PrintStream) op);

        //test for don't buy property when there is no owner.
        data = "n\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        character e = new character("kk", 3000, 3);
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

    @Test
    public void toIcon() throws Exception {
        Property test1 = new Property(1500, 60, 3, "HK");
        Property test2 = new Property(1500, 60, 8, "hk");
        Property test3 = new Property(1500, 60, 12, "hk");
        Property test4 = new Property(1400, 23, 20, "hk");
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