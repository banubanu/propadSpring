package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadInitiateEmployee;



public interface ServiceApi {
	List<PropadInitiateEmployee> getAll();
	PropadInitiateEmployee save(PropadInitiateEmployee  pie);

}
