package com.shinhan.home.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "run_user_lecture_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RunUserLectureTbEntity {
	
	@EmbeddedId
    private RunUserLectureTbId id;

    @Column(name = "reg_id")
    private String regId;

    @Column(name = "mod_id")
    private String modId;

    @Column(name = "reg_dt")
    private LocalDateTime regDt;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @Column(name = "del_yn")
    private String delYn;

    @Column(name = "start_yn")
    private String startYn;
}
