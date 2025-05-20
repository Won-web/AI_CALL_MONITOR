package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.RunCategoryBTbQueryDTO;

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
public class RunCategoryBTbDTO extends CommonDTO {
	
	private String catebIdx;
    private String cateaIdx;
    private String cateColor;
    private String cateTitle;
    private String cateDesc;
    
    public static RunCategoryBTbDTO fromQueryDTO(RunCategoryBTbQueryDTO queryDTO) {
        return RunCategoryBTbDTO.builder()
            .catebIdx(String.valueOf(queryDTO.getCatebIdx()))
            .cateaIdx(String.valueOf(queryDTO.getCateaIdx()))
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
