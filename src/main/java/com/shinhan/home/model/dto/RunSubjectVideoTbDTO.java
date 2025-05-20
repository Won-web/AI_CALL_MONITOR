package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.RunSubjectVideoTbQueryDTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.util.ParseUtil;

@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunSubjectVideoTbDTO extends CommonDTO{
	
	private String videoIdx;
    private String subjectIdx;
    private String fileNm;
    private String filePath;
    private String fileOrgNm;
    private String fileExt;
    private String fileSize;
    private String duration;
    
    public static RunSubjectVideoTbDTO fromQueryDTO(RunSubjectVideoTbQueryDTO queryDTO) {
        return RunSubjectVideoTbDTO.builder()
                .videoIdx(String.valueOf(queryDTO.getVideoIdx()))
                .subjectIdx(String.valueOf(queryDTO.getSubjectIdx()))
                .fileNm(queryDTO.getFileNm())
                .filePath(queryDTO.getFilePath())
                .fileOrgNm(queryDTO.getFileOrgNm())
                .fileExt(queryDTO.getFileExt())
                .fileSize(String.valueOf(queryDTO.getFileSize()))
                .duration(String.valueOf(queryDTO.getDuration()))
                .regId(queryDTO.getRegId())
                .regDt(ParseUtil.formatDateTime(queryDTO.getRegDt()))
                .modId(queryDTO.getModId())
                .modDt(ParseUtil.formatDateTime(queryDTO.getModDt()))
                .delYn(queryDTO.getDelYn())
                .build();
    }
}
