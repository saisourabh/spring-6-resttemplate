package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BeerClient {

    Page<BeerDTO> listBeers(Pageable pageable);
}