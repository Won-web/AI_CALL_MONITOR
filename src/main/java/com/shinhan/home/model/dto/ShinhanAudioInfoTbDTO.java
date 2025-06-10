package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.ShinhanAudioInfoTbQueryDTO;

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
public class ShinhanAudioInfoTbDTO {
	
	private String audioIdx;
    private String audioId;
    private String audioEncodedName;
    private String audioExt;
    private String audioUrl;
    private String audioContents;
    private String audioSurmmary;
    private String regDt;
    
    public static ShinhanAudioInfoTbDTO fromQueryDTO(ShinhanAudioInfoTbQueryDTO queryDTO) {
        return ShinhanAudioInfoTbDTO.builder()
                .audioIdx(queryDTO.getAudioIdx() != null ? String.valueOf(queryDTO.getAudioIdx()) : null)
                .audioId(queryDTO.getAudioId())
                .audioEncodedName(queryDTO.getAudioEncodedName())
                .audioExt(queryDTO.getAudioExt())
                .audioUrl(queryDTO.getAudioUrl())
                .audioContents(queryDTO.getAudioContents())
                .audioSurmmary(queryDTO.getAudioSurmmary())
                .regDt(queryDTO.getRegDt() != null ? ParseUtil.formatDateTime(queryDTO.getRegDt()) : null)
                .build();
    }

}
