package com.shinhan.home.model.dto.querydto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.RunCategoryBTbDTO;
import com.shinhan.home.model.entity.RunCategoryBTbEntity;
import com.shinhan.home.util.ParseUtil;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class RunCategoryBTbQueryDTO extends CommonQueryDTO {

    private Integer catebIdx;
    private Integer cateaIdx;
    private String cateColor;
    private String cateTitle;
    private String cateDesc;

    public static RunCategoryBTbQueryDTO fromDto(RunCategoryBTbDTO dto) {
        return RunCategoryBTbQueryDTO.builder()
                .catebIdx(ParseUtil.parseInt(dto.getCatebIdx()))
                .cateaIdx(ParseUtil.parseInt(dto.getCateaIdx()))
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

    public RunCategoryBTbEntity toEntity() {
        return RunCategoryBTbEntity.builder()
                .catebIdx(this.catebIdx)
                .cateaIdx(this.cateaIdx)
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
