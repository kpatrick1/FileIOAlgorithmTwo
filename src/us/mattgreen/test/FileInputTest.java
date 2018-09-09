package us.mattgreen.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.mattgreen.FileInput;

import static org.junit.Assert.*;

public class FileInputTest {
    private final static FileInput places = new FileInput("places.csv");
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /*
     TEST NOT REQUIRED - RETURNS VOID
     */
    @Test
    public void fileRead() {
    }

    @Test
    public void fileReadLine() {
        assertEquals(true, places.fileReadLine() instanceof String);
    }

    /*
     TEST NOT REQUIRED - RETURNS VOID
     */
    @Test
    public void fileClose() {
    }
}