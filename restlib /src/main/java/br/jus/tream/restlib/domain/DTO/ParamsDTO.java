package br.jus.tream.restlib.domain.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ParamsDTO {
    private Long id;	
	private String nome;
	private String celular;
	private String email;
	
	public ParamsDTO(String nome, String celular) {
		this.nome = nome;
		this.celular = celular;
	}
	
	
}
