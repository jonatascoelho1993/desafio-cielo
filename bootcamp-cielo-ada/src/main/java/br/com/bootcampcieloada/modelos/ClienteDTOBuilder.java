package br.com.bootcampcieloada.modelos;

import br.com.bootcampcieloada.entidades.Cliente;
import br.com.bootcampcieloada.enums.TipoPessoa;

public class ClienteDTOBuilder {
	
	public ClienteDTOBuilder() {
		super();
	}

	public static Cliente builBack(ClienteDTO dto) {
		return Cliente.builder()//
				.registroFederal(dto.getRegistroFederal())//
				.nomeCliente(dto.getNomeCliente())//
				.email(dto.getEmail())//
				.tipoPessoa(TipoPessoa.getEnum(dto.getTipoPessoa()))
				.mcc(dto.getMcc())//
				.build();
	}

}
