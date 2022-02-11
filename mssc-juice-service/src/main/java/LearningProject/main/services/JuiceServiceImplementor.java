package LearningProject.main.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import LearningProject.main.model.JuiceDTO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class JuiceServiceImplementor implements JuiceService {

	@Override
	public JuiceDTO getJuiceById(UUID juiceId) {
		return JuiceDTO.builder().id(UUID.randomUUID())
				.juiceName("Peach")
				.juiceStyle("Cola")
				.build();
	}

	@Override
	public JuiceDTO saveNewJuice(JuiceDTO juiceDto) {
		return JuiceDTO.builder().id(UUID.randomUUID())
				.juiceName("Saved - Juice")
				.juiceStyle("Cola")
				.build();
	}
	@Override
	public void updateJuiceDTO(UUID juiceId, JuiceDTO juiceDTO) {
		//TODO: impl an update instance here ?
		
	}

	@Override
	public void deleteJuiceDTO(UUID juiceId) {
		log.debug("deleting a juice DTO");
		
	}
	

}
