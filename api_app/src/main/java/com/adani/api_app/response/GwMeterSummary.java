package com.adani.api_app.response;

public class GwMeterSummary {
	
	
	private String meterNumber;
	
	private String nodeId;
	
	

	
	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public GwMeterSummary(String meterNumber, String nodeId) {
		super();
		this.meterNumber = meterNumber;
		this.nodeId = nodeId;
	}
	
	
	
	
	
	
	
	
	
	

}
