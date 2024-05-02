package guru.springframework.spring6resttemplate.config;

import lombok.Builder;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateBuilderCongif {
@Bean
    RestTemplateBuilder  restTemplateBuilder(RestTemplateBuilderConfigurer configurer){
    RestTemplateBuilder builder = configurer.configure(new RestTemplateBuilder());
    DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory("http://localhost:8080");
    return builder.uriTemplateHandler(uriBuilderFactory);
}
}
