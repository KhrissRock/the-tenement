package br.jus.tream.restlib.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jus.tream.restlib.domain.DTO.RestClientDTO;
import br.jus.tream.restlib.services.RestClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restclient")
@RequiredArgsConstructor
public class RestClientController {

    private final RestClientService restClientService;

    /**
     * Endpoint to get the RestClientDTO.
     *
     * @return RestClientDTO
     */
    @Tag(name = "RestClient", description = "Endpoint to get the RestClientDTO")
    @GetMapping
    public RestClientDTO findById() {
        return restClientService.getDto();
    }
}
