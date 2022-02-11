package LearningProject.main.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import LearningProject.main.model.CustomerDTO;
import LearningProject.main.model.JuiceDTO;
import LearningProject.main.services.CustomerService;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}


	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("customerId") UUID customerId){
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void hanldeUpdate(@PathVariable("customerId") UUID customerId, CustomerDTO customerDTO){
		customerService.updateCustomer(customerId,customerDTO);


	}

	@PostMapping
public ResponseEntity<JuiceDTO> handlePost(@RequestBody CustomerDTO customerDTO){
		
		JuiceDTO savedCustomerDto=customerService.saveNewCustomer(customerDTO);
		HttpHeaders headers= new HttpHeaders();
		
		//todo : add propert url value here
		headers.add( "Location","/app/v1/customer/"+savedCustomerDto.getId()+"");
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
		
	}


	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
		this.customerService.deleteCustomer(customerId);

	}
}
