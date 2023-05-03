package com.interland.blooddonationmanagement.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.interland.blooddonationmanagement.entity.BloodDonation;
import com.interland.blooddonationmanagement.repository.specification.SpecReturn;

public interface BloodDonationService {

	List<BloodDonation> getAll();

	BloodDonation addDonor(BloodDonation bloodDonation);

	BloodDonation getBloodDonorByID(int id);

	BloodDonation updateBloodDonor(int id, BloodDonation bloodDonation);

	List<BloodDonation> deleteBloodDonor(int id);

	JSONObject searchByLimit(SpecReturn specs);

}
