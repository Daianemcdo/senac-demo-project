package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
final class ClientController {
	
	private List<ClientDTO> clients = new ArrayList<>();
	
	List<ClientDTO> getAllClients() {
	return this.clients;
	
	}
	
	ClientDTO getClient(Long id) {
		if (id >= clients.size() || id < 0) {
			return ClientDTO.NULL_VALUE;
		}
		int index = id.intValue();
		ClientDTO client = clients.get(index);
			return client;
	}
}
