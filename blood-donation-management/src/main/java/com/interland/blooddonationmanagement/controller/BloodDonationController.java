package com.interland.blooddonationmanagement.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interland.blooddonationmanagement.entity.BloodDonation;
import com.interland.blooddonationmanagement.exception.RecordNotFoundException;
import com.interland.blooddonationmanagement.repository.specification.SpecReturn;
import com.interland.blooddonationmanagement.service.BloodDonationService;

@RestController
@RequestMapping("/blood")
@CrossOrigin("http://localhost:4200/")
public class BloodDonationController {
	
	@Autowired
	BloodDonationService bloodDonationService;
	
	@GetMapping("/getAll")
	public List<BloodDonation> getAll() {

		return bloodDonationService.getAll();
	}

	@PostMapping("/add")
	public BloodDonation addBloodDonation(@RequestBody BloodDonation bloodDonation) {
		
		return bloodDonationService.addDonor(bloodDonation);
	}
	
	@GetMapping("/getID/{id}")
	public BloodDonation getBloodDonation(@PathVariable int id) {

		return bloodDonationService.getBloodDonorByID(id);
	}

	@PutMapping("/updateBloodDonation/{id}")
	public BloodDonation updateBloodDonation(@PathVariable int id, @RequestBody BloodDonation bloodDonation) {

		return bloodDonationService.updateBloodDonor(id, bloodDonation);
	}
	
	@DeleteMapping("/deleteId/{id}")
	public List<BloodDonation> deleteBloodDonation(@PathVariable int id) {

		return bloodDonationService.deleteBloodDonor(id);
	}
	
	@PostMapping("/search")

	public ResponseEntity<JSONObject> searchByPage(@RequestBody SpecReturn specs)
			throws NumberFormatException, RecordNotFoundException {

		
		
		System.out.println("hitteeddddd");
		JSONObject list = bloodDonationService.searchByLimit(specs);

		return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
	}

}
