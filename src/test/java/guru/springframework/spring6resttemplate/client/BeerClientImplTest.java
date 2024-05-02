package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

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
    @Test
    void getBeerById() {

        Page<BeerDTO> beerDTOS = client.listBeers(null);

        BeerDTO dto = beerDTOS.getContent().get(0);

        BeerDTO byId = client.getBeerById(dto.getId());

        assertNotNull(byId);
        System.out.println(byId);
    }
    @Test
    void testCreateBeer() {

        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("123245")
                .build();

        BeerDTO savedDto = client.createBeer(newDto);
        assertNotNull(savedDto);
    }
    @Test
    void testUpdateBeer() {

        BeerDTO newDto = BeerDTO.builder()
                .price(new BigDecimal("10.99"))
                .beerName("Mango Bobs 2")
                .beerStyle(BeerStyle.IPA)
                .quantityOnHand(500)
                .upc("123245")
                .build();

        BeerDTO beerDto = client.createBeer(newDto);

        final String newName = "Mango Bobs 3";
        beerDto.setBeerName(newName);
        BeerDTO updatedBeer = client.updateBeer(beerDto);

        assertEquals(newName, updatedBeer.getBeerName());
    }

}