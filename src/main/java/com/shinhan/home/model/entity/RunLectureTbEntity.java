package com.shinhan.home.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.shinhan.home.model.dto.querydto.RunLectureTbQueryDTO;

@Entity
@Table(name = "run_lecture_tb")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunLectureTbEntity extends CommonEntity {
	
	@Id
    @Column(name = "lec_idx")
    private Integer lecIdx;

    @Column(name = "catea_idx")
    private Integer cateaIdx;

    @Column(name = "cateb_idx")
    private Integer catebIdx;

    @Column(name = "lec_title", length = 1000)
    private String lecTitle;

    @Column(name = "lec_short_desc", columnDefinition = "LONGTEXT")
    private String lecShortDesc;

    @Column(name = "lec_contents", columnDefinition = "LONGTEXT")
    private String lecContents;

    @Column(name = "app_start_dt")
    private LocalDate appStartDt;

    @Column(name = "app_end_dt")
    private LocalDate appEndDt;

    @Column(name = "lec_start_dt")
    private LocalDateTime lecStartDt;

    @Column(name = "lec_end_dt")
    private LocalDateTime lecEndDt;

    @Column(name = "hdr_code")
    private String hdrCode;

    @Column(name = "hdr_id")
    private String hdrId;

    @Column(name = "hrd_degr_no")
    private String hrdDegrNo;

    @Column(name = "open_fl")
    private String openFl;

    @Column(name = "price")
    private Integer price;

    @Column(name = "temp_fl")
    private String tempFl;
    
    @Column(name = "teacher_name")
    private String teacherName;
	
    public void updateFromQueryDto(RunLectureTbQueryDTO dto) {
        // 기본키 수정 방어
        if (!this.lecIdx.equals(dto.getLecIdx())) {
            throw new IllegalArgumentException("PrimaryKey lecIdx는 변경할 수 없습니다.");
        }

        if (dto.getCateaIdx() != null) this.cateaIdx = dto.getCateaIdx();
        if (dto.getCatebIdx() != null) this.catebIdx = dto.getCatebIdx();
        if (dto.getLecTitle() != null) this.lecTitle = dto.getLecTitle();
        if (dto.getLecShortDesc() != null) this.lecShortDesc = dto.getLecShortDesc();
        if (dto.getLecContents() != null) this.lecContents = dto.getLecContents();
        if (dto.getAppStartDt() != null) this.appStartDt = dto.getAppStartDt();
        if (dto.getAppEndDt() != null) this.appEndDt = dto.getAppEndDt();
        if (dto.getLecStartDt() != null) this.lecStartDt = dto.getLecStartDt();
        if (dto.getLecEndDt() != null) this.lecEndDt = dto.getLecEndDt();
        if (dto.getHdrCode() != null) this.hdrCode = dto.getHdrCode();
        if (dto.getHdrId() != null) this.hdrId = dto.getHdrId();
        if (dto.getHrdDegrNo() != null) this.hrdDegrNo = dto.getHrdDegrNo();
        if (dto.getOpenFl() != null) this.openFl = dto.getOpenFl();
        if (dto.getPrice() != null) this.price = dto.getPrice();
        if (dto.getTempFl() != null) this.tempFl = dto.getTempFl();

        // 공통 필드
        if (dto.getRegId() != null) this.setRegId(dto.getRegId());
        if (dto.getRegDt() != null) this.setRegDt(dto.getRegDt());
        if (dto.getModId() != null) this.setModId(dto.getModId());
        if (dto.getModDt() != null) this.setModDt(dto.getModDt());
        if (dto.getDelYn() != null) this.setDelYn(dto.getDelYn());
    }
}
