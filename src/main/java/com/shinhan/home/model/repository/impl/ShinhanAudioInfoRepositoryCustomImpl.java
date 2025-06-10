package com.shinhan.home.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import com.shinhan.home.model.dto.querydto.ShinhanAudioInfoTbQueryDTO;
import com.shinhan.home.model.repository.custom.ShinhanAudioInfoRepositoryCustom;
import static com.shinhan.home.model.entity.QShinhanAudioInfoTbEntity.shinhanAudioInfoTbEntity;

@Repository
@RequiredArgsConstructor
public class ShinhanAudioInfoRepositoryCustomImpl implements ShinhanAudioInfoRepositoryCustom {
	
	private final JPAQueryFactory queryFactory;

	@Override
	public ShinhanAudioInfoTbQueryDTO findAudioInfo(Integer audioIdx) {
		return queryFactory
	            .select(Projections.constructor(ShinhanAudioInfoTbQueryDTO.class,
	            		shinhanAudioInfoTbEntity.audioIdx,
	            		shinhanAudioInfoTbEntity.audioId,
	            		shinhanAudioInfoTbEntity.audioEncodedName,
	            		shinhanAudioInfoTbEntity.audioExt,
	                    shinhanAudioInfoTbEntity.audioUrl,
	                    shinhanAudioInfoTbEntity.audioContents,
	                    shinhanAudioInfoTbEntity.audioSurmmary,
	                    shinhanAudioInfoTbEntity.regDt
	            ))
	            .from(shinhanAudioInfoTbEntity)
	            .where(shinhanAudioInfoTbEntity.audioIdx.eq(audioIdx))
	            .fetchOne();
	}

}
