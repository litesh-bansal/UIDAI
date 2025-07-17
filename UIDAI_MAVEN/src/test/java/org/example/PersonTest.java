package org.example;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private PersonToJson converter;
    private JsonToObject jsonConverter;

    @BeforeEach
    public void setUp() {
        this.converter = new PersonToJson();
        this.jsonConverter = new JsonToObject();
    }
    @Test
    void TestPersonIsCorrectedCorrectly(){

        Person person = new Person();
        person.setName("Litesh");
        person.setAge(22);
        person.setBalance(400.0);
        person.setInterest(Arrays.asList("cricket, games, bathing"));

        String jsonOutput = converter.convertToJson(person);
        Person jsonResult = jsonConverter.ConvertToObject(jsonOutput);
        assertNotNull(jsonOutput);
        assertEquals("Litesh",jsonResult.getName());
        assertEquals(22,jsonResult.getAge());
    }
}
