package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.RunSubjectFileTbQueryDTO;

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
public class RunSubjectFileTbDTO extends CommonDTO {
	
	private String subjectFileIdx;
    private String adminIdx;
    private Integer subjectIdx;
    private String youtubeUrl;
    private String fileIdx;
    private String fileTitle;
    private String fileContents;
    
    public static RunSubjectFileTbDTO fromQueryDTO(RunSubjectFileTbQueryDTO queryDTO) {
        return RunSubjectFileTbDTO.builder()
            .subjectFileIdx(String.valueOf(queryDTO.getSubjectFileIdx()))
            .adminIdx(String.valueOf(queryDTO.getAdminIdx()))
            .youtubeUrl(queryDTO.getYoutubeUrl())
            .fileIdx(queryDTO.getFileIdx())
            .fileTitle(queryDTO.getFileTitle())
            .fileContents(queryDTO.getFileContents())
            .regId(queryDTO.getRegId())
            .regDt(queryDTO.getRegDt() != null ? ParseUtil.formatDateTime(queryDTO.getRegDt()) : null)
            .modId(queryDTO.getModId())
            .modDt(queryDTO.getModDt() != null ? ParseUtil.formatDateTime(queryDTO.getModDt()) : null)
            .delYn(queryDTO.getDelYn())
            .build();
    }
    
}
