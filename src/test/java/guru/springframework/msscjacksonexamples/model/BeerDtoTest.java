package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
class BeerDtoTest extends BaseTest{
    @Autowired
    ObjectMapper mapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = mapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }
    
    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"59e44df9-8fc0-4ae8-933a-5eec9569e1a1\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":1234568901,\"price\":12.99,\"createdDate\":\"2021-09-20T23:04:18.365075-03:00\",\"lastUpdatedDate\":\"2021-09-20T23:04:18.366638-03:00\"}\n";

        BeerDto dto = mapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}