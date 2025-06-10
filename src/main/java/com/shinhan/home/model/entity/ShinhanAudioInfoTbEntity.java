package com.shinhan.home.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import com.shinhan.home.model.dto.querydto.ShinhanAudioInfoTbQueryDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "shinhan_audio_info_tb")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShinhanAudioInfoTbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audio_idx")
    private Integer audioIdx;

    @Column(name = "audio_id", length = 255)
    private String audioId;
    
    @Column(name = "audio_encoded_name", length = 500)
    private String audioEncodedName;

    @Column(name = "audio_ext", length = 10)
    private String audioExt;

    @Column(name = "audio_url", length = 255)
    private String audioUrl;

    @Lob
    @Column(name = "audio_contents")
    private String audioContents;

    @Lob
    @Column(name = "audio_surmmary")
    private String audioSurmmary;

    @Column(name = "reg_dt")
    private LocalDateTime regDt;
    
    public void updateFromQueryDto(ShinhanAudioInfoTbQueryDTO dto) {
        if (!this.audioIdx.equals(dto.getAudioIdx())) {
            throw new IllegalArgumentException("PrimaryKey audioIdx는 변경할 수 없습니다.");
        }

        if (dto.getAudioId() != null) this.audioId = dto.getAudioId();
        if (dto.getAudioEncodedName() != null) this.audioId = dto.getAudioEncodedName();
        if (dto.getAudioExt() != null) this.audioExt = dto.getAudioExt();
        if (dto.getAudioUrl() != null) this.audioUrl = dto.getAudioUrl();
        if (dto.getAudioContents() != null) this.audioContents = dto.getAudioContents();
        if (dto.getAudioSurmmary() != null) this.audioSurmmary = dto.getAudioSurmmary();
        if (dto.getRegDt() != null) this.regDt = dto.getRegDt();
    }
}
