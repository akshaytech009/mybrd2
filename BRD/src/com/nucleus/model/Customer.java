package com.nucleus.model;

import java.io.Serializable;

public class Customer implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String code; 
	private String name;
	private String address1;
	private String address2;
	private String pincode;
	private String email;
	private String contact;
	private String pcp;
	private String record;
	private String flag;
	private String createDate;
	private String createdBy;
	private String modifiedDate;
	private String modifiedBy;
	private String authorizedDate;
	private String authorizedBy;
	private String uname;
	public String toString() 
	{
		return "Customerdetail [id=" + id + ", code=" + code + ", name=" + name
				+ ", Address1=" + address1 + ", Address2=" + address2 + ", pincode" + pincode
				+ ",email=" + email + ", contact=" + contact + ", Primary COntact PErson=" + pcp
				+ ", record=" + record + ", flag=" + flag + ", Create Date=" +createDate+", Created By="+createdBy+ "]" ;

	}
	public Customer() 
	{
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPcp() {
		return pcp;
	}
	public void setPcp(String pcp) {
		this.pcp = pcp;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getAuthorizedDate() {
		return authorizedDate;
	}
	public void setAuthorizedDate(String authorizedDate) {
		this.authorizedDate = authorizedDate;
	}
	public String getAuthorizedBy() {
		return authorizedBy;
	}
	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}

}


