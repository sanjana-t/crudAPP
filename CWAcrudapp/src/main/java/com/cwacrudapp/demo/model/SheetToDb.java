package com.cwacrudapp.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SheetToDb {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionBankId;
	
	@Column(name="client_id")
	private Integer clientId;

	@Column(name="sub_client_id")
	private Integer subClientId;

	@Column(name="research_type_id")
	private Integer researchTypeId;
	
	@Column(name="sub_research_type_id")
	private Integer subResearchTypeId;

	@Column(name="industry_id")
	private Integer industryId;
	
	@Column(name="language_id")
	private Integer languageId;
	
	@Column(name="variation")
	private String variation;
	
	@Column(name="questionsection")
	private String questionSection;	
	
	@Column(name="questionselection")
	private String questionSelection;
	
	@Column(name="qid")
	private String qId;	
	
	@Column(name="qtype")
	private String qType;	
	
	@Column(name="qshorttitle")
	private String qShortTitle;	
	
	@Column(name="questiontext")
	private String questionText;	
	
	@Column(name="rowansweroptions")
	private String rowAnswerOptions;
	
	@Column(name="columnansweroptions")
	private String columnAnswerOptions;	
	
	@Column(name="programminginstruction")
	private String programmingInstruction;	
	
	@Column(name="insturction")
	private String insturction;	
	
	@Column(name="conditiontype")
	private String conditionType;
	
	public String getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}

	@Column(name="conditiontext")
	private String conditionText;

	@Column(name="question_category")
	private String questionCategory; 
	
	public Integer getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(Integer questionBankId) {
		this.questionBankId = questionBankId;
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

	public Integer getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Integer industryId) {
		this.industryId = industryId;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getVariation() {
		return variation;
	}

	public void setVariation(String variation) {
		this.variation = variation;
	}

	public String getQuestionSection() {
		return questionSection;
	}

	public void setQuestionSection(String questionSection) {
		this.questionSection = questionSection;
	}

	public String getQuestionSelection() {
		return questionSelection;
	}

	public void setQuestionSelection(String questionSelection) {
		this.questionSelection = questionSelection;
	}

	public String getqId() {
		return qId;
	}

	public void setqId(String qId) {
		this.qId = qId;
	}

	public String getqType() {
		return qType;
	}

	public void setqType(String qType) {
		this.qType = qType;
	}

	public String getqShortTitle() {
		return qShortTitle;
	}

	public void setqShortTitle(String qShortTitle) {
		this.qShortTitle = qShortTitle;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getRowAnswerOptions() {
		return rowAnswerOptions;
	}

	public void setRowAnswerOptions(String rowAnswerOptions) {
		this.rowAnswerOptions = rowAnswerOptions;
	}

	public String getColumnAnswerOptions() {
		return columnAnswerOptions;
	}

	public void setColumnAnswerOptions(String columnAnswerOptions) {
		this.columnAnswerOptions = columnAnswerOptions;
	}

	public String getProgrammingInstruction() {
		return programmingInstruction;
	}

	public void setProgrammingInstruction(String programmingInstruction) {
		this.programmingInstruction = programmingInstruction;
	}

	public String getInsturction() {
		return insturction;
	}

	public void setInsturction(String insturction) {
		this.insturction = insturction;
	}

	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}

	public String getConditionText() {
		return conditionText;
	}

	public void setConditionText(String conditionText) {
		this.conditionText = conditionText;
	}
	
	
	

}
