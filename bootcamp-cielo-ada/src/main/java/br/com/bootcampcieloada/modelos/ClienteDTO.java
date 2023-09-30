package br.com.bootcampcieloada.modelos;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	
	@NotBlank
	private String tipoPessoa;
	@NotBlank
	private String registroFederal;
	@NotBlank
	private String nomeCliente;
	@NotNull
	@Min(value = 1)
	@Max(value = 9999)
	private Long mcc;
	@NotBlank
	private String email;
	
	@Valid
	private InfoComplementoPJDTO infoComplemento;

}
