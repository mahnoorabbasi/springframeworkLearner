package LearningProject.main.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import LearningProject.main.model.v2.JuiceDTOV2;
import LearningProject.main.model.v2.JuiceStylEnum;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class JuiceServiceImplementorV2 implements JuiceServiceV2 {

	@Override
	public JuiceDTOV2 getJuiceById(UUID juiceId) {
		return JuiceDTOV2.builder().id(UUID.randomUUID())
				.juiceName("Peach")
				.juiceStyle(JuiceStylEnum.MANGO)
				.build();
	}

	@Override
	public JuiceDTOV2 saveNewJuice(JuiceDTOV2 juiceDto) {
		return JuiceDTOV2.builder().id(UUID.randomUUID())
				.juiceName("Saved - Juice")
				.juiceStyle(JuiceStylEnum.COLA)
				.build();
	}
	@Override
	public void updateJuiceDTO(UUID juiceId, JuiceDTOV2 juiceDTO) {
		//TODO: impl an update instance here ?
		
	}

	@Override
	public void deleteJuiceDTO(UUID juiceId) {
		log.debug("deleting a juice DTO");
		
	}
	

}
