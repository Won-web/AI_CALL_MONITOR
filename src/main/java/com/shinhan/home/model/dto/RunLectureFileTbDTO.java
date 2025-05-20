package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.RunLectureFileTbQueryDTO;

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
public class RunLectureFileTbDTO extends CommonDTO {
	
	private String lecFileIdx;
    private String lecIdx;
    private String lecFileType;
    private String fileIdx;
    private String fileExt;
    private String fileOrder;
    
    public static RunLectureFileTbDTO fromQueryDTO(RunLectureFileTbQueryDTO queryDTO) {
        return RunLectureFileTbDTO.builder()
            .lecFileIdx(String.valueOf(queryDTO.getLecFileIdx()))
            .lecIdx(String.valueOf(queryDTO.getLecIdx()))
            .lecFileType(queryDTO.getLecFileType())
            .fileIdx(queryDTO.getFileIdx())
            .fileExt(queryDTO.getFileExt())
            .fileOrder(queryDTO.getFileOrder() != null ? String.valueOf(queryDTO.getFileOrder()) : null)
            .regId(queryDTO.getRegId())
            .regDt(queryDTO.getRegDt() != null ? ParseUtil.formatDateTime(queryDTO.getRegDt()) : null)
            .modId(queryDTO.getModId())
            .modDt(queryDTO.getModDt() != null ? ParseUtil.formatDateTime(queryDTO.getModDt()) : null)
            .delYn(queryDTO.getDelYn())
            .build();
    }
    
}
