package com.shinhan.home.model.dto.querydto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.RunStayTbDTO;
import com.shinhan.home.model.entity.RunStayTbEntity;
import com.shinhan.home.util.ParseUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunStayTbQueryDTO {
	
	private Integer stayIdx;
    private LocalDate stayDt;
    private Integer userIdx;
    private Integer subjectIdx;
    private Integer lecIdx;
    private Integer staySec;
    private LocalDateTime regDt;
    private LocalDateTime modDt;

    public static RunStayTbQueryDTO fromDto(RunStayTbDTO dto) {
        return RunStayTbQueryDTO.builder()
                .stayIdx(Integer.parseInt(dto.getStayIdx()))
                .stayDt(ParseUtil.parseDate(dto.getStayDt()))
                .userIdx(Integer.parseInt(dto.getUserIdx()))
                .subjectIdx(Integer.parseInt(dto.getSubjectIdx()))
                .lecIdx(Integer.parseInt(dto.getLecIdx()))
                .staySec(Integer.parseInt(dto.getStaySec()))
                .regDt(ParseUtil.parseDateTime(dto.getRegDt()))
                .modDt(ParseUtil.parseDateTime(dto.getModDt()))
                .build();
    }

    public RunStayTbEntity toEntity() {
        return RunStayTbEntity.builder()
                .stayIdx(this.stayIdx)
                .stayDt(this.stayDt)
                .userIdx(this.userIdx)
                .subjectIdx(this.subjectIdx)
                .lecIdx(this.lecIdx)
                .staySec(this.staySec)
                .regDt(this.regDt)
                .modDt(this.modDt)
                .build();
    }
    
}
