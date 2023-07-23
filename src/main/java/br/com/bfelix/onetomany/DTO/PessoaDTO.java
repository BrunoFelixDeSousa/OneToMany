package br.com.bfelix.onetomany.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO {

    private String nome;
    @JsonProperty("enderecos")
    private List<EnderecoDTO> enderecos;
}
