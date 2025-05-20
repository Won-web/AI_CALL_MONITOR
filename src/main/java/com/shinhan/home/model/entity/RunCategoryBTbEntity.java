package com.shinhan.home.model.entity;

import jakarta.persistence.Entity;

import com.shinhan.home.model.dto.querydto.RunCategoryBTbQueryDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "run_category_b_tb")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunCategoryBTbEntity extends CommonEntity {

	@Id
    @Column(name = "cateb_idx")
    private Integer catebIdx;

    @Column(name = "catea_idx")
    private Integer cateaIdx;

    @Column(name = "cate_color")
    private String cateColor;

    @Column(name = "cate_title")
    private String cateTitle;

    @Column(name = "cate_desc", columnDefinition = "LONGTEXT")
    private String cateDesc;
    
    public void updateFromQueryDto(RunCategoryBTbQueryDTO dto) {
        // 기본키 수정 방어
        if (!this.catebIdx.equals(dto.getCatebIdx())) {
            throw new IllegalArgumentException("PrimaryKey catebIdx는 변경할 수 없습니다.");
        }

        if (dto.getCateaIdx() != null) this.cateaIdx = dto.getCateaIdx();
        if (dto.getCateColor() != null) this.cateColor = dto.getCateColor();
        if (dto.getCateTitle() != null) this.cateTitle = dto.getCateTitle();
        if (dto.getCateDesc() != null) this.cateDesc = dto.getCateDesc();

        // 공통 필드
        if (dto.getRegId() != null) this.setRegId(dto.getRegId());
        if (dto.getRegDt() != null) this.setRegDt(dto.getRegDt());
        if (dto.getModId() != null) this.setModId(dto.getModId());
        if (dto.getModDt() != null) this.setModDt(dto.getModDt());
        if (dto.getDelYn() != null) this.setDelYn(dto.getDelYn());
    }
}
