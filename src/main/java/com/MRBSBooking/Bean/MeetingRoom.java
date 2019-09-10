package com.MRBSBooking.Bean;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="meetingroom")
//This is the meetingroom table. All the manipulations based on Meeting Room are done on this table.
public class MeetingRoom {
	
	@Id
	private String meetingroomname;
	@NotNull
	private String meetingroomnumber;
	public String getMeetingroomname() {
		return meetingroomname;
	}
	public void setMeetingroomname(String meetingroomname) {
		this.meetingroomname = meetingroomname;
	}
	public String getMeetingroomnumber() {
		return meetingroomnumber;
	}
	public void setMeetingroomnumber(String meetingroomnumber) {
		this.meetingroomnumber = meetingroomnumber;
	}
	

}
