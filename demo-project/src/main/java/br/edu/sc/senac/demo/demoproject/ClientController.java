package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
final class ClientController {
	
	List<ClientDTO> clients;
	
/*	private List<ClientDTO> clients = new ArrayList<>();
	
	List<ClientDTO> getAllClients() {
	return this.clients;
	
	}
	
	ClientDTO getClient(Long id) {
		if (isNotExistClient(id)) {
			return ClientDTO.NULL_VALUE;
		}
		int index = id.intValue();
		ClientDTO client = clients.get(index);
			return client;
	}
	
	ClientDTO removeClient(Long id) {
		if (isNotExistClient(id)){
			return ClientDTO.NULL_VALUE;
		}
		int index = id.intValue();
		ClientDTO client = clients.remove(index);
		return client;
	}
	
	Long addClient(ClientDTO client) {
		clients.add(client);
		Long id = Long.valueOf(clients.size() -1);
		return id;
		}
	
	ClientDTO updateClient(final Long id, ClientDTO updateClient) {
		if (isNotExistClient(id)){
			return ClientDTO.NULL_VALUE;
		}
		int index = id.intValue();
		ClientDTO oldClient = clients.remove(index);
		clients.add(index,updateClient);
		return oldClient;
	}
	
	private boolean isNotExistClient(final Long id) {
		return id >= clients.size() || id < 0;
	}
*/
	
	private final ClientRepository clientRepository;

	ClientController(final ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	private static void updateEntityFromDTO(final ClientDTO clientDTO, final ClientEntity clientEntity) {
		clientEntity.setNome(clientDTO.getNome());
		clientEntity.setDataNascimento(clientDTO.getdataNascimento());
		clientEntity.setEmail(clientDTO.getemail());
	}

	private static ClientEntity toEntity(final ClientDTO clientDTO) {
		final String nome = clientDTO.getNome();
		final String dataNascimento = clientDTO.getdataNascimento();
		final String email= clientDTO.getemail();
		return new ClientEntity(nome, dataNascimento, email);
	}

	private static ClientDTO toDTO(final ClientEntity clientEntity) {
		final Long id = clientEntity.getClientId();
		final String nome = clientEntity.getNome();
		final String dataNascimento = clientEntity.getDataNascimento();
		final String email = clientEntity.getEmail();
		return new ClientDTO(nome, dataNascimento, email);
	}

	List<ClientDTO> getAllClients() {
		final List<ClientDTO> clients = new ArrayList<>();
		  final Iterable<ClientEntity> entities = this.clientRepository.findAll();
		  for (final ClientEntity clientEntity : entities) {
		  clients.add(ClientController.toDTO(clientEntity)); }

		return clients;
	}

	ClientDTO getClient(final Long id) {
		final Optional<ClientEntity> optionalClient = this.clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			return ClientController.toDTO(optionalClient.get());
		}
		return ClientDTO.NULL_VALUE;
	}

	ClientDTO removeClient(final Long id) {
		final Optional<ClientEntity> optionalClient = this.clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			final ClientEntity clientEntity = optionalClient.get();
			this.clientRepository.delete(clientEntity);
			return ClientController.toDTO(clientEntity);
		} 
		return ClientDTO.NULL_VALUE;
	}

	Long insertClient(final ClientDTO clientDTO) {
		final ClientEntity clientEntity = ClientController.toEntity(clientDTO);
		this.clientRepository.save(clientEntity);
		return clientEntity.getClientId();
	}

	ClientDTO updateClient(final Long id, final ClientDTO clientDTO) {
		final Optional<ClientEntity> optionalClient = this.clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			final ClientEntity clientEntity = optionalClient.get();
			final ClientDTO oldClientDTO = ClientController.toDTO(clientEntity);
			ClientController.updateEntityFromDTO(clientDTO, clientEntity);
			this.clientRepository.save(clientEntity);
			return oldClientDTO;
		}
		return ClientDTO.NULL_VALUE;
	}
	
	Long addClient(ClientDTO client) {
		clients.add(client);
		Long id = Long.valueOf(clients.size() -1);
		return id;
		}

}
