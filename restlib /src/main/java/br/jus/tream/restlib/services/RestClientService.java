package br.jus.tream.restlib.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import br.jus.tream.restlib.domain.DTO.RestClientDTO;

@Service
public class RestClientService {
    public RestClientDTO getDto() {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve()
                .body(RestClientDTO.class);
    }
}
