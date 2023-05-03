package com.interland.blooddonationmanagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interland.blooddonationmanagement.entity.BloodDonation;

@Repository
public interface BloodDonationRepository extends JpaRepository<BloodDonation, Integer>{

	Page<BloodDonation> findAll(Specification<BloodDonation> recordsBySearchSpec, Pageable pageable);

}
