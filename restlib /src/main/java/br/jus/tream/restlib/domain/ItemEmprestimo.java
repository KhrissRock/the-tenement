package br.jus.tream.restlib.domain;

import java.math.BigDecimal;

import br.jus.tream.restlib.domain.pk.ItemEmprestimoPK;
// import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ItemEmprestimo {
    
    @EmbeddedId
    private ItemEmprestimoPK id = new ItemEmprestimoPK();

    private Integer quantidade;

}
