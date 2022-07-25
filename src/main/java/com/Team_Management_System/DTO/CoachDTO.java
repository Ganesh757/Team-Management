package com.Team_Management_System.DTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="coach")
public class CoachDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String coach_name;
	
	private String grade;
	
	private double age;
	
	private double coach_package;
	
	private String specilization;
	
//	@ManyToMany(mappedBy = "coach")
//	List<PlayerDTO> players;
	
}
