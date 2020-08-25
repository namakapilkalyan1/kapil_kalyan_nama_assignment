
package com.training.scholarTraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.scholarTraining.model.Scholar;
import com.training.scholarTraining.model.ScholarUI;
import com.training.scholarTraining.repository.ScholarRepo;

//Business Logic
@Service
public class ScholarService {

	@Autowired
	ScholarRepo scholarRepo;
	

	public List<ScholarUI> getAllScholars() {
		List<Scholar> scholars = scholarRepo.getAllScholars();
		List<ScholarUI> scholarUI = new ArrayList<>();

		for (Scholar scholar : scholars) {
			ScholarUI sch = new ScholarUI();
			sch.setiNumber(scholar.getiNumber());
			sch.setName(scholar.getName());
			sch.setBatch(scholar.getCourseDuration() + " " + scholar.getJoiningYear());
			scholarUI.add(sch);
		}

		return scholarUI;
	}

	public ScholarUI getScholar(String id) {
		// TODO Auto-generated method stub
		Scholar s1;
		s1=scholarRepo.getScholar(id);
		ScholarUI s2=new ScholarUI();
		s2.setiNumber(s1.getiNumber());
		s2.setName(s1.getName());
		s2.setBatch(s1.getCourseDuration()+" "+s1.getJoiningYear());
		System.out.println("hello service getscholar");
		return s2;
	}

	public void addScholar(ScholarUI scholar) {
		// TODO Auto-generated method stub
	
       
	}

	public void deleteScholar(String id) {
		// TODO Auto-generated method stub
		scholarRepo.deleteScholar(id);
	}

}