package com.prodapt.propad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.PropadInitiateEmployee;

@Repository
public interface ServiceRepository extends JpaRepository<PropadInitiateEmployee, Integer> {

}
