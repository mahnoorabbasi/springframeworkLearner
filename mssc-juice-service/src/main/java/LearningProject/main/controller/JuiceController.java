package LearningProject.main.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import LearningProject.main.model.JuiceDTO;
import LearningProject.main.services.JuiceService;
@RestController
@RequestMapping("/app/v1/juice")
public class JuiceController {
	private final JuiceService juiceService;

	public JuiceController(JuiceService juiceService) {
		super();
		this.juiceService = juiceService;
	}

	
	@GetMapping("/{juiceId}")
	public ResponseEntity<JuiceDTO> getJuiceById(@PathVariable("juiceId") UUID juiceId){
		System.out.println("Getting juicedot for: "+juiceId);
		return new ResponseEntity<>(juiceService.getJuiceById(juiceId), HttpStatus.OK);
		
	}
	@GetMapping("hello")
	public String index(){
		return "Hello World";
		
	}
	
	@PostMapping() 
	public ResponseEntity<JuiceDTO> handlePost(@RequestBody JuiceDTO juiceDto){
		
		JuiceDTO savedJuiceDto=juiceService.saveNewJuice(juiceDto);
		HttpHeaders headers= new HttpHeaders();
		
		//todo : add propert url value here
		headers.add( "Location","/app/v1/juice/"+savedJuiceDto.getId()+"");
		
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
		
	}
	@PutMapping("/{juiceId}")
	   public ResponseEntity handleUpdate(@PathVariable("juiceId") UUID juiceId, @RequestBody JuiceDTO juiceDTO){
		juiceService.updateJuiceDTO(juiceId,juiceDTO);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping("/{juiceId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteJuice(@PathVariable("juiceId") UUID juiceId) {
		juiceService.deleteJuiceDTO(juiceId);
	}

}
