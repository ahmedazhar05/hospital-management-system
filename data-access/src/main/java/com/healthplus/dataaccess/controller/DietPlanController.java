package com.healthplus.dataaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthplus.dataaccess.domain.DietPlan;
import com.healthplus.dataaccess.domain.Prescription;
import com.healthplus.dataaccess.repo.DietPlanRepository;


@Controller
@RequestMapping(path="/diet")
public class DietPlanController{
@Autowired
public DietPlanRepository dietPlanRepository;

@GetMapping(path="/search", params="{prescription}")
public List<DietPlan> getDietPlanByPrescription(@RequestParam("prescription")Long id){
	return dietPlanRepository.getDietPlanByPrescription(id);
	
}

@PostMapping(path="/")
public @ResponseBody String addNewDiet(@RequestParam Prescription prescription,@RequestParam String food,@RequestParam Integer duration) {
  DietPlan dp=new DietPlan();
  dp.setPrescription(prescription);
  dp.setFood(food);
  dp.setDuration(duration);
return "Prescribed";
}
}
