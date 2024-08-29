package com.cappack13.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int feedId;
    private int BId;
    private int cid;
    private int qualityOfService;
    private int politeness;
    private int protocolsfollowed;
    private int feedBack;
    
    
	public int getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(int feedBack) {
		this.feedBack = feedBack;
	}
	public int getFeedId() {
		return feedId;
	}
	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}
	public int getBId() {
		return BId;
	}
	public void setBId(int bId) {
		BId = bId;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getQualityOfService() {
		return qualityOfService;
	}
	public void setQualityOfService(int qualityOfService) {
		this.qualityOfService = qualityOfService;
	}
	public int getPoliteness() {
		return politeness;
	}
	public void setPoliteness(int politeness) {
		this.politeness = politeness;
	}
	public int getProtocolsfollowed() {
		return protocolsfollowed;
	}
	public void setProtocolsfollowed(int protocolsfollowed) {
		this.protocolsfollowed = protocolsfollowed;
	}
    
}
	
