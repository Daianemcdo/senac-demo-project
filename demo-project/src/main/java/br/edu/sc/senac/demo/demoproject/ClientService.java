package br.edu.sc.senac.demo.demoproject;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/client")
final class ClientService {
	
	private final ClientController clientController;
	
	public ClientService(final ClientController clientController) {
		this.clientController = clientController;
	}
		
	@PostMapping("/add-default")
	public void addDefault(){
		
		ClientDTO client = new ClientDTO("Everton", "03/05/1900", "everton@senac.br");
	    clients.add(client);

	    client = new ClientDTO("Marciel", "05/06/2001", "marciel@senac.br");
	    clients.add(client);

	    client = new ClientDTO("Gabriel", "02/08/2005", "gabriel@senac.br");
	    clients.add(client);

	    client = new ClientDTO("Ricardo", "10/06/1995", "ricardo@senac.br");
	    clients.add(client);
	    
	    client = new ClientDTO("Yago", "03/07/1920", "yago@senac.br");
	    clients.add(client);
	}
	
	@GetMapping("/list")
	public List<ClientDTO> list() {
//	Poderia ser feito com return this.clients (sendo opcional)
		return clientController.getAllClients();
    }
    
	@GetMapping("/{id}/details")
	public ResponseEntity<ClientDTO>getClient(@PathVariable Long id) {
		ClientDTO client = this.clientController.getClient(id);
		if (client.NULL_VALUE.equals(client)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<>(client, HttpStatus.OK);
		}
	
//	@PostMapping("/param") Minha tentativa funcionou, abaixo está o código do professor
//		public ClientDTO id (@RequestParam("nome") String nome, @RequestParam("dataNascimento") String dataNascimento, @RequestParam("email") String email) {
//			return new ClientDTO (nome, dataNascimento, email);
//	}
//}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClientDTO> removeClient(@PathVariable Long id){
		if(id >= clients.size() || id < 0){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	int index = id.intValue();
	ClientDTO client = clients.remove(index);
	return new ResponseEntity<>(client, HttpStatus.OK);
}

	@PostMapping("/addpayload")
	public Long addClient(@RequestBody ClientDTO client) {
		return this.clientController.insertClient(client);
	}
	
	@PostMapping("/add")
		public Long addClient(@RequestParam("nome") String nome, @RequestParam("dataNascimento") String dataNascimento, @RequestParam("email") String email) { 
		ClientDTO client = new ClientDTO(nome, dataNascimento, email);
		clients.add(client);
		Long id = Long.valueOf(clients.size() -1);
		return id;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO updateClient){
		if(id >= clients.size() || id < 0){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int index = id.intValue();
		ClientDTO oldClient = clients.remove(index);
		clients.add(index, updateClient);
		return new ResponseEntity<>(oldClient, HttpStatus.OK);
			
		}
	}

		
