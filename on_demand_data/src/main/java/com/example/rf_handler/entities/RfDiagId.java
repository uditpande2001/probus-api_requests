package com.example.rf_handler.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.*;

@Embeddable
public class RfDiagId implements Serializable {

    @Column(name = "node_id")
    private Integer nodeId;

    @Column(name = "server_time")
    private Timestamp serverTime;
  
    // Remember to implement equals() and hashCode() methods
    // They are essential when using composite keys

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RfDiagId that = (RfDiagId) o;
        return Objects.equals(nodeId, that.nodeId) &&
                Objects.equals(serverTime, that.serverTime);
    }

    public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public Timestamp getServerTime() {
		return serverTime;
	}

	public void setServerTime(Timestamp serverTime) {
		this.serverTime = serverTime;
	}

	@Override
    public int hashCode() {
        return Objects.hash(nodeId, serverTime);
    }
}
