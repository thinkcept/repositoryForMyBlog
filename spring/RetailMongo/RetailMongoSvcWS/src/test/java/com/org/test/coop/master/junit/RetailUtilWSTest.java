package com.org.test.coop.master.junit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.coop.bs.config.CustomerDozerConfig;
import com.org.coop.retail.data.entities.RetailData;
import com.org.coop.society.data.customer.transaction.config.RetailDataAppConfig;
import com.org.coop.society.data.transaction.config.DataAppConfig;
import com.org.test.coop.junit.JunitTestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = "com.org.test.coop"/*, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = DataAppConfig.class) }*/)
@EnableAutoConfiguration(exclude = { DataAppConfig.class})
@ContextHierarchy({
	  @ContextConfiguration(classes={RetailDataAppConfig.class, CustomerDozerConfig.class})
})
@WebAppConfiguration
public class RetailUtilWSTest {
	private static final Logger logger = Logger.getLogger(RetailUtilWSTest.class);
	
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext wac;
	
	private ObjectMapper om = null;
	
	
	@Before
	public void runBefore() {
		try {
			this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			om = new ObjectMapper();
			om.setSerializationInclusion(Include.NON_NULL);
			om.setDateFormat(df);
		} catch (Exception e) {
			logger.error("Error while initializing: ", e);
		}
	}
	

	@Test
	public void getMaterialSequence() {
		try {
			MvcResult result = this.mockMvc.perform(get("/rest/sequence?document=branch")
					 .contentType("application/json").header("Authorization", "Basic " + Base64.getEncoder().encodeToString("ashish:ashish".getBytes()))
					).andExpect(status().isOk())
					.andExpect(content().contentType("application/json"))
					.andReturn();
				
			RetailData retailData = getRetailData(result,  "outputJson/sequence.json");
			if(retailData.getErrorMsg() != null) {
				return;
			}
		} catch(Exception e) {
			logger.error("Error while adding material master", e);
		}
	}
	
	
	
	private RetailData getRetailData(MvcResult result)
			throws UnsupportedEncodingException, IOException,
			JsonParseException, JsonMappingException {
		String json = result.getResponse().getContentAsString();
		RetailData createBranchBean = om.readValue(json, RetailData.class);
		return createBranchBean;
	}
	
	private RetailData getRetailData(MvcResult result, String path)
			throws UnsupportedEncodingException, IOException,
			JsonParseException, JsonMappingException {
		RetailData createBranchBean = getRetailData(result);
		JunitTestUtil.writeJSONToFile(createBranchBean, path);
		return createBranchBean;
	}
}
