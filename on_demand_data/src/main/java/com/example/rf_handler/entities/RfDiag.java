package com.example.rf_handler.entities;

import jakarta.persistence.*;



@Entity
@Table(name = "rf_diag")
public class RfDiag {

    @EmbeddedId
    private RfDiagId id;

    @Column(name = "gw_id")
    private String gwId;

    @Column(name = "sink_id")
    private String sinkId;

    @Column(name = "hop_count")
    private Integer hopCount;

    @Column(name = "end_point")
    private String endPoint;

    @Column(name = "travel_time")
    private Integer travelTime;

    @Column(name = "data")
    private String data;

    @Column(name = "next_hop")
    private Integer nextHop;

	public RfDiagId getId() {
		return id;
	}

	public void setId(RfDiagId id) {
		this.id = id;
	}

	public String getGwId() {
		return gwId;
	}

	public void setGwId(String gwId) {
		this.gwId = gwId;
	}

	public String getSinkId() {
		return sinkId;
	}

	public void setSinkId(String sinkId) {
		this.sinkId = sinkId;
	}

	public Integer getHopCount() {
		return hopCount;
	}

	public void setHopCount(Integer hopCount) {
		this.hopCount = hopCount;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public Integer getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(Integer travelTime) {
		this.travelTime = travelTime;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getNextHop() {
		return nextHop;
	}

	public void setNextHop(Integer nextHop) {
		this.nextHop = nextHop;
	}


}

