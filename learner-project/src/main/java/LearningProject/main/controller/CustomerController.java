package LearningProject.main.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LearningProject.main.model.CustomerDTO;
import LearningProject.main.model.JuiceDTO;
import LearningProject.main.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	
	@GetMapping("/ID/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("customerId") UUID customerId){
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

}
