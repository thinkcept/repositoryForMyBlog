package com.org.coop.bs.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.org.coop.bs.mapper.converter.AddressCC;
import com.org.coop.bs.mapper.converter.BranchLicenseDtlCC;
import com.org.coop.bs.mapper.converter.BranchRulesCC;
import com.org.coop.bs.mapper.converter.CountryStateDistCC;
import com.org.coop.bs.mapper.converter.ModuleRulePermissionCC;

@Configuration
@ComponentScan(value={"com.org.coop"})
public class DozerConfig {
	
	@Bean(name = "org.dozer.Mapper")
	  public DozerBeanMapper dozerBean() {
	    List mappingFiles = Arrays.asList(
	      "globalMapping.xml", 
	      "branchMapping.xml",
	      "addressMapping.xml",
	      "master/countryStateDistMapping.xml",
	      "master/moduleRulesAndPermissionMapping.xml",
	      "master/securityQuestionsMapping.xml"
	    );
	
	    Map<String, CustomConverter> customConvertersWithId = new HashMap<String, CustomConverter>();
	    customConvertersWithId.put("addressCC", getAddressCC());
	    customConvertersWithId.put("branchLicenseDtlCC", getBranchLicenseDtlCC());
	    customConvertersWithId.put("countryStateDistCC", getCountryStateDistCC());
	    customConvertersWithId.put("moduleRulePermissionCC", getModuleRulePermissionCC());
	    customConvertersWithId.put("branchRulesCC", getBranchRulesCC());
	    DozerBeanMapper dozerBean = new DozerBeanMapper();
	    dozerBean.setMappingFiles(mappingFiles);
	    dozerBean.setCustomConvertersWithId(customConvertersWithId);
	    return dozerBean;
	  }
	
	@Bean
	public CustomConverter getAddressCC() {
		CustomConverter cc = new AddressCC();
		return cc;
	}
	
	@Bean
	public CustomConverter getBranchLicenseDtlCC() {
		CustomConverter cc = new BranchLicenseDtlCC();
		return cc;
	}
	
	@Bean
	public CustomConverter getCountryStateDistCC() {
		CountryStateDistCC cc = new CountryStateDistCC();
		return cc;
	}
	
	@Bean
	public ModuleRulePermissionCC getModuleRulePermissionCC() {
		ModuleRulePermissionCC cc = new ModuleRulePermissionCC();
		return cc;
	}
	
	@Bean
	public BranchRulesCC getBranchRulesCC() {
		BranchRulesCC cc = new BranchRulesCC();
		return cc;
	}
}
