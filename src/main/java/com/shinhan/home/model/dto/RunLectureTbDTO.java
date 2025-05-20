package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.RunLectureTbQueryDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.util.ParseUtil;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
public class RunLectureTbDTO extends CommonDTO {
	
	private String lecIdx;
    private String cateaIdx;
    private String upperCateTitle;
    private String catebIdx;
    private String lowerCateTitle;
    private String lecTitle;
    private String lecShortDesc;
    private String lecContents;
    private String appStartDt;
    private String appEndDt;
    private String lecStartDt;
    private String lecEndDt;
    private String hdrCode;
    private String hdrId;
    private String hrdDegrNo;
    private String openFl;
    private String price;
    private String tempFl;
    private String fileIdx;
    private String fileExt;
    private String teacherName;
    private String userIdx;
    
    public static RunLectureTbDTO fromQueryDTO(RunLectureTbQueryDTO queryDTO) {
        return RunLectureTbDTO.builder()
                .lecIdx(String.valueOf(queryDTO.getLecIdx()))
                .cateaIdx(String.valueOf(queryDTO.getCateaIdx()))
                .catebIdx(String.valueOf(queryDTO.getCatebIdx()))
                .lecTitle(queryDTO.getLecTitle())
                .lecShortDesc(queryDTO.getLecShortDesc())
                .lecContents(queryDTO.getLecContents())
                .appStartDt(ParseUtil.formatDate(queryDTO.getAppStartDt()))
                .appEndDt(ParseUtil.formatDate(queryDTO.getAppEndDt()))
                .lecStartDt(ParseUtil.formatDateTime(queryDTO.getLecStartDt()))
                .lecEndDt(ParseUtil.formatDateTime(queryDTO.getLecEndDt()))
                .hdrCode(queryDTO.getHdrCode())
                .hdrId(queryDTO.getHdrId())
                .hrdDegrNo(queryDTO.getHrdDegrNo())
                .openFl(queryDTO.getOpenFl())
                .price(queryDTO.getPrice() != null ? String.valueOf(queryDTO.getPrice()) : null)
                .tempFl(queryDTO.getTempFl())
                .fileIdx(queryDTO.getFileIdx())
                .fileExt(queryDTO.getFileExt())
                .teacherName(queryDTO.getTeacherName())
                .regId(queryDTO.getRegId())
                .modId(queryDTO.getModId())
                .regDt(ParseUtil.formatDateTime(queryDTO.getRegDt()))
                .modDt(ParseUtil.formatDateTime(queryDTO.getModDt()))
                .delYn(queryDTO.getDelYn())
                .userIdx(String.valueOf(queryDTO.getUserIdx()))
                .build();
    }

}
