package com.shinhan.home.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public abstract class CommonEntity {
	
	@Column(name = "reg_id")
    private String regId;
	@Column(name = "reg_dt")
    private LocalDateTime regDt;
    @Column(name = "mod_id")
    private String modId;
    @Column(name = "mod_dt")
    private LocalDateTime modDt;
    @Column(name = "del_yn")
	private String delYn;
    
}
