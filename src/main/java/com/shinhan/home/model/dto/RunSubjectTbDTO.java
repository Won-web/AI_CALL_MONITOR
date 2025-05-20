package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.RunSubjectTbQueryDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
public class RunSubjectTbDTO {
	
	private String subjectIdx;
	private String lecIdx;
    private String subjectTitle;
    private String subjectContents;
    private String subjectOrder;
    private String staySec;
    // 영상 연동용 필드
    private String videoIdx;
    private String fileNm;       // 암호화된 파일명
    private String filePath;     // 경로
    private String fileOrgNm;    // 실제 파일명
    private String fileExt;      // 확장자
    private String duration;    // 재생 시간
    
    public static RunSubjectTbDTO fromQueryDTO(RunSubjectTbQueryDTO queryDTO) {
        return RunSubjectTbDTO.builder()
            .subjectIdx(String.valueOf(queryDTO.getSubjectIdx()))
            .lecIdx(String.valueOf(queryDTO.getLecIdx()))
            .subjectTitle(queryDTO.getSubjectTitle())
            .subjectContents(queryDTO.getSubjectContents())
            .subjectOrder(queryDTO.getSubjectOrder() != null ? String.valueOf(queryDTO.getSubjectOrder()) : null)
            .staySec(String.valueOf(queryDTO.getStaySec()))
            .videoIdx(String.valueOf(queryDTO.getVideoIdx()))
            .fileNm(queryDTO.getFileNm())
            .filePath(queryDTO.getFilePath())
            .fileExt(queryDTO.getFileExt())
            .duration(String.valueOf(queryDTO.getDuration()))
            .build();
    }
    
}
