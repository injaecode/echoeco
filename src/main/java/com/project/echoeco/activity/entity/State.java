package com.project.echoeco.activity.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idx;
	
	@Column(unique = true)
	private String state;
	
	@ManyToOne
	private City city;
	
	@OneToMany(mappedBy = "state")
	private List<Activity> activity;
	
}
