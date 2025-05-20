/*******************************************************************
 * 보안처리 관련 클래스
 * 
 * COPYRIGHT © SHINHAN DATA SYSTEM
 * All rights reserved.
 *******************************************************************/

package com.shinhan.home.util.common;

import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 보안처리 관련 클래스
 * @version 1.0.1
 */
public class ParamCheckUtil {

	private static Logger logger = LoggerFactory.getLogger(ParamCheckUtil.class);

	public static Map<String, Object> xssFilter(Map<String, Object> input) throws Exception {
		Set<String> keyset = input.keySet();
		for(String key : keyset) {
			if(input.get(key) != null) {
				input.put(key, xssFilter(input.get(key).toString()));
			}
		}
		return input;
	}
	
	/**
	 * @분류 : 1. 입력데이터 검증 및 표현 - 크로스사이트 스크립트(시큐어코딩)
	 * @메소드명 : xssFilter
	 * @테스트일자 : 2020. 2. 26.
	 * @개발자 : 이강민
	 * @리턴 : xss 코드가 "" 처리된 String
	 * @메소드설명 : 인자값으로 파라미터의 value, xss코드를 빈값으로 변경후 리턴
	 */
	public static String xssFilter(String value) throws Exception {
		value = value.replaceAll("\\<script\\>", "").replaceAll("\\<\\/script\\>", "");
		value = value.replaceAll("(?i)script", "xss");
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		value = value.replaceAll("'", "&#39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		value = value.replaceAll("[\\\"\\\'][\\s]*vbscript:(.*)[\\\"\\\']"   , "\"\"");
		
		// 태그 이벤트 
		value = value.replaceAll("(?i)expression"         ,  "no_expression");
		value = value.replaceAll("(?i)iframe"             ,  "no_iframe");
		/*value = value.replaceAll("(?i)object"             ,  "no_object");*/
		/*value = value.replaceAll("(?i)embed"              ,  "no_embed");*/
		value = value.replaceAll("(?i)document.cookie"    ,  "");
		value = value.replaceAll("(?i)onabort"            ,  "no_onabort"            );
		value = value.replaceAll("(?i)onactivate"         ,  "no_onactivate"         );
		value = value.replaceAll("(?i)onafterprint"       ,  "no_onafterprint"       );
		value = value.replaceAll("(?i)onafterupdate"      ,  "no_onafterupdate"      );
		value = value.replaceAll("(?i)onbeforeactivate"   ,  "no_onbeforeactivate"   );
		value = value.replaceAll("(?i)onbeforecopy"       ,  "no_onbeforecopy"       );
		value = value.replaceAll("(?i)onbeforecut"        ,  "no_onbeforecut"        );
		value = value.replaceAll("(?i)onbeforedeactivate" ,  "no_onbeforedeactivate" );
		value = value.replaceAll("(?i)onbeforeeditfocus"  ,  "no_onbeforeeditfocus"  );
		value = value.replaceAll("(?i)onbeforepaste"      ,  "no_onbeforepaste"      );
		value = value.replaceAll("(?i)onbeforeprint"      ,  "no_onbeforeprint"      );
		value = value.replaceAll("(?i)onbeforeunload"     ,  "no_onbeforeunload"     );
		value = value.replaceAll("(?i)onbeforeupdate"     ,  "no_onbeforeupdate"     );
		value = value.replaceAll("(?i)onblur"             ,  "no_onblur"             );
		value = value.replaceAll("(?i)onbounce"           ,  "no_onbounce"           );
		value = value.replaceAll("(?i)oncellchange"       ,  "no_oncellchange"       );
		value = value.replaceAll("(?i)onchange"           ,  "no_onchange"           );
		value = value.replaceAll("(?i)onclick"            ,  "no_onclick"            );
		value = value.replaceAll("(?i)oncontextmenu"      ,  "no_oncontextmenu"      );
		value = value.replaceAll("(?i)oncontrolselect"    ,  "no_oncontrolselect"    );
		value = value.replaceAll("(?i)oncopy"             ,  "no_oncopy"             );
		value = value.replaceAll("(?i)oncut"              ,  "no_oncut"              );
		value = value.replaceAll("(?i)ondataavailable"    ,  "no_ondataavailable"    );
		value = value.replaceAll("(?i)ondatasetchanged"   ,  "no_ondatasetchanged"   );
		value = value.replaceAll("(?i)ondatasetcomplete"  ,  "no_ondatasetcomplete"  );
		value = value.replaceAll("(?i)ondblclick"         ,  "no_ondblclick"         );
		value = value.replaceAll("(?i)ondeactivate"       ,  "no_ondeactivate"       );
		value = value.replaceAll("(?i)ondrag"             ,  "no_ondrag"             );
		value = value.replaceAll("(?i)ondragend"          ,  "no_ondragend"          );
		value = value.replaceAll("(?i)ondragenter"        ,  "no_ondragenter"        );
		value = value.replaceAll("(?i)ondragleave"        ,  "no_ondragleave"        );
		value = value.replaceAll("(?i)ondragover"         ,  "no_ondragover"         );
		value = value.replaceAll("(?i)ondragstart"        ,  "no_ondragstart"        );
		value = value.replaceAll("(?i)ondrop"             ,  "no_ondrop"             );
		value = value.replaceAll("(?i)onerror"            ,  "no_onerror"            );
		value = value.replaceAll("(?i)onerrorupdate"      ,  "no_onerrorupdate"      );
		value = value.replaceAll("(?i)onfilterchange"     ,  "no_onfilterchange"     );
		value = value.replaceAll("(?i)onfinish"           ,  "no_onfinish"           );
		value = value.replaceAll("(?i)onfocus"            ,  "no_onfocus"            );
		value = value.replaceAll("(?i)onfocusin"          ,  "no_onfocusin"          );
		value = value.replaceAll("(?i)onfocusout"         ,  "no_onfocusout"         );
		value = value.replaceAll("(?i)onhelp"             ,  "no_onhelp"             );
		value = value.replaceAll("(?i)onkeydown"          ,  "no_onkeydown"          );
		value = value.replaceAll("(?i)onkeypress"         ,  "no_onkeypress"         );
		value = value.replaceAll("(?i)onkeyup"            ,  "no_onkeyup"            );
		value = value.replaceAll("(?i)onlayoutcomplete"   ,  "no_onlayoutcomplete"   );
		value = value.replaceAll("(?i)onload"             ,  "no_onload"             );
		value = value.replaceAll("(?i)onlosecapture"      ,  "no_onlosecapture"      );
		value = value.replaceAll("(?i)onmousedown"        ,  "no_onmousedown"        );
		value = value.replaceAll("(?i)onmouseenter"       ,  "no_onmouseenter"       );
		value = value.replaceAll("(?i)onmouseleave"       ,  "no_onmouseleave"       );
		value = value.replaceAll("(?i)onmousemove"        ,  "no_onmousemove"        );
		value = value.replaceAll("(?i)onmouseout"         ,  "no_onmouseout"         );
		value = value.replaceAll("(?i)onmouseover"        ,  "no_onmouseover"        );
		value = value.replaceAll("(?i)onmouseup"          ,  "no_onmouseup"          );
		value = value.replaceAll("(?i)onmousewheel"       ,  "no_onmousewheel"       );
		value = value.replaceAll("(?i)onmove"             ,  "no_onmove"             );
		value = value.replaceAll("(?i)onmoveend"          ,  "no_onmoveend"          );
		value = value.replaceAll("(?i)onmovestart"        ,  "no_onmovestart"        );
		value = value.replaceAll("(?i)onpaste"            ,  "no_onpaste"            );
		value = value.replaceAll("(?i)onpropertychange"   ,  "no_onpropertychange"   );
		value = value.replaceAll("(?i)onreadystatechange" ,  "no_onreadystatechange" );
		value = value.replaceAll("(?i)onreset"            ,  "no_onreset"            );
		value = value.replaceAll("(?i)onresize"           ,  "no_onresize"           );
		value = value.replaceAll("(?i)onresizeend"        ,  "no_onresizeend"        );
		value = value.replaceAll("(?i)onresizestart"      ,  "no_onresizestart"      );
		value = value.replaceAll("(?i)onrowenter"         ,  "no_onrowenter"         );
		value = value.replaceAll("(?i)onrowexit"          ,  "no_onrowexit"          );
		value = value.replaceAll("(?i)onrowsdelete"       ,  "no_onrowsdelete"       );
		value = value.replaceAll("(?i)onrowsinserted"     ,  "no_onrowsinserted"     );
		value = value.replaceAll("(?i)onscroll"           ,  "no_onscroll"           );
		value = value.replaceAll("(?i)onselect"           ,  "no_onselect"           );
		value = value.replaceAll("(?i)onselectionchange"  ,  "no_onselectionchange"  );
		value = value.replaceAll("(?i)onselectstart"      ,  "no_onselectstart"      );
		value = value.replaceAll("(?i)onstart"            ,  "no_onstart"            );
		value = value.replaceAll("(?i)onstop"             ,  "no_onstop"             );
		value = value.replaceAll("(?i)onsubmit"           ,  "no_onsubmit"           );
		value = value.replaceAll("(?i)onunload"           ,  "no_onunload"           );
		
		return value;
	}
	
	/**
	 * =====================================[ITKEY]
	 * 
	 * @분류 : 2.보안기능 - 취약한 비밀번호 허용(시큐어코딩)
	 * @메소드명 : passwordRuleChecker
	 * @테스트일자 : 2020. 2. 26.
	 * @개발자 : 이강민
	 * @리턴 : 성공/실패(boolean)
	 * @메소드설명 : "영문/숫자/특수기호 중 3개를 사용하여 8자 이상" 또는 "영문/숫자/특수기호 중 2개를 사용하여 10자 이상" 조건
	 *        Validator ===========================================
	 */
	public static boolean passwordRuleChecker(String pw) throws Exception {
		/* 영문/숫자/특수기호 중 3개를 사용하여 8자 이상 16자 이하*/
		String regCombine = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$";
		
		/* 영문/숫자/특수기호 중 3개를 사용하여 8자 이상 */
		String regAllCombine = "^(?=.*\\d{1,50})(?=.*[~`!@#$%\\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$";

		/* 영문/숫자/특수기호 중 2개를 사용하여 10자 이상 */
		String regEngNum = "^(?=.*[a-zA-Z])(?=.*[0-9]).{10,12}$"; // 영문,숫자
		String regEngETC = "^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{10,12}$"; // 영문,특수문자
		String regETCNum = "^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{10,12}$"; // 특수문자, 숫자

		if (Pattern.matches(regCombine, pw)) {
			/* 영문/숫자/특수기호 중 3개를 사용하여 8자 이상 충족 조건 */
			logger.debug("Input PW : " + pw + " - 영문/숫자/특수기호 중 3개를 사용하여 8자 이상 16자 이하 충족");
			return true;
		} else {
//			if (Pattern.matches(regEngNum, pw) || Pattern.matches(regEngETC, pw) || Pattern.matches(regETCNum, pw)) {
//				/* 영문/숫자/특수기호 중 2개를 사용하여 10자 이상 충족 조건 */
//				logger.debug("[PW VALIDATOR] PW : " + pw + " - 영문/숫자/특수기호 중 2개를 사용하여 10자 이상 충족");
//				return true;
//			}
			logger.debug("[PW VALIDATOR] PW : " + pw + " - 비밀번호 조건 실패");
			return false;
		}
	}
}
