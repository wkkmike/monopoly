package hk.edu.polyu.comp.comp2021.test;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by michael on 2016/11/28.
 */
public class GoTest {
    @Before
    public void setup(){
        
    }

    @Test
    public void printInfo() throws Exception {
        OutputStream op = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

    }

    
    @Test
    public void action() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void toIcon() throws Exception {

    }

}