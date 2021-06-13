package LearningProject.main.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LearningProject.main.model.JuiceDTO;
import LearningProject.main.services.JuiceService;
@RestController
@RequestMapping("/juice")
public class JuiceController {
	private final JuiceService juiceService;

	public JuiceController(JuiceService juiceService) {
		super();
		this.juiceService = juiceService;
	}

	
	@GetMapping("/ID/{juiceId}")
	public ResponseEntity<JuiceDTO> getJuiceById(@PathVariable("juiceId") UUID juiceId){
		System.out.println("Getting juicedot for: "+juiceId);
		return new ResponseEntity<>(juiceService.getJuiceById(juiceId), HttpStatus.OK);
		
	}
	@GetMapping("hello")
	public String index(){
		return "Hello World";
		
	}
//	@RequestMapping("error")
//	    public String handleError() {
//	        //do something like logging
//	        return "error";
//	    }

}
