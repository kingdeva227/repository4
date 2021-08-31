package com.deva.resume.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="resume")
public class Resume {
	@Id
	@Column(name="resume_id_col")
	@GeneratedValue
	private Integer id;
	
	@Column(name="resume_name_col")
	private String name;
	
	@Column(name="resume_email_col")
	private String email;
	
	@Column(name="resume_mobileNumber_col")
	private String mobileNumber;
	
	@Column(name="resume_careerObjective_col")
	private String careerObjective;
	@Column(name="resume_course1_col")
	private String course1;

	@Column(name="resume_institute1_col")
	private String institute1;

	@Column(name="resume_university1_col")
	private String university1;

	@Column(name="resume_duration1_col")
	private String duration1;

	@Column(name="resume_percentage1_col")
	private String percentage1;

	@Column(name="resume_course2_col")
	private String course2;

	@Column(name="resume_institute2_col")
	private String institute2;

	@Column(name="resume_university2_col")
	private String university2;

	@Column(name="resume_duration2_col")
	private String duration2;

	@Column(name="resume_percentage2_col")
	private String percentage2;

	@Column(name="resume_course3_col")
	private String course3;

	@Column(name="resume_institute3_col")
	private String institute3;

	@Column(name="resume_university3_col")
	private String university3;

	@Column(name="resume_duration3_col")
	private String duration3;

	@Column(name="resume_percentage3_col")
	private String percentage3;
	


@Column(name="resume_technicalSkill_col")
private String technicalSkill;

	
@Column(name="resume_languages_col")
private String languages;

@Column(name="resume_dateOfBirth_col")
private String dateOfBirth;

@Column(name="resume_fatherName_col")
private String fatherName;

@Column(name="resume_strengths_col")
private String strengths;


}
