package com.shinhan.home.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author 이강민
 * 모든 DTO는 CommonDTO를 상속 받아 공통 컬럼을 처리한다.
 * ※ SELECT 요청시 del_yn 주의
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@SuperBuilder
public class CommonDTO implements Serializable {
	
	// redis세팅
	private static final long serialVersionUID = 1L;
	
	private String searchType          = null; // 1번 검색 타입
	@Setter(AccessLevel.NONE)
	private String searchStr           = null; // 1번 검색 타입에 따른 검색어
	
	private String searchType2         = null; // 2번 검색 타입
	@Setter(AccessLevel.NONE)
	private String searchStr2          = null; // 2번 검색 타입에 따른 검색어
	
	private String searchType3         = null; // 3번 검색 타입
	@Setter(AccessLevel.NONE)
	private String searchStr3          = null; // 3번 검색 타입에 따른 검색어
	
	private String searchType4         = null; // 4번 검색 타입
	@Setter(AccessLevel.NONE)
	private String searchStr4          = null; // 4번 검색 타입에 따른 검색어
	
	private String searchType5         = null; // 5번 검색 타입
	@Setter(AccessLevel.NONE)
	private String searchStr5          = null; // 5번 검색 타입에 따른 검색어
	
	private String searchType6         = null; // 6번 검색 타입
	@Setter(AccessLevel.NONE)
	private String searchStr6          = null; // 6번 검색 타입에 따른 검색어
	
	private String searchType7         = null; // 7번 검색 타입
	@Setter(AccessLevel.NONE)
	private String searchStr7          = null; // 7번 검색 타입에 따른 검색어
	
	private String delYn               = null; // 삭제 여부
	
	@Setter(AccessLevel.NONE)
	private String regId               = null; // 최초등록자 ID(사용자, 관리자, 업체담당자 관리 테이블 IDX)
	
	private String regDt               = null; // 최초등록일 (NOW() 함수 사용, Insert시 현재 일자) 
	private String regDtSearchFrom     = null; // 최초등록일 검색용
	private String regDtSearchTo       = null; // 최초등록일 검색용
	
	@Setter(AccessLevel.NONE)
	private String modId               = null; // 최종수정자 ID(사용자, 관리자, 업체담당자 관리 테이블 IDX)

	private String modDt               = null; // 최종수정일 (NOW() 함수 사용, Insert시 현재 일자)
	private String modDtSearchFrom     = null; // 최종수정일 검색용
	private String modDtSearchTo       = null; // 최종수정일 검색용
	
	private String orderBy			   = null; // 정렬방식
	
	///////////////////////////////////////////////////////////////////////// [모든 테이블 공통 컬럼]
	
	public void setSearchStr(String searchStr) {
		try {
			this.searchStr = searchStr.trim();
		} catch(Exception e) {
			this.searchStr = searchStr;
		}
	}

	public void setSearchStr2(String searchStr2) {
		try {
			this.searchStr2 = searchStr2.trim();
		} catch(Exception e) {
			this.searchStr2 = searchStr2;
		}
	}

	public void setSearchStr3(String searchStr3) {
		try {
			this.searchStr3 = searchStr3.trim();
		} catch(Exception e) {
			this.searchStr3 = searchStr3;
		}
	}

	public void setSearchStr4(String searchStr4) {
		try {
			this.searchStr4 = searchStr4.trim();
		} catch(Exception e) {
			this.searchStr4 = searchStr4;
		}
	}

	public void setSearchStr5(String searchStr5) {
		try {
			this.searchStr5 = searchStr5.trim();
		} catch(Exception e) {
			this.searchStr5 = searchStr5;
		}
	}

	public void setSearchStr6(String searchStr6) {
		try {
			this.searchStr6 = searchStr6.trim();
		} catch(Exception e) {
			this.searchStr6 = searchStr6;
		}
	}

	public void setSearchStr7(String searchStr7) {
		try {
			this.searchStr7 = searchStr7.trim();
		} catch(Exception e) {
			this.searchStr7 = searchStr7;
		}
	}

	public void setRegId(String regId) {
		try {
			this.regId = regId.trim();
		} catch(Exception e) {
			this.regId = regId;
		}
	}

	public void setModId(String modId) {
		try {
			this.modId = modId.trim();
		} catch(Exception e) {
			this.modId = modId;
		}
	}
}
