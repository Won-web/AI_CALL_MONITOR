package com.shinhan.home.model.entity;

import jakarta.persistence.Entity;

import com.shinhan.home.model.dto.querydto.RunSubjectFileTbQueryDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "run_subject_file_tb")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunSubjectFileTbEntity extends CommonEntity {
	
	@Id
    @Column(name = "subject_file_idx")
    private Integer subjectFileIdx;

    @Column(name = "admin_idx", nullable = false)
    private Integer adminIdx;

    @Column(name = "youtube_url", length = 255)
    private String youtubeUrl;
    
    @Column(name = "file_idx", length = 255)
    private String fileIdx;

    @Column(name = "file_title", length = 1000)
    private String fileTitle;

    @Column(name = "file_contents", columnDefinition = "LONGTEXT")
    private String fileContents;
    
    public void updateFromQueryDto(RunSubjectFileTbQueryDTO dto) {
        // 기본키 수정 방어
        if (!this.subjectFileIdx.equals(dto.getSubjectFileIdx())) {
            throw new IllegalArgumentException("PrimaryKey subjectFileIdx는 변경할 수 없습니다.");
        }

        if (dto.getAdminIdx() != null) this.adminIdx = dto.getAdminIdx();
        if (dto.getFileIdx() != null) this.fileIdx = dto.getFileIdx();
        if (dto.getFileTitle() != null) this.fileTitle = dto.getFileTitle();
        if (dto.getFileContents() != null) this.fileContents = dto.getFileContents();
        if (dto.getRegId() != null) this.setRegId(dto.getRegId());
        if (dto.getRegDt() != null) this.setRegDt(dto.getRegDt());
        if (dto.getModId() != null) this.setModId(dto.getModId());
        if (dto.getModDt() != null) this.setModDt(dto.getModDt());
        if (dto.getDelYn() != null) this.setDelYn(dto.getDelYn());
    }
    
}
