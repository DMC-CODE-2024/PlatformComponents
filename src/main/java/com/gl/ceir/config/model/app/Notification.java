package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@DynamicInsert
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String channelType;
    private String message;
    private String subject;
    private String email;
    private String msisdn;
    private String operatorName;
    private String msgLang;
    private Integer checkImeiId;
    private String attachment;
    private String featureTxnId;

    @Column(name = "sms_scheduled_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deliveryDateTime;


    public Notification() {
    }

}
