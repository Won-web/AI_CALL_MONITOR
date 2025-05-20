package com.shinhan.home.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import com.shinhan.home.model.dto.querydto.RunAudioInfoTbQueryDTO;
import com.shinhan.home.model.repository.custom.RunAudioInfoRepositoryCustom;
import static com.shinhan.home.model.entity.QRunAudioInfoTbEntity.runAudioInfoTbEntity;

@Repository
@RequiredArgsConstructor
public class RunAudioInfoRepositoryCustomImpl implements RunAudioInfoRepositoryCustom {
	
	private final JPAQueryFactory queryFactory;

	@Override
	public RunAudioInfoTbQueryDTO findAudioInfo(Integer audioIdx) {
		return queryFactory
	            .select(Projections.constructor(RunAudioInfoTbQueryDTO.class,
	                    runAudioInfoTbEntity.audioIdx,
	                    runAudioInfoTbEntity.audioId,
	                    runAudioInfoTbEntity.audioEncodedName,
	                    runAudioInfoTbEntity.audioExt,
	                    runAudioInfoTbEntity.audioUrl,
	                    runAudioInfoTbEntity.audioContents,
	                    runAudioInfoTbEntity.audioSurmmary,
	                    runAudioInfoTbEntity.regDt
	            ))
	            .from(runAudioInfoTbEntity)
	            .where(runAudioInfoTbEntity.audioIdx.eq(audioIdx))
	            .fetchOne();
	}

}
