package marechal.loan.projetbackend.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import marechal.loan.projetbackend.entities.Simulation;
import marechal.loan.projetbackend.repositories.SimulationRepository;

@Service
public class SimulationService {
	@Autowired
	SimulationRepository simulationRepository;
	
	public List<Simulation> getAll() {
		return simulationRepository.findAll();
	}
	
	public Simulation save(Simulation simulation) {
		return simulationRepository.save(simulation);
	}
	
	public Simulation getById(long id) {
		return simulationRepository.findById(id).orElse(null);
	}
	
	public List<Simulation> getByDate(Date date) {
		return simulationRepository.findByDate(date);
	}
	
	public Simulation getByReference(String reference) {
		return simulationRepository.findByReference(reference);
	}
	
	public void deleteById(long id){
		simulationRepository.deleteById(id);
	}
}
