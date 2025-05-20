package com.shinhan.home.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "run_member_login_hist")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunMemberLoginHistEntity extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_idx")
    private Integer loginIdx;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "req_ip")
    private String reqIp;

    @Column(name = "session_id")
    private String sessionId;

    @Column(name = "req_mac_addr")
    private String reqMacAddr;

    @Column(name = "req_device")
    private String reqDevice;

    @Column(name = "login_result")
    private String loginResult;

    @Column(name = "return_msg")
    private String returnMsg;
}
