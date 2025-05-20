package com.shinhan.home.model.dto.querydto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import com.shinhan.home.model.dto.RunSubjectTbDTO;
import com.shinhan.home.util.ParseUtil;
import com.shinhan.home.model.entity.RunSubjectTbEntity;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class RunSubjectTbQueryDTO {

	private Integer subjectIdx;
    private Integer lecIdx;
    private String subjectTitle;
    private String subjectContents;
    private Integer subjectOrder;
    private Integer staySec;
    //영상 필드
    private Integer videoIdx;
    private String fileNm;       
    private String filePath;     
    private String fileOrgNm;    
    private String fileExt;
    private Integer duration;
    

    
    @QueryProjection
    public RunSubjectTbQueryDTO(Integer subjectIdx, Integer lecIdx, String subjectTitle, String subjectContents,
                                Integer subjectOrder, Integer staySec,
                                Integer videoIdx, String fileNm, String filePath, String fileOrgNm, String fileExt,
                                Integer duration) {
        this.subjectIdx = subjectIdx;
        this.lecIdx = lecIdx;
        this.subjectTitle = subjectTitle;
        this.subjectContents = subjectContents;
        this.subjectOrder = subjectOrder;
        this.staySec = staySec;
        this.videoIdx = videoIdx;
        this.fileNm = fileNm;
        this.filePath = filePath;
        this.fileOrgNm = fileOrgNm;
        this.fileExt = fileExt;
        this.duration = duration;
    }

    public static RunSubjectTbQueryDTO fromDTO(RunSubjectTbDTO dto) {
        return RunSubjectTbQueryDTO.builder()
                .subjectIdx(ParseUtil.parseInt(dto.getSubjectIdx()))
                .lecIdx(ParseUtil.parseInt(dto.getLecIdx()))
                .subjectTitle(dto.getSubjectTitle())
                .subjectContents(dto.getSubjectContents())
                .subjectOrder(ParseUtil.parseInt(dto.getSubjectOrder()))
                .staySec(ParseUtil.parseInt(dto.getStaySec()))
                .videoIdx(ParseUtil.parseInt(dto.getVideoIdx()))
                .fileNm(dto.getFileNm())
                .filePath(dto.getFilePath())
                .fileOrgNm(dto.getFileOrgNm())
                .fileExt(dto.getFileExt())
                .duration(ParseUtil.parseInt(dto.getDuration()))
                .build();
    }

    public RunSubjectTbEntity toEntity() {
        return RunSubjectTbEntity.builder()
                .subjectIdx(this.subjectIdx)
                .lecIdx(this.lecIdx)
                .subjectTitle(this.subjectTitle)
                .subjectContents(this.subjectContents)
                .subjectOrder(this.subjectOrder)
                .build();
    }
}
