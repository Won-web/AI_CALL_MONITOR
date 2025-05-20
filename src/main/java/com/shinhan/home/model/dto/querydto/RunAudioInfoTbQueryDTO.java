package com.shinhan.home.model.dto.querydto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.RunAudioInfoTbDTO;
import com.shinhan.home.model.entity.RunAudioInfoTbEntity;
import com.shinhan.home.util.ParseUtil;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class RunAudioInfoTbQueryDTO {
	
	private Integer audioIdx;
    private String audioId;
    private String audioEncodedName;
    private String audioExt;
    private String audioUrl;
    private String audioContents;
    private String audioSurmmary;
    private LocalDateTime regDt;

    @QueryProjection
    public RunAudioInfoTbQueryDTO(Integer audioIdx, String audioId, String audioEncodedName,String audioExt, String audioUrl,
                                  String audioContents, String audioSurmmary, LocalDateTime regDt) {
        this.audioIdx = audioIdx;
        this.audioId = audioId;
        this.audioEncodedName = audioEncodedName;
        this.audioExt = audioExt;
        this.audioUrl = audioUrl;
        this.audioContents = audioContents;
        this.audioSurmmary = audioSurmmary;
        this.regDt = regDt;
    }
    
    public static RunAudioInfoTbQueryDTO fromDTO(RunAudioInfoTbDTO dto) {
        return RunAudioInfoTbQueryDTO.builder()
                .audioIdx(ParseUtil.parseInt(dto.getAudioIdx()))
                .audioId(dto.getAudioId())
                .audioEncodedName(dto.getAudioEncodedName())
                .audioExt(dto.getAudioExt())
                .audioUrl(dto.getAudioUrl())
                .audioContents(dto.getAudioContents())
                .audioSurmmary(dto.getAudioSurmmary())
                .regDt(ParseUtil.parseDateTime(dto.getRegDt()))
                .build();
    }

    public RunAudioInfoTbEntity toEntity() {
        return RunAudioInfoTbEntity.builder()
                .audioIdx(audioIdx)
                .audioId(audioId)
                .audioEncodedName(audioEncodedName)
                .audioExt(audioExt)
                .audioUrl(audioUrl)
                .audioContents(audioContents)
                .audioSurmmary(audioSurmmary)
                .regDt(regDt)
                .build();
    }

}
