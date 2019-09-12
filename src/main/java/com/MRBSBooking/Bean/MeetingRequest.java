package com.MRBSBooking.Bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="meetingrequest")
//This is the meetingrequest table. All the major manipulations based on Requests are done on this table.
public class MeetingRequest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	@NotNull
	private String startdate;
	@Override
	public String toString() {
		return Messages.getString("MeetingRequest.0") + Id + Messages.getString("MeetingRequest.1") + startdate + Messages.getString("MeetingRequest.2") + enddate + Messages.getString("MeetingRequest.3") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ starttime + Messages.getString("MeetingRequest.4") + endtime + Messages.getString("MeetingRequest.5") + user + Messages.getString("MeetingRequest.6") + mrname + Messages.getString("MeetingRequest.7") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ resource + Messages.getString("MeetingRequest.8") + status + Messages.getString("MeetingRequest.9") + timestamp + Messages.getString("MeetingRequest.10") + datestamp + Messages.getString("MeetingRequest.11"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
	@NotNull
	private String enddate;
	@NotNull
	private String starttime;
	@NotNull
	private String endtime;
	@NotNull
	private String user;
	@NotNull
	private String mrname;
	private String resource;
	private String status;
	@NotNull
	private String timestamp;
	private String datestamp;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getMrname() {
		return mrname;
	}
	public void setMrname(String mrname) {
		this.mrname = mrname;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getDatestamp() {
		return datestamp;
	}
	public void setDatestamp(String datestamp) {
		this.datestamp = datestamp;
	}
	
	
}
