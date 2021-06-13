package LearningProject.main.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import LearningProject.main.model.JuiceDTO;



@Service
public class JuiceServiceImplementor implements JuiceService {

	@Override
	public JuiceDTO getJuiceById(UUID juiceId) {
		return JuiceDTO.builder().id(UUID.randomUUID())
				.juiceName("Peach")
				.juiceStyle("Cola")
				.build();
	}

}
