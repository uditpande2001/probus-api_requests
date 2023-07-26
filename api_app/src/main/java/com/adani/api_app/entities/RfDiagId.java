package com.adani.api_app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class RfDiagId implements Serializable {

    private static final long serialVersionUID = -1761486766497596906L;

    private int nodeId;

    private LocalDateTime serverTime;

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public LocalDateTime getServerTime() {
        return serverTime;
    }

    public void setServerTime(LocalDateTime serverTime) {
        this.serverTime = serverTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeId, serverTime);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RfDiagId other = (RfDiagId) obj;
        return nodeId == other.nodeId && Objects.equals(serverTime, other.serverTime);
    }

}
