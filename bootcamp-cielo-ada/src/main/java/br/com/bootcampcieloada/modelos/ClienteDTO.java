package br.com.bootcampcieloada.modelos;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

	@NotNull
	private String tipoPessoa;

	@NotEmpty
	@Column(unique = true)
	private String registroFederal;

	@NotEmpty
	private String nomeCliente;

	@NotEmpty
	@Max(value = 9999)
	private Long mcc;

	@NotEmpty
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
	private String email;

}
