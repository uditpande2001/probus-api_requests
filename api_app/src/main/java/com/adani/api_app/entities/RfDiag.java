package com.adani.api_app.entities;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;


@Entity
@IdClass(RfDiagId.class)
public class RfDiag {

    @Id
    @Column
    private LocalDateTime serverTime;

    @Id
    @Column
    private Long nodeId;
    
    @Column
    private String gwId;

    @Column
    private String sinkId;

    
    @Column
    private int hopCount;

    @Column
    private String endPoint;
    
    @Column
    private int travelTime;
    
    @Column
    private String data;
    
    @Column
    private int nextHop;

    public RfDiag() {
    }

    public RfDiag(String gwId, String sinkId, Long nodeId, int hopCount, String endPoint, int travelTime) {
        super();
        this.gwId = gwId;
        this.sinkId = sinkId;
        this.nodeId = nodeId;
        this.hopCount = hopCount;
        this.endPoint = endPoint;
        this.setTravelTime(travelTime);
        this.serverTime = LocalDateTime.now();
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

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public LocalDateTime getServerTime() {
        return serverTime;
    }

    public void setServerTime(LocalDateTime serverTime) {
        this.serverTime = serverTime;
    }

    public int getHopCount() {
        return hopCount;
    }

    public void setHopCount(int hopCount) {
        this.hopCount = hopCount;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNextHop() {
        return nextHop;
    }

    public void setNextHop(int nextHop) {
        this.nextHop = nextHop;
    }
}