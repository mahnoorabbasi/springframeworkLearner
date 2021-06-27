package LearningProject.main.controller.v2;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import LearningProject.main.model.v2.JuiceDTOV2;
import LearningProject.main.services.JuiceService;
import LearningProject.main.services.v2.JuiceServiceV2;

//@Deprecated
@RestController
@RequestMapping("/app/v2/juice")
public class JuiceControllerV2 {
	private final JuiceServiceV2 juiceService;

	public JuiceControllerV2(JuiceServiceV2 juiceService) {
		super();
		this.juiceService = juiceService;
	}

	
	@GetMapping("/{juiceId}")
	public ResponseEntity<JuiceDTOV2> getJuiceById(@PathVariable("juiceId") UUID juiceId){
		System.out.println("Getting juicedot for: "+juiceId);
		return new ResponseEntity<>(juiceService.getJuiceById(juiceId), HttpStatus.OK);
		
	}
	@GetMapping("hello")
	public String index(){
		return "Hello World";
		
	}
	
	@PostMapping() 
	public ResponseEntity<JuiceDTOV2> handlePost(@RequestBody JuiceDTOV2 juiceDto){
		
		JuiceDTOV2 savedJuiceDto=juiceService.saveNewJuice(juiceDto);
		HttpHeaders headers= new HttpHeaders();
		
		//todo : add propert url value here
		headers.add( "Location","/app/v2/juice/"+savedJuiceDto.getId()+"");
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
		
	}
	@PutMapping("/{juiceId}")
	   public ResponseEntity handleUpdate(@PathVariable("juiceId") UUID juiceId, @RequestBody JuiceDTOV2 JuiceDTOV2){
		juiceService.updateJuiceDTO(juiceId,JuiceDTOV2);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping("/{juiceId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteJuice(@PathVariable("juiceId") UUID juiceId) {
		juiceService.deleteJuiceDTO(juiceId);
	}

}
