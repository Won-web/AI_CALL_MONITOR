package com.shinhan.home.model.dto;

import lombok.experimental.SuperBuilder;

import com.shinhan.home.model.dto.querydto.RunUserTbQueryDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import com.shinhan.home.util.ParseUtil;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
public class RunUserTbDTO extends CommonDTO{
	
	private String userIdx;
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
    private String birthday;
    private String lastPwChgDt;
    private String lastLoginDt;
    private String restFl;
    private String restResetDt;
    private String niceidCi;
    private String niceidDi;
    private String niceidAuthDt;
    private String sessionId;
    private String resNo;
    private String companyIdx;
    private String regType;
    
    // QueryDTO를 비즈니스로직용 DTO로 전환
    public static RunUserTbDTO fromQueryDTO(RunUserTbQueryDTO queryDTO) {
        RunUserTbDTO dto = new RunUserTbDTO();

        dto.setUserIdx(queryDTO.getUserIdx() != null ? String.valueOf(queryDTO.getUserIdx()) : null);
        dto.setEmailId(queryDTO.getEmailId());
        dto.setUserNm(queryDTO.getUserNm());
        dto.setHdrIdx(queryDTO.getHdrIdx());
        dto.setTrneeCstmrId(queryDTO.getTrneeCstmrId());
        dto.setUserPw(queryDTO.getUserPw());
        dto.setUserPwSalt(queryDTO.getUserPwSalt());
        dto.setUserPhone(queryDTO.getUserPhone());
        dto.setAccessIp(queryDTO.getAccessIp());
        dto.setPhoneProvider(queryDTO.getPhoneProvider());
        dto.setUserGender(queryDTO.getUserGender());
        dto.setAddrCode(queryDTO.getAddrCode());
        dto.setAddr1(queryDTO.getAddr1());
        dto.setAddr2(queryDTO.getAddr2());
        dto.setBirthday(queryDTO.getBirthday() != null ? ParseUtil.formatDate(queryDTO.getBirthday()) : null);
        dto.setLastPwChgDt(queryDTO.getLastPwChgDt() != null ? ParseUtil.formatDateTime(queryDTO.getLastPwChgDt()) : null);
        dto.setLastLoginDt(queryDTO.getLastLoginDt() != null ? ParseUtil.formatDateTime(queryDTO.getLastLoginDt()) : null);
        dto.setRestFl(queryDTO.getRestFl());
        dto.setRestResetDt(queryDTO.getRestResetDt() != null ? ParseUtil.formatDateTime(queryDTO.getRestResetDt()) : null);
        dto.setDelYn(queryDTO.getDelYn());
        dto.setRegId(queryDTO.getRegId());
        dto.setRegDt(queryDTO.getRegDt() != null ? ParseUtil.formatDateTime(queryDTO.getRegDt()) : null);
        dto.setModId(queryDTO.getModId());
        dto.setRegDt(queryDTO.getModDt() != null ? ParseUtil.formatDateTime(queryDTO.getModDt()) : null);
        dto.setNiceidCi(queryDTO.getNiceidCi());
        dto.setNiceidDi(queryDTO.getNiceidDi());
        dto.setNiceidAuthDt(queryDTO.getNiceidAuthDt() != null ? ParseUtil.formatDateTime(queryDTO.getNiceidAuthDt()) : null);
        dto.setResNo(queryDTO.getResNo());
        dto.setCompanyIdx(queryDTO.getCompanyIdx() != null ? String.valueOf(queryDTO.getCompanyIdx()) : null);
        dto.setRegType(queryDTO.getRegType());

        return dto;
    }
    
}
