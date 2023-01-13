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
public class JuiceDTO {
	
	private UUID id;
	@Size(min = 3, max = 10)
	private String juiceName;
	private String juiceStyle;
	private Long upc;
 
}
