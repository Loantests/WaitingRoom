package marechal.loan.projetbackend.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import marechal.loan.projetbackend.entities.Simulation;

public interface SimulationRepository extends JpaRepository<Simulation, Long>{
	public List<Simulation> findByDate(Date date);
	public Simulation findByReference(String reference);
}
