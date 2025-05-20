package com.shinhan.home.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "run_video_info_tb")
@IdClass(RunVideoInfoTbId.class)
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunVideoInfoTbEntity {
	
	@Id
    @Column(name = "video_idx", nullable = false)
    private Integer videoIdx;

    @Id
    @Column(name = "video_id", nullable = false, length = 255)
    private String videoId;

    @Column(name = "video_ext", length = 10)
    private String videoExt;

    @Column(name = "video_url", nullable = false, length = 255)
    private String videoUrl;

    @Lob
    @Column(name = "video_contents")
    private String videoContents;

    @Lob
    @Column(name = "video_surmmary")
    private String videoSummary;

    @Lob
    @Column(name = "video_quiz")
    private String videoQuiz;

    @Column(name = "reg_dt")
    private LocalDateTime regDt;
}
