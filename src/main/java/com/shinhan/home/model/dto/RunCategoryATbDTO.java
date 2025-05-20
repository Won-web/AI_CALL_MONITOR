package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.RunCategoryATbQueryDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.util.ParseUtil;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
public class RunCategoryATbDTO extends CommonDTO {
	
	private String cateaIdx;
    private String fileIdx;
    private String cateColor;
    private String cateTitle;
    private String cateDesc;
    
    public static RunCategoryATbDTO fromQueryDTO(RunCategoryATbQueryDTO queryDTO) {
        return RunCategoryATbDTO.builder()
            .cateaIdx(String.valueOf(queryDTO.getCateaIdx()))
            .fileIdx(queryDTO.getFileIdx())
            .cateColor(queryDTO.getCateColor())
            .cateTitle(queryDTO.getCateTitle())
            .cateDesc(queryDTO.getCateDesc())
            .regId(queryDTO.getRegId())
            .regDt(queryDTO.getRegDt() != null ? ParseUtil.formatDateTime(queryDTO.getRegDt()) : null)
            .modId(queryDTO.getModId())
            .modDt(queryDTO.getModDt() != null ? ParseUtil.formatDateTime(queryDTO.getModDt()) : null)
            .delYn(queryDTO.getDelYn())
            .build();
    }
    
}
