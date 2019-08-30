package com.example.demo.Bean;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="resource")
//This is the resource table. All the manipulations based on  Resources are done in this table;
public class Resource {
	
	@Id
	private String resourcename;
	@NotNull
	private String resourcenumber;
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getResourcenumber() {
		return resourcenumber;
	}
	public void setResourcenumber(String resourcenumber) {
		this.resourcenumber = resourcenumber;
	}
	

}

