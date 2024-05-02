package guru.springframework.spring6resttemplate.client;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.spring6resttemplate.model.BeerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {
    @Override
    public Page<BeerDTO> listBeers(Pageable pageable) {
        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/beer", String.class);
//        System.out.println("String:\n"+response.getBody());
//        System.out.println("String:\n"+response.getBody().toLowerCase());
//        System.out.println("String:\n"+response.getBody().toUpperCase());
//        Arrays.stream(response.getBody().split("}")).forEach(System.out::println);
//
//        ResponseEntity<Map> response2 = restTemplate.getForEntity("http://localhost:8080/api/v1/beer", Map.class);
//        System.out.println("Map:\n"+response2.getBody());
//        System.out.println("Map:key\n"+response2.getBody().keySet());
//        System.out.println("Map:value\n"+response2.getBody().values());

        ResponseEntity<JsonNode> jsonNodeResponse = restTemplate.getForEntity("http://localhost:8080/api/v1/beer", JsonNode.class);
        System.out.println("json:\n"+jsonNodeResponse.getBody());
        System.out.println("json:\n"+jsonNodeResponse.getBody().toPrettyString());
        System.out.println("json:\n"+jsonNodeResponse.getBody().get("content"));

        return null;
    }
}
