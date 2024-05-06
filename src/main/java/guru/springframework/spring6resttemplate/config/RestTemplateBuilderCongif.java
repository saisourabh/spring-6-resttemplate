package guru.springframework.spring6resttemplate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateBuilderCongif {
    @Value("${rest.template.rootUrl}")
    String rooturl;
    @Value("user1")
    String username;
    @Value("password")
    String password;

    @Bean
    RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
        return configurer.configure(new RestTemplateBuilder())
                .basicAuthentication(username, password)
                .uriTemplateHandler( new DefaultUriBuilderFactory(rooturl));
    }
}
