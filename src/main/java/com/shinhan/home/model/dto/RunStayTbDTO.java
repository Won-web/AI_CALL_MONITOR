package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.RunStayTbQueryDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.util.ParseUtil;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class RunStayTbDTO {
	private String stayIdx;
    private String stayDt;
    private String userIdx;
    private String subjectIdx;
    private String lecIdx;
    private String staySec;
    private String regDt;
    private String modDt;
    
    public static RunStayTbDTO fromQueryDTO(RunStayTbQueryDTO queryDTO) {
        return RunStayTbDTO.builder()
                .stayIdx(String.valueOf(queryDTO.getStayIdx()))
                .stayDt(ParseUtil.formatDate(queryDTO.getStayDt()))
                .userIdx(String.valueOf(queryDTO.getUserIdx()))
                .subjectIdx(String.valueOf(queryDTO.getSubjectIdx()))
                .lecIdx(String.valueOf(queryDTO.getLecIdx()))
                .staySec(String.valueOf(queryDTO.getStaySec()))
                .regDt(ParseUtil.formatDateTime(queryDTO.getRegDt()))
                .modDt(ParseUtil.formatDateTime(queryDTO.getModDt()))
                .build();
    }
    
}
