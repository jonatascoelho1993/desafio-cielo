package br.com.bootcampcieloada.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class InfoComplementoPJ {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Length(min = 11, max = 11)
	@NotBlank
	private String cpfContato;
	
	@NotBlank
	private String nomeContato;
	
}
