package com.gl.ceir.config.model.app;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "sys_generated_alert")
public class RunningAlertDb implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alertId;
    private String description;
    private String priority;
    private String ip;
    private String serverName;
    private String featureName;
    @Column(name = "remark")
    private String remarks;
    private String txnId;
    private String username;


    public RunningAlertDb() {
    }

    @Transient
    private String alertMessage, alertProcess;

    public RunningAlertDb(String description, String alertId) {
        this.description = description;
        this.alertId = alertId;
    }

    public RunningAlertDb(String alertId, String alertMessage, String alertProcess, String description, String featureName, String ip, String priority, String remarks, String serverName, String txnId, String username) {
        this.alertId = alertId;
        this.alertMessage = alertMessage;
        this.alertProcess = alertProcess;
        this.description = description;
        this.featureName = featureName;
        this.ip = ip;
        this.priority = priority;
        this.remarks = remarks;
        this.serverName = serverName;
        this.txnId = txnId;
        this.username = username;
    }


    @Override
    public String toString() {
        return "RunningAlertDb{" +
                "alertId='" + alertId + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", ip='" + ip + '\'' +
                ", serverName='" + serverName + '\'' +
                ", featureName='" + featureName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", txnId='" + txnId + '\'' +
                ", username='" + username + '\'' +
                ", alertMessage='" + alertMessage + '\'' +
                ", alertProcess='" + alertProcess + '\'' +
                '}';
    }
}
