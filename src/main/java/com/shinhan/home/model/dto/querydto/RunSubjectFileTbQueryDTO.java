package com.shinhan.home.model.dto.querydto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.RunSubjectFileTbDTO;
import com.shinhan.home.model.entity.RunSubjectFileTbEntity;
import com.shinhan.home.util.ParseUtil;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class RunSubjectFileTbQueryDTO extends CommonQueryDTO {
	
	private Integer subjectFileIdx;
    private Integer adminIdx;
    private String youtubeUrl;
    private String fileIdx;
    private String fileTitle;
    private String fileContents;

    public static RunSubjectFileTbQueryDTO fromDTO(RunSubjectFileTbDTO dto) {
        return RunSubjectFileTbQueryDTO.builder()
                .subjectFileIdx(ParseUtil.parseInt(dto.getSubjectFileIdx()))
                .adminIdx(ParseUtil.parseInt(dto.getAdminIdx()))
                .youtubeUrl(dto.getYoutubeUrl())
                .fileIdx(dto.getFileIdx())
                .fileTitle(dto.getFileTitle())
                .fileContents(dto.getFileContents())
                .delYn(dto.getDelYn())
                .regId(dto.getRegId())
                .regDt(ParseUtil.parseDateTime(dto.getRegDt()))
                .modId(dto.getModId())
                .modDt(ParseUtil.parseDateTime(dto.getModDt()))
                .build();
    }

    public RunSubjectFileTbEntity toEntity() {
        return RunSubjectFileTbEntity.builder()
                .subjectFileIdx(this.subjectFileIdx)
                .adminIdx(this.adminIdx)
                .youtubeUrl(this.youtubeUrl)
                .fileIdx(this.fileIdx)
                .fileTitle(this.fileTitle)
                .fileContents(this.fileContents)
                .delYn(this.getDelYn())
                .regId(this.getRegId())
                .regDt(this.getRegDt())
                .modId(this.getModId())
                .modDt(this.getModDt())
                .build();
    }
}
