package com.shinhan.home.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "run_stay_tb")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunStayTbEntity {
	
	@Id
    @Column(name = "stay_idx")
    private Integer stayIdx;

    @Column(name = "stay_dt", nullable = false)
    private LocalDate stayDt;

    @Column(name = "user_idx", nullable = false)
    private Integer userIdx;

    @Column(name = "subject_idx", nullable = false)
    private Integer subjectIdx;

    @Column(name = "lec_idx", nullable = false)
    private Integer lecIdx;

    @Column(name = "stay_sec")
    private Integer staySec;

    @Column(name = "reg_dt")
    private LocalDateTime regDt;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;

}
