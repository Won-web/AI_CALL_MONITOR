package com.shinhan.home.model.entity;

import com.shinhan.home.model.dto.querydto.RunLectureFileTbQueryDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "run_lecture_file_tb")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunLectureFileTbEntity extends CommonEntity {
	
	@Id
    @Column(name = "lec_file_idx")
    private Integer lecFileIdx;

    @Column(name = "lec_idx")
    private Integer lecIdx;

    @Column(name = "lec_file_type")
    private String lecFileType;

    @Column(name = "file_idx")
    private String fileIdx;
    
    @Column(name = "file_ext")
    private String fileExt;
    
    @Column(name = "file_order")
    private Integer fileOrder;
    
    public void updateFromQueryDto(RunLectureFileTbQueryDTO dto) {
        // 기본키 수정 방어
        if (!this.lecFileIdx.equals(dto.getLecFileIdx())) {
            throw new IllegalArgumentException("PrimaryKey lecFileIdx는 변경할 수 없습니다.");
        }

        if (dto.getLecIdx() != null) this.lecIdx = dto.getLecIdx();
        if (dto.getLecFileType() != null) this.lecFileType = dto.getLecFileType();
        if (dto.getFileIdx() != null) this.fileIdx = dto.getFileIdx();
        if (dto.getFileExt() != null) this.fileExt = dto.getFileExt();
        if (dto.getFileOrder() != null) this.fileOrder = dto.getFileOrder();

        // 공통 필드
        if (dto.getRegId() != null) this.setRegId(dto.getRegId());
        if (dto.getRegDt() != null) this.setRegDt(dto.getRegDt());
        if (dto.getModId() != null) this.setModId(dto.getModId());
        if (dto.getModDt() != null) this.setModDt(dto.getModDt());
        if (dto.getDelYn() != null) this.setDelYn(dto.getDelYn());
    }
}
