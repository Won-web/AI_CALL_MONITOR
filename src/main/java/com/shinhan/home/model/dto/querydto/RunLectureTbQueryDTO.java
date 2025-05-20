package com.shinhan.home.model.dto.querydto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.RunLectureTbDTO;
import com.shinhan.home.model.entity.RunLectureTbEntity;
import com.shinhan.home.util.ParseUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.querydsl.core.annotations.QueryProjection;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class RunLectureTbQueryDTO extends CommonQueryDTO {

	private Integer lecIdx;
    private Integer cateaIdx;
    private String upperCateTitle;
    private Integer catebIdx;
    private String lowerCateTitle;
    private String lecTitle;
    private String lecShortDesc;
    private String lecContents;
    private LocalDate appStartDt;
    private LocalDate appEndDt;
    private LocalDateTime lecStartDt;
    private LocalDateTime lecEndDt;
    private String hdrCode;
    private String hdrId;
    private String hrdDegrNo;
    private String openFl;
    private Integer price;
    private String tempFl;
    private String fileIdx;
    private String fileExt;
    private String teacherName;
    private Integer userIdx;

    @QueryProjection
    public RunLectureTbQueryDTO(Integer lecIdx, Integer cateaIdx, String upperCateTitle, Integer catebIdx, String lowerCateTitle,
                                 String lecTitle, String lecShortDesc, String lecContents, LocalDate appStartDt, LocalDate appEndDt,
                                 LocalDateTime lecStartDt, LocalDateTime lecEndDt, String hdrCode, String hdrId, String hrdDegrNo,
                                 String openFl, Integer price, String tempFl, String fileIdx, String fileExt,String teacherName,
                                 String regId, LocalDateTime regDt, String modId, LocalDateTime modDt, String delYn) {

        this.lecIdx = lecIdx;
        this.cateaIdx = cateaIdx;
        this.upperCateTitle = upperCateTitle;
        this.catebIdx = catebIdx;
        this.lowerCateTitle = lowerCateTitle;
        this.lecTitle = lecTitle;
        this.lecShortDesc = lecShortDesc;
        this.lecContents = lecContents;
        this.appStartDt = appStartDt;
        this.appEndDt = appEndDt;
        this.lecStartDt = lecStartDt;
        this.lecEndDt = lecEndDt;
        this.hdrCode = hdrCode;
        this.hdrId = hdrId;
        this.hrdDegrNo = hrdDegrNo;
        this.openFl = openFl;
        this.price = price;
        this.tempFl = tempFl;
        this.fileIdx = fileIdx;
        this.fileExt = fileExt;
        this.teacherName = teacherName;

        this.setRegId(regId);
        this.setRegDt(regDt);
        this.setModId(modId);
        this.setModDt(modDt);
        this.setDelYn(delYn);
    }


    public static RunLectureTbQueryDTO fromDto(RunLectureTbDTO dto) {
        return RunLectureTbQueryDTO.builder()
                .lecIdx(ParseUtil.parseInt(dto.getLecIdx()))
                .cateaIdx(ParseUtil.parseInt(dto.getCateaIdx()))
                .catebIdx(ParseUtil.parseInt(dto.getCatebIdx()))
                .lecTitle(dto.getLecTitle())
                .lecShortDesc(dto.getLecShortDesc())
                .lecContents(dto.getLecContents())
                .appStartDt(ParseUtil.parseDate(dto.getAppStartDt()))
                .appEndDt(ParseUtil.parseDate(dto.getAppEndDt()))
                .lecStartDt(ParseUtil.parseDateTime(dto.getLecStartDt()))
                .lecEndDt(ParseUtil.parseDateTime(dto.getLecEndDt()))
                .hdrCode(dto.getHdrCode())
                .hdrId(dto.getHdrId())
                .hrdDegrNo(dto.getHrdDegrNo())
                .openFl(dto.getOpenFl())
                .price(ParseUtil.parseInt(dto.getPrice()))
                .tempFl(dto.getTempFl())
                .fileIdx(dto.getFileIdx())
                .fileExt(dto.getFileExt())
                .teacherName(dto.getTeacherName())
                .searchType(dto.getSearchType())
                .searchStr(dto.getSearchStr())
                .searchType2(dto.getSearchType2())
                .searchStr2(dto.getSearchStr2())
                .searchType3(dto.getSearchType3())
                .searchStr3(dto.getSearchStr3())
                .searchType4(dto.getSearchType4())
                .searchStr4(dto.getSearchStr4())
                .searchType5(dto.getSearchType5())
                .searchStr5(dto.getSearchStr5())
                .searchType6(dto.getSearchType6())
                .searchStr6(dto.getSearchStr6())
                .searchType7(dto.getSearchType7())
                .searchStr7(dto.getSearchStr7())
                .regId(dto.getRegId())
                .regDt(ParseUtil.parseDateTime(dto.getRegDt()))
                .modId(dto.getModId())
                .modDt(ParseUtil.parseDateTime(dto.getModDt()))
                .delYn(dto.getDelYn())
                .userIdx(ParseUtil.parseInt(dto.getUserIdx()))
                .build();
    }

    public RunLectureTbEntity toEntity() {
        return RunLectureTbEntity.builder()
                .lecIdx(this.lecIdx)
                .cateaIdx(this.cateaIdx)
                .catebIdx(this.catebIdx)
                .lecTitle(this.lecTitle)
                .lecShortDesc(this.lecShortDesc)
                .lecContents(this.lecContents)
                .appStartDt(this.appStartDt)
                .appEndDt(this.appEndDt)
                .lecStartDt(this.lecStartDt)
                .lecEndDt(this.lecEndDt)
                .hdrCode(this.hdrCode)
                .hdrId(this.hdrId)
                .hrdDegrNo(this.hrdDegrNo)
                .openFl(this.openFl)
                .price(this.price)
                .tempFl(this.tempFl)
                .teacherName(this.teacherName)
                .regId(this.getRegId())
                .regDt(this.getRegDt())
                .modId(this.getModId())
                .modDt(this.getModDt())
                .delYn(this.getDelYn())
                .build();
    }
}