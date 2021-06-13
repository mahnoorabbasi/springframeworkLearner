package LearningProject.main.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import LearningProject.main.model.CustomerDTO;

@Service
public class CustomerServiceImplementor implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID customerId) {
		
		return new CustomerDTO().builder()
				.name("Mahnoor")
				.id(customerId)
				.build();
	}

	
}
