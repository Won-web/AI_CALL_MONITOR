package com.shinhan.home.model.dto.querydto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.RunSubjectVideoTbDTO;
import com.shinhan.home.model.entity.RunSubjectVideoTbEntity;
import com.shinhan.home.util.ParseUtil;

@Getter
@SuperBuilder
@NoArgsConstructor
public class RunSubjectVideoTbQueryDTO extends CommonQueryDTO {

    private Integer videoIdx;
    private Integer subjectIdx;
    private String fileNm;
    private String filePath;
    private String fileOrgNm;
    private String fileExt;
    private Long fileSize;
    private Integer duration;

    public static RunSubjectVideoTbQueryDTO fromDTO(RunSubjectVideoTbDTO dto) {
        return RunSubjectVideoTbQueryDTO.builder()
                .videoIdx(ParseUtil.parseInt(dto.getVideoIdx()))
                .subjectIdx(ParseUtil.parseInt(dto.getSubjectIdx()))
                .fileNm(dto.getFileNm())
                .filePath(dto.getFilePath())
                .fileOrgNm(dto.getFileOrgNm())
                .fileExt(dto.getFileExt())
                .fileSize(ParseUtil.parseLong(dto.getFileSize()))
                .duration(ParseUtil.parseInt(dto.getDuration()))
                .regId(dto.getRegId())
                .regDt(ParseUtil.parseDateTime(dto.getRegDt()))
                .modId(dto.getModId())
                .modDt(ParseUtil.parseDateTime(dto.getModDt()))
                .delYn(dto.getDelYn())
                .build();
    }

    public RunSubjectVideoTbEntity toEntity() {
        return RunSubjectVideoTbEntity.builder()
                .videoIdx(videoIdx)
                .subjectIdx(subjectIdx)
                .fileNm(fileNm)
                .filePath(filePath)
                .fileOrgNm(fileOrgNm)
                .fileExt(fileExt)
                .fileSize(fileSize)
                .duration(duration)
                .regId(this.getRegId())
                .regDt(this.getRegDt())
                .modId(this.getModId())
                .modDt(this.getModDt())
                .delYn(this.getDelYn())
                .build();
    }
}
