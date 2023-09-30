package br.com.bootcampcieloada.modelos;

import java.util.List;
import java.util.stream.Collectors;

import br.com.bootcampcieloada.entidades.Cliente;
import br.com.bootcampcieloada.entidades.InfoComplementoPJ;
import br.com.bootcampcieloada.enums.TipoPessoa;

public class ClienteDTOBuilder {

	public ClienteDTOBuilder() {
		super();
	}

	public static Cliente buildBack(ClienteDTO dto) {
		return Cliente.builder()//
				.registroFederal(dto.getRegistroFederal())//
				.nomeCliente(dto.getNomeCliente())//
				.email(dto.getEmail())//
				.tipoPessoa(TipoPessoa.getEnum(dto.getTipoPessoa())).mcc(dto.getMcc())//
				.infoComplementoPJ(buildBackInfo(dto.getInfoComplemento(), TipoPessoa.getEnum(dto.getTipoPessoa())))
				.build();
	}

	private static InfoComplementoPJ buildBackInfo(InfoComplementoPJDTO dto, TipoPessoa tipoPessoa) {
		if(dto == null || TipoPessoa.PESSOA_JURIDICA.equals(tipoPessoa)) {
			return null;
		}
			
		return InfoComplementoPJ.builder()//
				.cpfContato(dto.getCpfContato())//
				.nomeContato(dto.getNomeContato())//
				.build();
	}

	public static ClienteDTO build(Cliente entity) {
		return ClienteDTO.builder()//
				.registroFederal(entity.getRegistroFederal())//
				.nomeCliente(entity.getNomeCliente())//
				.email(entity.getEmail())//
				.tipoPessoa(entity.getTipoPessoa().codigo)//
				.mcc(entity.getMcc())//
				.infoComplemento(buildInfo(entity.getInfoComplementoPJ(), entity.getTipoPessoa()))
				.build();
	}
	
	private static InfoComplementoPJDTO buildInfo(InfoComplementoPJ entity, TipoPessoa tipoPessoa) {
		if(entity == null || TipoPessoa.PESSOA_JURIDICA.equals(tipoPessoa)) {
			return null;
		}
			
		return InfoComplementoPJDTO.builder()//
				.cpfContato(entity.getCpfContato())//
				.nomeContato(entity.getNomeContato())//
				.build();
	}

	public static List<ClienteDTO> build(List<Cliente> list) {
		if (list == null)
			return null;

		return list.stream()//
				.map(ClienteDTOBuilder::build)//
				.collect(Collectors.toList());
	}

}
