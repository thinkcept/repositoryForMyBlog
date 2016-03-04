package com.org.coop.customer.ws;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.coop.canonical.beans.UIModel;
import com.org.coop.retail.data.entities.MaterialMaster;
import com.org.coop.retail.data.entities.RetailData;
import com.org.coop.retail.data.repositories.MaterialMasterRepository;
import com.org.coop.retail.service.RetailMasterDataSetupServiceImpl;

@RestController
@RequestMapping("/rest")
public class MasterDataSetupWSImpl {
	
	private static final Logger log = Logger.getLogger(MasterDataSetupWSImpl.class); 
	
	@Autowired
	private RetailMasterDataSetupServiceImpl masterDataSetupServiceImpl;
	@RequestMapping(value = "/masterData", method = RequestMethod.GET, headers="Accept=application/json",produces="application/json")
	public UIModel getBranch(@RequestParam(value = "branchId",required = true,defaultValue = "0") Integer branchId) {
		UIModel uiModel = new UIModel();
		try {
//			uiModel = branchSetupServiceImpl.getBranch(branchId);
			deleteMaterials();
			addMaterial();
			addAnotherMaterial();
			updateMaterial();
			MaterialMaster mm = getMaterial();
		} catch (Exception e) {
			log.error("Error Retrieving branch by branch Id", e);
			uiModel.setErrorMsg("Error Retrieving branch by branch Id: " + branchId);
		}
		return uiModel;
	}
	
	@RequestMapping(value = "/masterData", method = RequestMethod.POST, headers="Accept=application/json",produces="application/json")
	public RetailData saveMasterData(@RequestBody RetailData retailData) {
		RetailData retail = new RetailData();
		try {
			retail = masterDataSetupServiceImpl.saveMasterData(retailData);
		} catch (Exception e) {
			log.error("Error while saving master data", e);
			retail.setErrorMsg("Error while saving master data");
		}
		return retail;
	}
	
	
	@Autowired
	private MaterialMasterRepository materialMasterRepository;
	
	public void deleteMaterials() {
		List<MaterialMaster> materials = materialMasterRepository.findAll();
		materialMasterRepository.delete(materials);
	}
	
	public void addMaterial() {
		MaterialMaster mm = new MaterialMaster();
		mm.setId("1");
		mm.setMaterialId(1L);
		mm.setName("Maxx Engine Oil");
		materialMasterRepository.save(mm);
	}
	
	public void addAnotherMaterial() {
		MaterialMaster mm = new MaterialMaster();
		mm.setId("2");
		mm.setMaterialId(2L);
		mm.setName("Castrol Engine Oil");
		materialMasterRepository.save(mm);
	}
	
	public void updateMaterial() {
		MaterialMaster mm = materialMasterRepository.findOne("1");
		mm.setName("Maxx Engine Oil1");
		materialMasterRepository.save(mm);
	}
	
	public MaterialMaster getMaterial() {
		MaterialMaster mm = materialMasterRepository.findByMaterialId(1L);
		return mm;
	}
}