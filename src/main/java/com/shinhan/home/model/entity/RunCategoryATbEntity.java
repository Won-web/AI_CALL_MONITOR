package com.shinhan.home.model.entity;

import jakarta.persistence.Entity;

import com.shinhan.home.model.dto.querydto.RunCategoryATbQueryDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "run_category_a_tb")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunCategoryATbEntity extends CommonEntity {
	
	@Id
	@Column(name = "catea_idx")
    private Integer cateaIdx;

    @Column(name = "file_idx")
    private String fileIdx;

    @Column(name = "cate_color")
    private String cateColor;

    @Column(name = "cate_title")
    private String cateTitle;

    @Column(name = "cate_desc", columnDefinition = "LONGTEXT")
    private String cateDesc;	
    
    public void updateFromQueryDto(RunCategoryATbQueryDTO dto) {
        // 기본키 수정 방어
        if (!this.cateaIdx.equals(dto.getCateaIdx())) {
            throw new IllegalArgumentException("PrimaryKey cateaIdx는 변경할 수 없습니다.");
        }

        if (dto.getFileIdx() != null) this.fileIdx = dto.getFileIdx();
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
