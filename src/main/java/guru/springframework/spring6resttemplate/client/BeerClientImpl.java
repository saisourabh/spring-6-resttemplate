package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {
    private final RestTemplateBuilder restTemplateBuilder;
    private final String URL = "/api/v1/beer";
    @Override
    public Page<BeerDTO> listBeers() {
        RestTemplate restTemplate =restTemplateBuilder.build();
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath(URL);

        ResponseEntity<BeerDTOPageImpl> jsonNodeResponse = restTemplate.getForEntity(builder.toUriString(), BeerDTOPageImpl.class);
        System.out.println(jsonNodeResponse.getBody());
        return jsonNodeResponse.getBody();
    }
}
