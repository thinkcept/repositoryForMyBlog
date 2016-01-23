package com.org.coop.canonical.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BranchBean {
	private int branchId;
	private int parentId;
	private String bankName;
	private String branchName;
	private String ifscCode;
	private String micrCode;
	private String email1;
	private String email2;
	private String phone1;
	private String phone2;
	private Date startDate;
	private Date endDate;
	private String createUser;
	private String updateUser;
	private String dbName;
	private String contextRoot;
	// This variable indicates if the branch is still active
	private boolean isBranchActive;
	// This variable shows how many days the license is remaining
	private int licenseRemaining;
	// This variable shows the grace period. This value is configured in DB
	private int gracePeriod;
	// This variable shows how many days before the license got over
	private int licenseOverDays;
	
	private List<AddressBean> addresses = new ArrayList<AddressBean>();
	
	private List<BranchLicenseDtlsBean> branchLicenseDtlsBeans = new ArrayList<BranchLicenseDtlsBean>();
	
	private List<BranchRuleBean> branchRuleBeans = new ArrayList<BranchRuleBean>();

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getMicrCode() {
		return micrCode;
	}

	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<AddressBean> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressBean> addresses) {
		this.addresses = addresses;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getContextRoot() {
		return contextRoot;
	}

	public void setContextRoot(String contextRoot) {
		this.contextRoot = contextRoot;
	}

	public boolean isBranchActive() {
		return isBranchActive;
	}

	public void setBranchActive(boolean isBranchActive) {
		this.isBranchActive = isBranchActive;
	}

	public int getLicenseRemaining() {
		return licenseRemaining;
	}

	public void setLicenseRemaining(int licenseRemaining) {
		this.licenseRemaining = licenseRemaining;
	}

	public int getGracePeriod() {
		return gracePeriod;
	}

	public void setGracePeriod(int gracePeriod) {
		this.gracePeriod = gracePeriod;
	}

	public int getLicenseOverDays() {
		return licenseOverDays;
	}

	public void setLicenseOverDays(int licenseOverDays) {
		this.licenseOverDays = licenseOverDays;
	}

	public List<BranchLicenseDtlsBean> getBranchLicenseDtlsBeans() {
		return branchLicenseDtlsBeans;
	}

	public void setBranchLicenseDtlsBeans(
			List<BranchLicenseDtlsBean> branchLicenseDtlsBeans) {
		this.branchLicenseDtlsBeans = branchLicenseDtlsBeans;
	}

	public List<BranchRuleBean> getBranchRuleBeans() {
		return branchRuleBeans;
	}

	public void setBranchRuleBeans(List<BranchRuleBean> branchRuleBeans) {
		this.branchRuleBeans = branchRuleBeans;
	}
}
