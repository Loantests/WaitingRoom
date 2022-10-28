package marechal.loan.projetbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marechal.loan.projetbackend.entities.Client;
import marechal.loan.projetbackend.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> getAll(){
		return clientRepository.findAll();
	}
	
	public Client getById(long id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	public void delete(Client client) {
		clientRepository.deleteById(client.getId());
	}
	
	public void delete(long id) {
		clientRepository.deleteById(id);
	}
}
