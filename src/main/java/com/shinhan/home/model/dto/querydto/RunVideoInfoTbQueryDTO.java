package com.shinhan.home.model.dto.querydto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.querydsl.core.annotations.QueryProjection;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.shinhan.home.model.dto.RunVideoInfoTbDTO;
import com.shinhan.home.model.entity.RunVideoInfoTbEntity;
import com.shinhan.home.util.ParseUtil;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class RunVideoInfoTbQueryDTO {
	
	private Integer videoIdx;
	private String videoId;
	private String videoExt;
	private String videoUrl;
	private String videoContents;
	private String videoSummary;
	private String videoQuiz;
	private LocalDateTime regDt;
	
	@QueryProjection
	public RunVideoInfoTbQueryDTO(Integer videoIdx, String videoId, String videoExt, String videoUrl,
								String videoContents, String videoSummary, String videoQuiz, LocalDateTime regDt) {
		
		this.videoIdx = videoIdx;
		this.videoId = videoId;
		this.videoExt = videoExt;
		this.videoUrl = videoUrl;
		this.videoContents = videoContents;
		this.videoSummary = videoSummary;
		this.videoQuiz = videoQuiz;
		this.regDt = regDt;
	}
	
	public static RunVideoInfoTbQueryDTO fromDTO(RunVideoInfoTbDTO dto) {
		RunVideoInfoTbQueryDTO queryDTO = new RunVideoInfoTbQueryDTO();
		
		queryDTO.setVideoIdx(ParseUtil.parseInt(dto.getVideoIdx()));
		queryDTO.setVideoId(dto.getVideoId());
		queryDTO.setVideoExt(dto.getVideoExt());
		queryDTO.setVideoUrl(dto.getVideoUrl());
		queryDTO.setVideoContents(dto.getVideoContents());
		queryDTO.setVideoSummary(dto.getVideoSummary());
		queryDTO.setVideoQuiz(dto.getVideoQuiz());
		queryDTO.setRegDt(ParseUtil.parseDateTime(dto.getRegDt()));

		return queryDTO;
	}
	
	public RunVideoInfoTbEntity toEntity() {
		return RunVideoInfoTbEntity.builder()
			.videoIdx(this.videoIdx)
			.videoId(this.videoId)
			.videoExt(this.videoExt)
			.videoUrl(this.videoUrl)
			.videoContents(this.videoContents)
			.videoSummary(this.videoSummary)
			.videoQuiz(this.videoQuiz)
			.regDt(this.regDt)
			.build();
	}
}
