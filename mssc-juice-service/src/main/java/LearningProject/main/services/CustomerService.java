package LearningProject.main.services;

import java.util.UUID;

import LearningProject.main.model.CustomerDTO;
import LearningProject.main.model.JuiceDTO;

public interface CustomerService {

	CustomerDTO getCustomerById(UUID customerId);

	void deleteCustomer(UUID customerId);

	void updateCustomer(UUID customerId, CustomerDTO customerDTO);

	JuiceDTO saveNewCustomer(CustomerDTO customerDTO);
	

}
