package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BeerClientImplTest {
    @Autowired
    BeerClientImpl client;

    @Test
    void listBeers(){
        Page<BeerDTO> result = client.listBeers(null);
        System.out.println("result:\n"+result);
    }
    @Test
    void listBeerswithname(){
        Page<BeerDTO> result = client.listBeers("ALE");
        System.out.println("result:\n"+result);
    }

}