package test;

import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import services.SelectCityGenerator;

import javax.json.JsonException;
import java.io.IOException;

public class TestSelectCityGenerator {

    @Test(expected= IOException.class)
    public void test_should_give_exception_when_path_to_file_is_wrong() throws JsonMappingException, JsonException, IOException {

        SelectCityGenerator selectCityGenerator = new SelectCityGenerator("wrong/path");
        selectCityGenerator.make();

    }
}
