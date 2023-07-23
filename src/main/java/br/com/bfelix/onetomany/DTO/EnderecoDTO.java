package br.com.bfelix.onetomany.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoDTO {

    private String rua;
    private String numero;
    private String cidade;
}
