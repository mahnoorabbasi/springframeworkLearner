package LearningProject.main.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import LearningProject.main.model.CustomerDTO;
import LearningProject.main.model.JuiceDTO;

@Service
public class CustomerServiceImplementor implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID customerId) {
		
		return new CustomerDTO().builder()
				.name("Mahnoor")
				.id(customerId)
				.build();
	}

	@Override
	public void deleteCustomer(UUID customerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JuiceDTO saveNewCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
