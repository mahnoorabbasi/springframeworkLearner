package LearningProject.main.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JuiceDTO {
	
	private UUID id;
	private String juiceName;
	private String juiceStyle;
	private Long upc;
 
}
