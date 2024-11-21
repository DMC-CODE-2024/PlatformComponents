package com.gl.ceir.config.model.audit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ModulesAuditTrail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int executionTime;
    private int statusCode;
    private String status;
    private String errorMessage;
    private String moduleName;
    private String featureName;
    private String info;
    private String serverName;
    private String action;
    private int failureCount;
    private int count;

//    @CreationTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
//    private LocalDateTime createdOn;

    public ModulesAuditTrail() {
    }

}
