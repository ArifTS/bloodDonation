package com.interland.blooddonationmanagement.repository.specification;

import java.sql.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.interland.blooddonationmanagement.entity.BloodDonation;



public class BloodDonationSpec {
	
	private static Logger logger = LogManager.getLogger(BloodDonationSpec.class);

	private BloodDonationSpec() {

	}

	public static Specification<BloodDonation> getRecordsBySearchSpec(SpecReturn spec) {
		return new Specification<BloodDonation>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SuppressWarnings({ "deprecation", "unused" })
			@Override
			public Predicate toPredicate(Root<BloodDonation> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate finalPredicate = null;
				JSONParser parser = new JSONParser();
				JSONObject searchObject;
				try {
					if (!StringUtils.isEmpty(spec)) {

						String donorName = spec.getDonorName();
						String donorAge = spec.getDonorAge();
						String bloodGroup = spec.getBloodGroup();
						String lastDonatedDate = spec.getLastDonatedDate();
						
					System.out.println(donorName);
//						System.out.println(strDate);

						

						if (!StringUtils.isEmpty(donorName)) {
							System.out.println(donorName);
							Predicate transactionReferencePredicate = criteriaBuilder
									.like(criteriaBuilder.upper(root.get("donorName")), "%" + donorName.toUpperCase() + "%");
							if (finalPredicate != null) {
								System.out.println("predicate empty");
								finalPredicate = criteriaBuilder.and(finalPredicate, transactionReferencePredicate);
							} else {
								finalPredicate = criteriaBuilder.and(transactionReferencePredicate);
							}
						}
//						

						if (!StringUtils.isEmpty(donorAge)) {
							System.out.println(donorAge);

							Predicate transactionReferencePredicate = criteriaBuilder
									.like(criteriaBuilder.upper(root.get("donorAge")), "%" + donorAge.toUpperCase() + "%");
							if (finalPredicate != null) {
								System.out.println("predicate empty");
								finalPredicate = criteriaBuilder.and(finalPredicate, transactionReferencePredicate);
							} else {
								finalPredicate = criteriaBuilder.and(transactionReferencePredicate);
							}
						}

						if (!StringUtils.isEmpty(bloodGroup)) {
							System.out.println(bloodGroup);

							Predicate transactionReferencePredicate = criteriaBuilder.like(
									criteriaBuilder.upper(root.get("bloodGroup")), "%" + bloodGroup.toUpperCase() + "%");
							if (finalPredicate != null) {
								System.out.println("predicate empty");
								finalPredicate = criteriaBuilder.and(finalPredicate, transactionReferencePredicate);
							} else {
								finalPredicate = criteriaBuilder.and(transactionReferencePredicate);
							}
						}

						if (!StringUtils.isEmpty(lastDonatedDate)) {
							
							System.out.println(lastDonatedDate + "lastDonatedDate");
						
							Date date = Date.valueOf(lastDonatedDate);  
							System.out.println(date + "date");

							Predicate transactionReferencePredicate = criteriaBuilder.equal(criteriaBuilder.function("TRUNC",java.sql.Date.class,root.get("lastDonatedDate")), date);
							if (finalPredicate != null) {
								System.out.println("predicate empty");
								finalPredicate = criteriaBuilder.and(finalPredicate, transactionReferencePredicate);
							} else {
								finalPredicate = criteriaBuilder.and(transactionReferencePredicate);
							}
						}

					}

					String orderBy;

					if (spec.getOrderBy().length() != 0) {
						orderBy = spec.getOrderBy();

					} else {
						orderBy = "donorName";
					}

					query.orderBy(criteriaBuilder.asc(root.get(orderBy)));
				} catch (Exception e) {
					logger.error("Error : " + e.getMessage(), e);
				}

				return finalPredicate;
			}
		};
	}

}
