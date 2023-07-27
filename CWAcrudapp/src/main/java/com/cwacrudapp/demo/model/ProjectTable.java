package com.cwacrudapp.demo.model;

import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;



//@TypeDefs({
//    @TypeDef(
//        name = "string-array", 
//        typeClass = StringArrayType.class
//    )
//})

@Entity
@Table(name = "Project_Table")

public class ProjectTable {

	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long projectId;
	
	@Column(name="project_number")
	private long projectNumber;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="client_id")
	private Integer clientId;
	
	@Column(name="sub_client_id")
	private Integer subClientId;
	
	@Column(name="study_type_id")
	private Integer studyTypeId;
	
	@Column(name="research_type_id")
	private Integer researchTypeId;
	
	@Column(name="sub_research_type_id")
	private Integer subResearchTypeId;
	
	
    
//	@ElementCollection(targetClass=Integer.class)
//	@Type(type = "string-array")
//	@Column(
//        name = "country_id",
//        columnDefinition="text[]"
//    )
//    private List<Integer> countryId;
//	int i;
	
	@Column(name="coutry_id")
	private ArrayList<Integer> countryId =  new ArrayList<Integer>();
	
	public ArrayList<Integer> getCountryId() {
		return countryId;
	}

	public void setCountryId(ArrayList<Integer> countryId) {
		this.countryId = countryId;
	}

	@Column(name="language_id")
	private Integer languageId;
	
	@Column(name="industry_id")
	private Integer industryId;
	
	@Column(name="audience_id")
	private Integer audienceId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_on")
	private LocalDateTime createdOn;
	
	@Column(name="soft_delete")
	private Boolean softDelete;  
	
	@Column(name="last_updated_on")
	private LocalDateTime lastUpdatedOn;
	
	@Column(name="last_updated_by")
	private String lastUpdatedBy;

	
//	public List<Integer> getCountryId() {
//		return countryId;
//	}
//
//	public void setCountryId(List<Integer> countryId) {
//		this.countryId = countryId;
//	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public long getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(long projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getSubClientId() {
		return subClientId;
	}

	public void setSubClientId(Integer subClientId) {
		this.subClientId = subClientId;
	}

	public Integer getStudyTypeId() {
		return studyTypeId;
	}

	public void setStudyTypeId(Integer studyTypeId) {
		this.studyTypeId = studyTypeId;
	}

	public Integer getResearchTypeId() {
		return researchTypeId;
	}

	public void setResearchTypeId(Integer researchTypeId) {
		this.researchTypeId = researchTypeId;
	}

	public Integer getSubResearchTypeId() {
		return subResearchTypeId;
	}

	public void setSubResearchTypeId(Integer subResearchTypeId) {
		this.subResearchTypeId = subResearchTypeId;
	}


	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public Integer getAudienceId() {
		return audienceId;
	}

	public void setAudienceId(Integer audienceId) {
		this.audienceId = audienceId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Boolean getSoftDelete() {
		return softDelete;
	}

	public void setSoftDelete(Boolean softDelete) {
		this.softDelete = softDelete;
	}

	public LocalDateTime getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	
	
	
	
}
