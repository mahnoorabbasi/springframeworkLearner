package LearningProject.main.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CustomerDTO {

	@Size(min=3, max = 10)
	private String name;
	private UUID id;

}
