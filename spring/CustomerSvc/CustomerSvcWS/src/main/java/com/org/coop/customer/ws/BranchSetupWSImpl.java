package com.org.coop.customer.ws;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.coop.admin.servicehelper.BranchSetupServiceHelperImpl;
import com.org.coop.canonical.beans.UIModel;

@RestController
@RequestMapping("/rest")
public class BranchSetupWSImpl {
	
	private static final Logger log = Logger.getLogger(BranchSetupWSImpl.class); 
	
	@Autowired
	private BranchSetupServiceHelperImpl branchSetupServiceImpl;
	
	
	@RequestMapping(value = "/getBranch", method = RequestMethod.GET, headers="Accept=application/json",produces="application/json")
	public UIModel getBranch(@RequestParam(value = "branchId",required = true,defaultValue = "0") Integer branchId) {
		UIModel uiModel = new UIModel();
		try {
			uiModel = branchSetupServiceImpl.getBranch(branchId);
		} catch (Exception e) {
			log.error("Error Retrieving branch by branch Id", e);
			uiModel.setErrorMsg("Error Retrieving branch by branch Id: " + branchId);
		}
		return uiModel;
	}
	
}
