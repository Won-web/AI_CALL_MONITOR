package com.shinhan.home.model.dto;

import com.shinhan.home.model.dto.querydto.RunVideoInfoTbQueryDTO;

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
public class RunVideoInfoTbDTO {
	
	private String videoIdx;
	private String videoId;
	private String videoExt;
	private String videoUrl;
	private String videoContents;
	private String videoSummary;
	private String videoQuiz;
	private String regDt;
	
	public static RunVideoInfoTbDTO fromQueryDTO(RunVideoInfoTbQueryDTO queryDTO) {
		RunVideoInfoTbDTO dto = new RunVideoInfoTbDTO();
		
		dto.setVideoIdx(queryDTO.getVideoIdx() != null ? String.valueOf(queryDTO.getVideoIdx()) : null);
		dto.setVideoId(queryDTO.getVideoId());
		dto.setVideoExt(queryDTO.getVideoExt());
		dto.setVideoUrl(queryDTO.getVideoUrl());
		dto.setVideoContents(queryDTO.getVideoContents());
		dto.setVideoSummary(queryDTO.getVideoSummary());
		dto.setVideoQuiz(queryDTO.getVideoQuiz());
		dto.setRegDt(queryDTO.getRegDt() != null ? ParseUtil.formatDateTime(queryDTO.getRegDt()) : null);

		return dto;
		
	}
}
