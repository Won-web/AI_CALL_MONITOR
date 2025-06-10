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
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.shinhan.home.model.dto.querydto.ShinhanUserTbQueryDTO;

@Entity
@Table(name = "shinhan_user_tb")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShinhanUserTbEntity extends CommonEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
	@Setter(AccessLevel.NONE)
    private Integer userIdx;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "user_nm")
    private String userNm;

    @Column(name = "hdr_idx")
    private String hdrIdx;

    @Column(name = "trnee_cstmr_id")
    private String trneeCstmrId;

    @Column(name = "user_pw")
    private String userPw;

    @Column(name = "user_pw_salt")
    private String userPwSalt;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "access_ip")
    private String accessIp;

    @Column(name = "phone_provider")
    private String phoneProvider;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "addr_code")
    private String addrCode;

    @Column(name = "addr1")
    private String addr1;

    @Column(name = "addr2")
    private String addr2;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "last_pw_chg_dt")
    private LocalDateTime lastPwChgDt;

    @Column(name = "last_login_dt")
    private LocalDateTime lastLoginDt;

    @Column(name = "rest_fl")
    private String restFl;

    @Column(name = "rest_reset_dt")
    private LocalDateTime restResetDt;

    @Column(name = "niceid_ci")
    private String niceidCi;

    @Column(name = "niceid_di")
    private String niceidDi;

    @Column(name = "niceid_auth_dt")
    private LocalDateTime niceidAuthDt;

    @Column(name = "res_no")
    private String resNo;

    @Column(name = "company_idx")
    private Integer companyIdx;

    @Column(name = "reg_type")
    private String regType;
    
    public void updateFromQueryDto(ShinhanUserTbQueryDTO dto) {
    	
    	 // 기본키 수정 방어
        if (!this.userIdx.equals(dto.getUserIdx())) {
            throw new IllegalArgumentException("PrimaryKey userIdx는 변경할 수 없습니다.");
        }

        // CommonEntity 필드
        if (dto.getRegId() != null) this.setRegId(dto.getRegId());
        if (dto.getRegDt() != null) this.setRegDt(dto.getRegDt());
        if (dto.getModId() != null) this.setModId(dto.getModId());
        if (dto.getModDt() != null) this.setModDt(dto.getModDt());
        if (dto.getDelYn() != null) this.setDelYn(dto.getDelYn());

        if (dto.getEmailId() != null) this.emailId = dto.getEmailId();
        if (dto.getUserNm() != null) this.userNm = dto.getUserNm();
        if (dto.getHdrIdx() != null) this.hdrIdx = dto.getHdrIdx();
        if (dto.getTrneeCstmrId() != null) this.trneeCstmrId = dto.getTrneeCstmrId();
        if (dto.getUserPw() != null) this.userPw = dto.getUserPw();
        if (dto.getUserPwSalt() != null) this.userPwSalt = dto.getUserPwSalt();
        if (dto.getUserPhone() != null) this.userPhone = dto.getUserPhone();
        if (dto.getAccessIp() != null) this.accessIp = dto.getAccessIp();
        if (dto.getPhoneProvider() != null) this.phoneProvider = dto.getPhoneProvider();
        if (dto.getUserGender() != null) this.userGender = dto.getUserGender();
        if (dto.getAddrCode() != null) this.addrCode = dto.getAddrCode();
        if (dto.getAddr1() != null) this.addr1 = dto.getAddr1();
        if (dto.getAddr2() != null) this.addr2 = dto.getAddr2();
        if (dto.getBirthday() != null) this.birthday = dto.getBirthday();
        if (dto.getLastPwChgDt() != null) this.lastPwChgDt = dto.getLastPwChgDt();
        if (dto.getLastLoginDt() != null) this.lastLoginDt = dto.getLastLoginDt();
        if (dto.getRestFl() != null) this.restFl = dto.getRestFl();
        if (dto.getRestResetDt() != null) this.restResetDt = dto.getRestResetDt();
        if (dto.getNiceidCi() != null) this.niceidCi = dto.getNiceidCi();
        if (dto.getNiceidDi() != null) this.niceidDi = dto.getNiceidDi();
        if (dto.getNiceidAuthDt() != null) this.niceidAuthDt = dto.getNiceidAuthDt();
        if (dto.getResNo() != null) this.resNo = dto.getResNo();
        if (dto.getCompanyIdx() != null) this.companyIdx = dto.getCompanyIdx();
        if (dto.getRegType() != null) this.regType = dto.getRegType();
    }
    
}
