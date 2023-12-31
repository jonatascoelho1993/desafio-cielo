package br.com.bootcampcieloada.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.bootcampcieloada.enums.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private TipoPessoa tipoPessoa;
	
	
	@NotEmpty
	@Column(unique = true)
	private String registroFederal;
	
	@NotEmpty
	private String nomeCliente;
	
	@NotNull
	@Max(value = 9999)
	private Long mcc;
	
	@NotEmpty
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
	private String email;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private InfoComplementoPJ infoComplementoPJ;
	
}
