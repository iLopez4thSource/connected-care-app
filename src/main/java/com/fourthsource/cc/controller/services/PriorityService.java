package com.fourthsource.cc.controller.services;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fourthsource.cc.domain.PrioritySetEntity;
import com.fourthsource.cc.domain.PrioritySetRuleEntity;
import com.fourthsource.cc.domain.Message;
import com.fourthsource.cc.domain.properties.CommonProperties;
//import com.fourthsource.cc.domain.requests.RequestAddIcd10Programs;
//import com.fourthsource.cc.domain.requests.RequestIcd10Programs;
import com.fourthsource.cc.domain.requests.RequestPrioritySet;
import com.fourthsource.cc.model.services.PrioritySetManager;
//import com.fourthsource.cc.model.services.Icd10ProgramsManager;
//import com.fourthsource.cc.model.services.PrioritySetManager;

@Controller
@RequestMapping(value="/services")
public class PriorityService  {

	private final static Logger logger = LoggerFactory.getLogger(PriorityService.class);

	@Autowired
	private CommonProperties commonProperties;

	
	//@Autowired
	//private PrioritySetRuleManager Manager;
	
	@Autowired
	private PrioritySetManager prioritySetManager;

	
	@RequestMapping(value="/addPriority", method=RequestMethod.POST)
    private @ResponseBody Message addPriority(@RequestBody RequestPrioritySet request) {
		logger.debug("Service addIcd10Programs()");
		Message response = null;
		
		/*try {
			Icd10Entity icd10Entity = icd10Manager.getIcd10ByIcdCode(request.getIcdCode());
			
			Icd10ProgramsEntity icd10ProgramsEntity = new Icd10ProgramsEntity();
			
			icd10ProgramsEntity.setIcdCodeId(icd10Entity);
			icd10ProgramsEntity.setRxAdherence(request.getRxAdherence());
			icd10ProgramsEntity.setApptAdherence(request.getApptAdherence());
			icd10ProgramsEntity.setEducation(request.getEducation());
			
			icd10ProgramsManager.saveIcd10(icd10ProgramsEntity);
			
			response = commonProperties.getSuccessMessage();
		} catch(HibernateException e) {
			response = commonProperties.getTransactionException();
			logger.error(e.getMessage(), e);
		}*/

		return response;
    }
	
	                        
	/*@RequestMapping(value="/upDateIcd10Programs", method=RequestMethod.POST)
    private @ResponseBody Message upDateIcd10Programs(@RequestBody RequestIcd10Programs request) { //RequestIcd10Programs request
		logger.debug("Service upDateIcd10Programs()");
		Message response = null;
		
		try {
			Icd10ProgramsEntity icd10ProgramsEntity = icd10ProgramsManager.getIcd10ProgramsById(request.getIcd10ProgramsId()); //request.getIcd10ProgramsId()
			
			//icd10ProgramsEntity.setIcdCodeId(icd10Entity);
			icd10ProgramsEntity.setRxAdherence(request.getRxAdherence());
			icd10ProgramsEntity.setApptAdherence(request.getApptAdherence());
			icd10ProgramsEntity.setEducation(request.getEducation());
			
			icd10ProgramsManager.upDateIcd10(icd10ProgramsEntity);
			
			response = commonProperties.getSuccessMessage();
		} catch(HibernateException e) {
			response = commonProperties.getTransactionException();
			logger.error(e.getMessage(), e);
		}

		return response;
    }*/

	/*@RequestMapping(value="/deleteIcd10Programs", method=RequestMethod.POST)
    private @ResponseBody Message deleteIcd10Programs(@RequestBody RequestIcd10Programs request) {
		logger.debug("Service deleteIcd10Programs()");
		Message response = null;
		
		try {
			Icd10ProgramsEntity icd10ProgramsEntity = icd10ProgramsManager.getIcd10ProgramsById(request.getIcd10ProgramsId()); //request.getIcd10ProgramsId()
			icd10ProgramsManager.deleteIcd10(icd10ProgramsEntity);
			
			response = commonProperties.getSuccessMessage();
		} catch(HibernateException e) {
			response = commonProperties.getTransactionException();
			logger.error(e.getMessage(), e);
		}

		return response;
    }*/
	
	
}
