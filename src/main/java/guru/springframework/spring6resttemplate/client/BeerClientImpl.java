package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {
    private final RestTemplateBuilder restTemplateBuilder;
    private final String GET_BEER_PATH = "/api/v1/beer";
    private static final String GET_BEER_BY_ID_PATH = "/api/v1/beer/{beerId}";

    @Override
    public BeerDTO getBeerById(UUID beerId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForObject(GET_BEER_BY_ID_PATH, BeerDTO.class, beerId);
    }

    @Override
    public BeerDTO updateBeer(BeerDTO beerDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(GET_BEER_BY_ID_PATH, beerDto, beerDto.getId());
        return getBeerById(beerDto.getId());
    }
    @Override
    public BeerDTO createBeer(BeerDTO newDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();

 //       ResponseEntity<BeerDTO> response = restTemplate.postForEntity(GET_BEER_PATH, newDto, BeerDTO.class);
        URI uri = restTemplate.postForLocation(GET_BEER_PATH,newDto);
        System.out.println("path::"+uri.getPath());
        return restTemplate.getForObject(uri.getPath(), BeerDTO.class, newDto.getId());
    }


    @Override
    public Page<BeerDTO> listBeers(String beerName) {
        RestTemplate restTemplate =restTemplateBuilder.build();
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath(GET_BEER_PATH);
        if(beerName != null && !beerName.isEmpty()) {
            builder.queryParam("beerName", beerName);
        }
        System.out.println("url = " + builder.toUriString());
        ResponseEntity<BeerDTOPageImpl> jsonNodeResponse = restTemplate.getForEntity(builder.toUriString(), BeerDTOPageImpl.class);
        System.out.println(jsonNodeResponse.getBody());
        return jsonNodeResponse.getBody();
    }
}
