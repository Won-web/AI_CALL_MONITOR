package com.shinhan.home.model.dto.querydto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.ShinhanAudioInfoTbDTO;
import com.shinhan.home.model.entity.ShinhanAudioInfoTbEntity;
import com.shinhan.home.util.ParseUtil;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class ShinhanAudioInfoTbQueryDTO {
	
	private Integer audioIdx;
    private String audioId;
    private String audioEncodedName;
    private String audioExt;
    private String audioUrl;
    private String audioContents;
    private String audioSurmmary;
    private LocalDateTime regDt;

    @QueryProjection
    public ShinhanAudioInfoTbQueryDTO(Integer audioIdx, String audioId, String audioEncodedName,String audioExt, String audioUrl,
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
    
    public static ShinhanAudioInfoTbQueryDTO fromDTO(ShinhanAudioInfoTbDTO dto) {
        return ShinhanAudioInfoTbQueryDTO.builder()
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

    public ShinhanAudioInfoTbEntity toEntity() {
        return ShinhanAudioInfoTbEntity.builder()
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
