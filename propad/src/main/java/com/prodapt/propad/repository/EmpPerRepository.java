package com.prodapt.propad.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;

@Repository
public interface EmpPerRepository extends JpaRepository<PropadEmpPerDetails, Integer> {
//	
//	@Query(value="select * from propad_emp_per_details where ep_per_emp_id=?1", nativeQuery = true)
//	PropadEmpPerDetails findByEp_per_emp_id(int ep_per_emp_id);
	
	@Query(value="select * from propad_emp_per_details where ep_per_emp_id=?1", nativeQuery = true)
	List<PropadEmpPerDetails> getOneRow(int emp_id);
	

	@Query(value = "SELECT ((CASE WHEN ep_per_addressproof IS NULL THEN 1 ELSE 0 END)+ (CASE WHEN ep_per_pp IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_per_pan IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_per_aadhar IS NULL THEN 1 ELSE 0 END)) AS sum_of_nulls FROM propad_emp_per_details where ep_per_emp_id=?1", nativeQuery = true)
	Integer countnull(int ep_per_emp_id);

	
	@Query(value="select * from propad_emp_per_details where ep_per_emp_id=?1", nativeQuery = true)
	List<PropadEmpPerDetails> findByEp_per_emp_id(Integer ep_per_emp_id);


	

}

