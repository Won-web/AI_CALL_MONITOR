package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.RunMemberLoginHistQueryDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.util.ParseUtil;

/**
 * 회원 로그인 이력 DTO
 * - Entity와 분리된 비즈니스 로직 처리용 DTO
 * - 날짜/시간은 문자열로만 처리
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
public class RunMemberLoginHistDTO extends CommonDTO {

    private String loginIdx;        // 로그인 이력 고유번호 (INT)
    private String emailId;         // 이메일 ID
    private String reqIp;           // 요청한 IP
    private String sessionId;       // 세션 ID
    private String reqMacAddr;      // 요청한 MAC 주소
    private String reqDevice;       // 요청한 디바이스 정보
    private String loginResult;     // 로그인 결과 (성공/실패 등)
    private String returnMsg;       // 로그인 시 반환 메시지
    
    public static RunMemberLoginHistDTO fromQueryDTO(RunMemberLoginHistQueryDTO queryDTO) {
        RunMemberLoginHistDTO dto = new RunMemberLoginHistDTO();

        // QueryDTO의 기본키(정수형)를 문자열로 변환(필요 시)
        dto.setLoginIdx(queryDTO.getLoginIdx() != null ? String.valueOf(queryDTO.getLoginIdx()) : null);
        dto.setEmailId(queryDTO.getEmailId());
        dto.setReqIp(queryDTO.getReqIp());
        dto.setSessionId(queryDTO.getSessionId());
        dto.setReqMacAddr(queryDTO.getReqMacAddr());
        dto.setReqDevice(queryDTO.getReqDevice());
        dto.setLoginResult(queryDTO.getLoginResult());
        dto.setReturnMsg(queryDTO.getReturnMsg());

        // CommonDTO의 필드 (regId, regDt, modId, modDt, delYn 등)도 매핑
        dto.setDelYn(queryDTO.getDelYn());
        dto.setRegId(queryDTO.getRegId());
        dto.setRegDt(queryDTO.getRegDt() != null ? ParseUtil.formatDateTime(queryDTO.getRegDt()) : null);
        dto.setModId(queryDTO.getModId());
        dto.setModDt(queryDTO.getModDt() != null ? ParseUtil.formatDateTime(queryDTO.getModDt()) : null);

        return dto;
    }
    
}
