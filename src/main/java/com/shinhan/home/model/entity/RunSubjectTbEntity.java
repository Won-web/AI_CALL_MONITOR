package com.shinhan.home.model.entity;

import jakarta.persistence.Entity;

import com.shinhan.home.model.dto.querydto.RunSubjectTbQueryDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "run_subject_tb")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunSubjectTbEntity {
	
	@Id
    @Column(name = "subject_idx")
    private Integer subjectIdx;

    @Column(name = "lec_idx", nullable = false)
    private Integer lecIdx;

    @Column(name = "subject_title")
    private String subjectTitle;

    @Column(name = "subject_contents", columnDefinition = "LONGTEXT")
    private String subjectContents;

    @Column(name = "subject_order")
    private Integer subjectOrder;
    
    public void updateFromQueryDto(RunSubjectTbQueryDTO dto) {
        // 기본키 수정 방어
        if (!this.subjectIdx.equals(dto.getSubjectIdx())) {
            throw new IllegalArgumentException("PrimaryKey subjectIdx는 변경할 수 없습니다.");
        }

        if (dto.getLecIdx() != null) this.lecIdx = dto.getLecIdx();
        if (dto.getSubjectTitle() != null) this.subjectTitle = dto.getSubjectTitle();
        if (dto.getSubjectContents() != null) this.subjectContents = dto.getSubjectContents();
        if (dto.getSubjectOrder() != null) this.subjectOrder = dto.getSubjectOrder();
    }

}
