package com.shinhan.home.model.vo;

import lombok.Data;

@Data
public class NiceIdVO {
	
	private String accessToken      = null;
	private String clientId         = null;
	private String clientSecret     = null;
	private String authProjectId    = null;
	
	//4. 대칭키 생성
	private String reqDtim          = null;
	private String reqNo            = null;
	private String tokenVal         = null;
	private String symmetricKey     = null;
	private String symmetricIv      = null;
	private String symmetricHmacKey = null;
	
	//5. 요청데이터 암호화
	private String requestno        = null;
	private String returnurl        = null;
	private String sitecode         = null;
	private String methodtype       = "get";
	private String popupyn          = "Y";
	private String receivedata      = null;

	//6. 표준창서비스 호출
	private String tokenVersionId   = null;
	private String encData          = null;
	private String integrityValue   = null;
}
