package com.shinhan.home.model.dto.querydto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.RunLectureFileTbDTO;
import com.shinhan.home.model.entity.RunLectureFileTbEntity;
import com.shinhan.home.util.ParseUtil;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class RunLectureFileTbQueryDTO extends CommonQueryDTO {

    private Integer lecFileIdx;
    private Integer lecIdx;
    private String lecFileType;
    private String fileIdx;
    private String fileExt;
    private Integer fileOrder;

    public static RunLectureFileTbQueryDTO fromDto(RunLectureFileTbDTO dto) {
        return RunLectureFileTbQueryDTO.builder()
                .lecFileIdx(ParseUtil.parseInt(dto.getLecFileIdx()))
                .lecIdx(ParseUtil.parseInt(dto.getLecIdx()))
                .lecFileType(dto.getLecFileType())
                .fileIdx(dto.getFileIdx())
                .fileExt(dto.getFileExt())
                .fileOrder(ParseUtil.parseInt(dto.getFileOrder()))
                .regId(dto.getRegId())
                .regDt(ParseUtil.parseDateTime(dto.getRegDt()))
                .modId(dto.getModId())
                .modDt(ParseUtil.parseDateTime(dto.getModDt()))
                .delYn(dto.getDelYn())
                .build();
    }

    public RunLectureFileTbEntity toEntity() {
        return RunLectureFileTbEntity.builder()
                .lecFileIdx(this.lecFileIdx)
                .lecIdx(this.lecIdx)
                .lecFileType(this.lecFileType)
                .fileIdx(this.fileIdx)
                .fileExt(this.fileExt)
                .fileOrder(this.fileOrder)
                .regId(this.getRegId())
                .regDt(this.getRegDt())
                .modId(this.getModId())
                .modDt(this.getModDt())
                .delYn(this.getDelYn())
                .build();
    }
}

