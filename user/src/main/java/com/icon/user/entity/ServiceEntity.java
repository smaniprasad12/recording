package com.icon.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="Service_table")
public class ServiceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String date;
	private String servicename;
	private int serviceprice;
	

}
