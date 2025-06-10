package com.shinhan.home.model.dto.querydto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.querydsl.core.annotations.QueryProjection;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.ShinhanUserTbDTO;
import com.shinhan.home.model.entity.ShinhanUserTbEntity;
import com.shinhan.home.util.ParseUtil;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class ShinhanUserTbQueryDTO extends CommonQueryDTO{

	private Integer userIdx;
    private String emailId;
    private String userNm;
    private String hdrIdx;
    private String trneeCstmrId;
    private String userPw;
    private String userPwSalt;
    private String userPhone;
    private String accessIp;
    private String phoneProvider;
    private String userGender;
    private String addrCode;
    private String addr1;
    private String addr2;
    private LocalDate birthday;
    private LocalDateTime lastPwChgDt;
    private LocalDateTime lastLoginDt;
    private String restFl;
    private LocalDateTime restResetDt;
    private String niceidCi;
    private String niceidDi;
    private LocalDateTime niceidAuthDt;
    private String resNo;
    private Integer companyIdx;
    private String regType;
    
    //로그인시 가져와야만 하는 칼럼 분류
    @QueryProjection
    public ShinhanUserTbQueryDTO(Integer userIdx, String emailId, String userPw, String userPwSalt,
                             String userNm, String userPhone, LocalDateTime lastPwChgDt,
                             LocalDateTime lastLoginDt, String restFl, String delYn) {
        this.userIdx = userIdx;
        this.emailId = emailId;
        this.userPw = userPw;
        this.userPwSalt = userPwSalt;
        this.userNm = userNm;
        this.userPhone = userPhone;
        this.lastPwChgDt = lastPwChgDt;
        this.lastLoginDt = lastLoginDt;
        this.restFl = restFl;
        this.setDelYn(delYn);
    }
    
    //DTO데이터 전환
    public static ShinhanUserTbQueryDTO fromDTO(ShinhanUserTbDTO dto) {
    	ShinhanUserTbQueryDTO queryDTO = new ShinhanUserTbQueryDTO();

        queryDTO.setUserIdx(ParseUtil.parseInt(dto.getUserIdx()));
        queryDTO.setEmailId(dto.getEmailId());
        queryDTO.setUserNm(dto.getUserNm());
        queryDTO.setHdrIdx(dto.getHdrIdx());
        queryDTO.setTrneeCstmrId(dto.getTrneeCstmrId());
        queryDTO.setUserPw(dto.getUserPw());
        queryDTO.setUserPwSalt(dto.getUserPwSalt());
        queryDTO.setUserPhone(dto.getUserPhone());
        queryDTO.setAccessIp(dto.getAccessIp());
        queryDTO.setPhoneProvider(dto.getPhoneProvider());
        queryDTO.setUserGender(dto.getUserGender());
        queryDTO.setAddrCode(dto.getAddrCode());
        queryDTO.setAddr1(dto.getAddr1());
        queryDTO.setAddr2(dto.getAddr2());
        queryDTO.setBirthday(ParseUtil.parseDate(dto.getBirthday()));
        queryDTO.setLastPwChgDt(ParseUtil.parseDateTime(dto.getLastPwChgDt()));
        queryDTO.setLastLoginDt(ParseUtil.parseDateTime(dto.getLastLoginDt()));
        queryDTO.setRestFl(dto.getRestFl());
        queryDTO.setRestResetDt(ParseUtil.parseDateTime(dto.getRestResetDt()));
        queryDTO.setDelYn(dto.getDelYn());
        queryDTO.setRegId(dto.getRegId());
        queryDTO.setRegDt(ParseUtil.parseDateTime(dto.getRegDt()));
        queryDTO.setModId(dto.getModId());
        queryDTO.setModDt(ParseUtil.parseDateTime(dto.getModDt()));
        queryDTO.setNiceidCi(dto.getNiceidCi());
        queryDTO.setNiceidDi(dto.getNiceidDi());
        queryDTO.setNiceidAuthDt(ParseUtil.parseDateTime(dto.getNiceidAuthDt()));
        queryDTO.setResNo(dto.getResNo());
        queryDTO.setCompanyIdx(ParseUtil.parseInt(dto.getCompanyIdx()));
        queryDTO.setRegType(dto.getRegType());

        return queryDTO;
    }
    
    //Entity에 데이터 삽입
    public ShinhanUserTbEntity toEntity() {
        return ShinhanUserTbEntity.builder()
            .userIdx(this.userIdx)
            .emailId(this.emailId)
            .userNm(this.userNm)
            .hdrIdx(this.hdrIdx)
            .trneeCstmrId(this.trneeCstmrId)
            .userPw(this.userPw)
            .userPwSalt(this.userPwSalt)
            .userPhone(this.userPhone)
            .accessIp(this.accessIp)
            .phoneProvider(this.phoneProvider)
            .userGender(this.userGender)
            .addrCode(this.addrCode)
            .addr1(this.addr1)
            .addr2(this.addr2)
            .birthday(this.birthday)
            .lastPwChgDt(this.lastPwChgDt)
            .lastLoginDt(this.lastLoginDt)
            .restFl(this.restFl)
            .restResetDt(this.restResetDt)
            .regId(this.getRegId())
            .regDt(this.getRegDt())
            .modId(this.getModId())
            .modDt(this.getModDt())
            .delYn(this.getDelYn())
            .niceidCi(this.niceidCi)
            .niceidDi(this.niceidDi)
            .niceidAuthDt(this.niceidAuthDt)
            .resNo(this.resNo)
            .companyIdx(this.companyIdx)
            .regType(this.regType)
            .build();
    }
}
