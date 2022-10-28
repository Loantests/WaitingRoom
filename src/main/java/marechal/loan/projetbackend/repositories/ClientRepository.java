package marechal.loan.projetbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import marechal.loan.projetbackend.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
