package com.shinhan.home.model.dto.querydto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.util.ParseUtil;

import com.shinhan.home.model.dto.RunMemberLoginHistDTO;
import com.shinhan.home.model.entity.RunMemberLoginHistEntity;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class RunMemberLoginHistQueryDTO extends CommonQueryDTO {
	
	private Integer loginIdx;
	private String emailId;
	private String reqIp;
	private String sessionId;
	private String reqMacAddr;
	private String reqDevice;
	private String loginResult;
	private String returnMsg;
	
	public static RunMemberLoginHistQueryDTO fromDTO(RunMemberLoginHistDTO dto) {
	    RunMemberLoginHistQueryDTO queryDTO = new RunMemberLoginHistQueryDTO();

	    queryDTO.setLoginIdx(ParseUtil.parseInt(dto.getLoginIdx()));
	    queryDTO.setEmailId(dto.getEmailId());
	    queryDTO.setReqIp(dto.getReqIp());
	    queryDTO.setSessionId(dto.getSessionId());
	    queryDTO.setReqMacAddr(dto.getReqMacAddr());
	    queryDTO.setReqDevice(dto.getReqDevice());
	    queryDTO.setLoginResult(dto.getLoginResult());
	    queryDTO.setReturnMsg(dto.getReturnMsg());
	    queryDTO.setRegId(dto.getRegId());
	    queryDTO.setRegDt(ParseUtil.parseDateTime(dto.getRegDt()));
	    queryDTO.setModId(dto.getModId());
	    queryDTO.setModDt(ParseUtil.parseDateTime(dto.getModDt()));
	    queryDTO.setDelYn(dto.getDelYn());

	    return queryDTO;
	}

	public RunMemberLoginHistEntity toEntity() {
	    return RunMemberLoginHistEntity.builder()
	        .loginIdx(this.loginIdx)
	        .emailId(this.emailId)
	        .reqIp(this.reqIp)
	        .sessionId(this.sessionId)
	        .reqMacAddr(this.reqMacAddr)
	        .reqDevice(this.reqDevice)
	        .loginResult(this.loginResult)
	        .returnMsg(this.returnMsg)
	        .delYn(this.getDelYn())
	        .regId(this.getRegId())
	        .regDt(this.getRegDt())
	        .modId(this.getModId())
	        .modDt(this.getModDt())
	        .build();
	}
}
