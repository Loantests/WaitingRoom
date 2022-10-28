package marechal.loan.projetbackend.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marechal.loan.projetbackend.entities.Client;
import marechal.loan.projetbackend.entities.Simulation;
import marechal.loan.projetbackend.services.ClientService;
import marechal.loan.projetbackend.services.SimulationService;

@RestController
@RequestMapping("/project/api/")
public class RController {
	@Autowired
	SimulationService simulationService;
	@Autowired
	ClientService clientService;
	
	@GetMapping("clients/")
	public List<Client> getAllClients(){
		return clientService.getAll();
	}
	
	@GetMapping("simulations/")
	public List<Simulation> getAllSimulations(){
		return simulationService.getAll();
	}
	
	@PostMapping("simulations/")
	public ResponseEntity<Simulation> createSimulation(@RequestBody Simulation simulation) {
		try {
			Simulation createdSimulation = simulationService.save(simulation);
			return new ResponseEntity<>(createdSimulation, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("clients/")
	public ResponseEntity<Client> createClient(@RequestBody Client client){
		try {
			Client createdClient = clientService.save(client);
			return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("simulations/cancel/{id}")
	public ResponseEntity<Simulation> cancelSimulation(@PathVariable("id") long id){
		System.err.println(id);
		try {
			Simulation simulation = simulationService.getById(id);
			simulation.setStatus("Annulée");
			return new ResponseEntity<>(simulationService.save(simulation), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("simulations/date")
	public List<Simulation> getSimulationByDate(@RequestBody String date) throws Exception{
		System.err.println(date);
		date = date.substring(16, 26);
		Date dateD = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		return simulationService.getByDate(dateD);
	}
	
	@GetMapping("simulations/reference")
	public ResponseEntity<Simulation> getSimulationByReference(@RequestBody String reference) {
		reference = reference.substring(20, 26);
		reference = reference.replaceAll("[}\n\r\"\s]", "");
		try {
			Simulation simulation = simulationService.getByReference(reference);
			if(simulation == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(simulation, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
