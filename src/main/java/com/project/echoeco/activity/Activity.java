package com.project.echoeco.activity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.project.echoeco.common.BaseProject;
import com.project.echoeco.projectImg.ProjectImg;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@ToString
public class Activity extends BaseProject {
	
	private Integer goalCnt;

	private LocalDateTime deadLine;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "projectImg_id")
	private List<ProjectImg> activityImg;

}
