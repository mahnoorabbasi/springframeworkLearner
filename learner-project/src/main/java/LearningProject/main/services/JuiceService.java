package LearningProject.main.services;

import java.util.UUID;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

import LearningProject.main.model.JuiceDTO;

import org.springframework.context.annotation.FilterType;

public interface JuiceService {

	JuiceDTO getJuiceById(UUID juiceId);

	JuiceDTO saveNewJuice(JuiceDTO juiceDto);

	void updateJuiceDTO(UUID juiceId, JuiceDTO juiceDTO);

	void deleteJuiceDTO(UUID juiceId);

}
