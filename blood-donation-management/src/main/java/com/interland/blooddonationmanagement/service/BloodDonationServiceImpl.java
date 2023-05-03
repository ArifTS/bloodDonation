package com.interland.blooddonationmanagement.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.interland.blooddonationmanagement.entity.BloodDonation;
import com.interland.blooddonationmanagement.repository.BloodDonationRepository;
import com.interland.blooddonationmanagement.repository.specification.BloodDonationSpec;
import com.interland.blooddonationmanagement.repository.specification.SpecReturn;

@Service
public class BloodDonationServiceImpl implements BloodDonationService {

	@Autowired
	BloodDonationRepository bloodDonationRepository;

	@Override
	public List<BloodDonation> getAll() {
		// TODO Auto-generated method stub
		try {
			return bloodDonationRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BloodDonation addDonor(BloodDonation bloodDonation) {
		// TODO Auto-generated method stub
		try {
			return bloodDonationRepository.save(bloodDonation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BloodDonation getBloodDonorByID(int id) {
		// TODO Auto-generated method stub
		try {
			Optional<BloodDonation> optional = bloodDonationRepository.findById(id);
			if (optional.isPresent()) {

				BloodDonation e = optional.get();
				System.out.println(e.getLastDonatedDate());
				return optional.get();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BloodDonation updateBloodDonor(int id, BloodDonation bloodDonation) {
		// TODO Auto-generated method stub
		try {
			Optional<BloodDonation> optional = bloodDonationRepository.findById(id);
			if (optional.isPresent()) {
				BloodDonation entity = optional.get();
				entity.setDonorName(bloodDonation.getDonorName());
				entity.setDonorAge(bloodDonation.getDonorAge());
				entity.setBloodGroup(bloodDonation.getBloodGroup());
				entity.setLastDonatedDate(bloodDonation.getLastDonatedDate());
				entity.setPhoneNumber(bloodDonation.getPhoneNumber());
				return bloodDonationRepository.save(entity);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BloodDonation> deleteBloodDonor(int id) {
		// TODO Auto-generated method stub
		try {
			Optional<BloodDonation> optional = bloodDonationRepository.findById(id);
			if (optional.isPresent()) {
				bloodDonationRepository.deleteById(id);
			}

			return bloodDonationRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject searchByLimit(SpecReturn specs) {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		Logger logger = LogManager.getLogger(getClass());
		
		int start=Integer.parseInt(specs.getiDisplayStart());
		int pageSize=Integer.parseInt(specs.getiDisplayLength());
		try {
			Pageable pageable = PageRequest.of(start / pageSize, pageSize);
			Page<BloodDonation> headerList = bloodDonationRepository.findAll(BloodDonationSpec.getRecordsBySearchSpec(specs),
					pageable);
	

			result.put("aaData", headerList.getContent());
			
			result.put("iTotalRecords", headerList.getTotalElements());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e);
			result.put("aaData", new JSONArray());
			result.put("iTotalDisplayRecords", 0);
			result.put("iTotalRecords", 0);
			result.put("countByStatus", 0);
		}
		return result;
	}

}
