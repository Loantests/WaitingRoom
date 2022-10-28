package marechal.loan.projetbackend.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import marechal.loan.projetbackend.entities.Client;
import marechal.loan.projetbackend.entities.Simulation;
import marechal.loan.projetbackend.services.ClientService;
import marechal.loan.projetbackend.services.SimulationService;

@Controller
@RequestMapping("/simulations")
public class MainController {
	@Autowired
	SimulationService simulationService;
	@Autowired
	ClientService clientService;
	
	@GetMapping(path = { "/new", "/new/" })
    public String newSimulation(Model model) {
        model.addAttribute("simulation", new Simulation());
        model.addAttribute("client", new Client());
        return "index";
    }
	
	@PostMapping("/save")
	public String saveVisitor(@Valid Simulation simulation, @Valid Client client, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
			return "index";
		}
		Client savedClient = clientService.save(client);
		simulation.setClient(savedClient);
		System.out.println(simulation + "\n\n\n" + client);
		Simulation savedSimulation = simulationService.save(simulation);
		model.addAttribute("simulation", savedSimulation);
		model.addAttribute("client", savedClient);
		return "redirect:/index";
	}
}
