package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = mapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }
    
    @Test
    void testDeserialize() throws IOException {
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":1234568901,\"price\":\"12.99\",\"createdDate\":\"2021-09-20T23:39:08.994571-03:00\",\"lastUpdatedDate\":\"2021-09-20T23:31:27.393054-03:00\",\"myLocalDate\":\"20210920\",\"beerId\":\"bc1105d1-f5d2-45bc-97a5-9671085521c9\"}\n";
        BeerDto dto = mapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}