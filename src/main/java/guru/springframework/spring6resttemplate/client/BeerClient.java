package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BeerClient {

    BeerDTO getBeerById(UUID beerId);

    BeerDTO updateBeer(BeerDTO beerDto);

    void deleteBear(UUID id);

    BeerDTO createBeer(BeerDTO newDto);

    Page<BeerDTO> listBeers(String beerName);
    Page<BeerDTO> listBeers();
}
