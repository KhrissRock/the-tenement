package br.jus.tream.restlib.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestClientDTO {
    
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
