

package com.training.scholarTraining.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.scholarTraining.model.ScholarUI;
import com.training.scholarTraining.service.ScholarService;

//DEFINE APIs - Handle Requests and Send Responses
@RestController
@RequestMapping("api/v1")
public class ScholarController {
	
	private ScholarService scholarService;
	
	@Autowired
	public ScholarController(ScholarService scholarService) {
		this.scholarService = scholarService;
	}


	@GetMapping("scholars")
	public List<ScholarUI> getAllScholars() {
		System.out.println("hello allscholars");
		return scholarService.getAllScholars();
	}
	
	@GetMapping("scholar")
	public ScholarUI getScholar(@RequestParam String id) {
		return scholarService.getScholar(id);
	}
	

	@PostMapping("scholar")
	public void addScholar(@RequestBody ScholarUI scholar) {
		scholarService.addScholar(scholar);
	}
	
	@DeleteMapping("scholar")
	public void deleteScholar(@RequestParam String id) {
		scholarService.deleteScholar(id);
	}

}