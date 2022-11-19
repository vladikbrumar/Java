import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class DataTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testData() {
        exception.expect(IllegalArgumentException.class);
        //Data data = new Data(null, "output.txt");
        Data data = new Data("output.txt", null);
    }

    @Test
    public void testDataReadandWriteFile() {
        String output = "output.txt";
        Data data = new Data("input.txt", output);
        File file = new File(output);
        assertTrue(file.exists());
    }



}