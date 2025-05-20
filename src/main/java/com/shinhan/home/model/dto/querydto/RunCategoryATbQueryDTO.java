package com.shinhan.home.model.dto.querydto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.RunCategoryATbDTO;
import com.shinhan.home.model.entity.RunCategoryATbEntity;
import com.shinhan.home.util.ParseUtil;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class RunCategoryATbQueryDTO extends CommonQueryDTO {
	
	private Integer cateaIdx;
    private String fileIdx;
    private String cateColor;
    private String cateTitle;
    private String cateDesc;

    public static RunCategoryATbQueryDTO fromDto(RunCategoryATbDTO dto) {
        return RunCategoryATbQueryDTO.builder()
                .cateaIdx(ParseUtil.parseInt(dto.getCateaIdx()))
                .fileIdx(dto.getFileIdx())
                .cateColor(dto.getCateColor())
                .cateTitle(dto.getCateTitle())
                .cateDesc(dto.getCateDesc())
                .regId(dto.getRegId())
                .regDt(ParseUtil.parseDateTime(dto.getRegDt()))
                .modId(dto.getModId())
                .modDt(ParseUtil.parseDateTime(dto.getModDt()))
                .delYn(dto.getDelYn())
                .build();
    }

    public RunCategoryATbEntity toEntity() {
        return RunCategoryATbEntity.builder()
                .cateaIdx(this.cateaIdx)
                .fileIdx(this.fileIdx)
                .cateColor(this.cateColor)
                .cateTitle(this.cateTitle)
                .cateDesc(this.cateDesc)
                .regId(this.getRegId())
                .regDt(this.getRegDt())
                .modId(this.getModId())
                .modDt(this.getModDt())
                .delYn(this.getDelYn())
                .build();
    }
}
