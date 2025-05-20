package com.shinhan.home.model.dto.querydto;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder
public class CommonQueryDTO {
	
	private String searchType;
    private String searchStr;

    private String searchType2;
    private String searchStr2;

    private String searchType3;
    private String searchStr3;

    private String searchType4;
    private String searchStr4;

    private String searchType5;
    private String searchStr5;

    private String searchType6;
    private String searchStr6;

    private String searchType7;
    private String searchStr7;
	
	private String regId;
	private LocalDateTime regDt;
	private String modId;
	private LocalDateTime modDt;
	private String delYn;

}
