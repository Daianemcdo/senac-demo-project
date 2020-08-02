package br.edu.sc.senac.demo.demoproject;

import java.util.Arrays;
import java.util.List;

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
	
	//List<ClientDTO> clients;
	
	private final ClientController clientController;
	
	ClientService(final ClientController clientController) {
		this.clientController = clientController;
	}
		
	@PostMapping("/add-default")
	public void addDefault(){
	
		addClient("Everton", "03/05/1900", "everton@senac.br");
		addClient("Marciel", "05/06/1980", "marciel@senac.br");
		addClient("Gabriel", "01/09/2005", "gabriel@senac.br");
		addClient("Ricardo", "10/07/1950", "ricardo@senac.br");
		addClient("Yago", "06/11/1999", "yago@senac.br");

	}

		
/*		ClientDTO client = new ClientDTO("Daiane", "24/10/2001", "daiane@senac.com");
	    clients.add(client);
	    
	    client = new ClientDTO("Daiane", "24/10/2001", "daiane@senac.com");
	    clients.add(client);
	    
	    client = new ClientDTO("Daiane", "24/10/2001", "daiane@senac.com");
	    clients.add(client);
	    
	    client = new ClientDTO("Daiane", "24/10/2001", "daiane@senac.com");
	    clients.add(client);
	  
	    client = new ClientDTO("Daiane", "24/10/2001", "daiane@senac.com");
	    clients.add(client);
	}
*/
	
	@GetMapping("/list")
	public List<ClientDTO> list() {
		return clientController.getAllClients();
    }


	@GetMapping("/{id}/details")
	public ResponseEntity<ClientDTO>getClient(@PathVariable Long id) {
		final ClientDTO client = this.clientController.getClient(id);
		if (client.equals(ClientDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			return new ResponseEntity<>(client, HttpStatus.OK);
		}
	
/*	@DeleteMapping("/{id}")
	public ResponseEntity<ClientDTO> removeClient(@PathVariable Long id){
		ClientDTO removedClient = this.clientController.removeClient(id);
		if (ClientDTO.NULL_VALUE.equals(removedClient)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(removedClient, HttpStatus.OK);
	}
	*/
	@PostMapping("/add")
		public Long addClient(@RequestParam("nome") String nome, @RequestParam("dataNascimento") String dataNascimento, @RequestParam("email") String email) { 
		ClientDTO client = new ClientDTO(nome, dataNascimento, email);
		return this.clientController.addClient(client);
	}
	
//	@PostMapping("/addpayload")
//	public Long addClient(@RequestBody ClientDTO client) {
//		return this.clientController.addClient(client); 
//	}

/*	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO updateClient){
		ClientDTO oldClient = this.clientController.updateClient(id, updateClient);
		if (ClientDTO.NULL_VALUE.equals(oldClient)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldClient, HttpStatus.OK);
			
		}*/
	}
