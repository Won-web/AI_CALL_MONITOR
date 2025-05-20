package com.shinhan.home.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "run_subject_video_tb")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunSubjectVideoTbEntity extends CommonEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_idx")
    private Integer videoIdx;

    @Column(name = "subject_idx", nullable = false)
    private Integer subjectIdx;

    @Column(name = "file_nm", nullable = false)
    private String fileNm;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @Column(name = "file_org_nm", nullable = false)
    private String fileOrgNm;

    @Column(name = "file_ext", nullable = false)
    private String fileExt;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    
}
