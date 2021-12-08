package read_writer_test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import read_writer.DictionaryReadWriter;
import java.util.HashMap;

/**
 * Test basic serilzation of Hashmaps, used by most gateways.
 */
public class DictionaryReadWriterTest {
    HashMap<String,Object> hashMap;
    @Before
    public void setup(){
        this.hashMap = new HashMap<>();
        hashMap.put("123",123);
    }
    @Test
    public void testDictionaryReadWriter(){
        DictionaryReadWriter dictionaryReadWriter = new DictionaryReadWriter();
        dictionaryReadWriter.saveToFile("src/Test/read_writerTest/test.ser",this.hashMap);
        HashMap<String,Object> newHashMap = dictionaryReadWriter.readFromFile("src/Test/read_writerTest/test.ser");
        assertEquals(newHashMap.get("123"),hashMap.get("123"));
    }

}
