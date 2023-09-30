package br.com.bootcampcieloada.modelos;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoComplementoPJDTO {
	
	@Length(min = 11, max = 11)
	@NotBlank
	private String cpfContato;
	
	@NotBlank
	private String nomeContato;
	
}
