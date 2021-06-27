package LearningProject.main.services.v2;

import java.util.UUID;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

import LearningProject.main.model.JuiceDTO;
import LearningProject.main.model.v2.JuiceDTOV2;

import org.springframework.context.annotation.FilterType;

public interface JuiceServiceV2 {

	JuiceDTOV2 getJuiceById(UUID juiceId);

	JuiceDTOV2 saveNewJuice(JuiceDTOV2 juiceDto);

	void updateJuiceDTO(UUID juiceId, JuiceDTOV2 juiceDTO);

	void deleteJuiceDTO(UUID juiceId);

}
