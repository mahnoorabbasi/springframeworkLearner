package LearningProject.main.services;

import java.util.UUID;

import LearningProject.main.model.CustomerDTO;

public interface CustomerService {

	CustomerDTO getCustomerById(UUID customerId);
	

}
