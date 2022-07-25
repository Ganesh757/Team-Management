package com.Team_Management_System.DTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="staff")
public class StaffDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String staff_name;
	
	private String grade;
	
	private double age;
	
	private double staff_package;
	
	
	
}
