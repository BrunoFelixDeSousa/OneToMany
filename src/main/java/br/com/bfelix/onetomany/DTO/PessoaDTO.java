package br.com.bfelix.onetomany.DTO;

import br.com.bfelix.onetomany.entities.Endereco;
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

    public void adicionarEndereco(EnderecoDTO enderecoDTO) {
        enderecos.add(enderecoDTO);
    }
}
