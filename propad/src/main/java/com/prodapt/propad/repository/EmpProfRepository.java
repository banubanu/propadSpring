package com.prodapt.propad.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.PropadEmpProfDetails;

@Repository
public interface EmpProfRepository extends JpaRepository<PropadEmpProfDetails, Integer> {
	@Query(value = "SELECT ((CASE WHEN ep_service_cert1 IS NULL THEN 1 ELSE 0 END)+ (CASE WHEN ep_service_cert2 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_service_cert3 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_payslip1 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_payslip2 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_payslip3 IS NULL THEN 1 ELSE 0 END)) AS sum_of_nulls FROM propad_emp_prof_details where ep_emp_id=?1", nativeQuery = true)
	public Integer countnull(Integer ep_emp_id);
	
	@Query(value="select * from propad_emp_prof_details where ep_emp_id=?1", nativeQuery = true)
	public List<PropadEmpProfDetails> getOneRow(int emp_id);
	
	@Query(value="select * from propad_emp_prof_details where ep_emp_id=?1", nativeQuery = true)
	public List<PropadEmpProfDetails> findByEp_emp_id(int ep_emp_id);

}

