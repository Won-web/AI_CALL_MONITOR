package com.shinhan.home.controller.view;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.shinhan.home.util.staticval.CommonValue;

@Controller
public class CommonViewController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = {"sample", "", "/"}, method = RequestMethod.GET)
    public ModelAndView sampleView(@RequestParam Map<String, Object> input, HttpServletRequest req, HttpServletResponse res) throws Exception {
        // 로그인 페이지
        logger.debug(req.getRequestURL().toString() + " 페이지 요청");

        // 세션 확인
        HttpSession session = req.getSession(false);

        // 세션이 있으면 dashboard로 리다이렉트
        if (session != null && session.getAttribute("userIdx") != null) {
        	System.out.println("세션 : "+session.getAttribute("userIdx")+ ","+ session.getAttribute("name"));
            ModelAndView mv = new ModelAndView("redirect:/message/audio");
            return mv;
        }

        // 세션이 없으면 login 페이지로 리다이렉트
        ModelAndView mv = new ModelAndView("redirect:/message/audio");
        return mv;
    }
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView loginView(@RequestParam Map<String, Object> input, HttpServletRequest req, HttpServletResponse res) throws Exception {
	    logger.debug(req.getRequestURL().toString() + " 페이지 요청");

	    HttpSession session = req.getSession(false);

	    // 세션 + userIdx 모두 있어야 dashboard 리다이렉트
	    if (session != null && session.getAttribute("userIdx") != null) {
	    	System.out.println("세션 : "+session.getAttribute("userIdx")+ ","+ session.getAttribute("name"));
	    	
	        logger.debug("이미 로그인된 사용자. dashboard로 리다이렉트");
	        return new ModelAndView("redirect:/message/audio");
	    }

	    ModelAndView mv = new ModelAndView("common/login");
	    mv.addObject("serverStartTime", CommonValue.SERVER_START_DT);
	    return mv;
	}

	
	@RequestMapping(value = "dashboard", method = RequestMethod.GET)
	public ModelAndView dashBoardView(@RequestParam Map<String, Object> input, HttpServletRequest req, HttpSession session) throws Exception {
		// 로그인 페이지
		logger.debug(req.getRequestURL().toString()+" 페이지 요청");
		ModelAndView mv = null;
		
		mv = new ModelAndView("body/home/home");
		
		mv.addObject("serverStartTime", CommonValue.SERVER_START_DT);
		
		return mv;
	}
	
	@RequestMapping(value = "/{path:^(?!uploads$|assets$).+}/{url}", method = RequestMethod.GET)
	public ModelAndView commonUrlView(@RequestParam Map<String, Object> input, @PathVariable("path") String path, @PathVariable("url") String url, HttpServletRequest req) throws Exception {
	    logger.debug(req.getRequestURL().toString() + " 페이지 요청");
	    ModelAndView mv = new ModelAndView("body/" + path + "/" + url);
	    return mv;
	}

	@RequestMapping(value = "/{path:^(?!uploads$|assets$).+}/{url}/{idx}", method = RequestMethod.GET)
	public ModelAndView commonUrlViewWithIdx(@RequestParam Map<String, Object> input, @PathVariable("path") String path, @PathVariable("url") String url, @PathVariable("idx") String idx, HttpServletRequest req) throws Exception {
	    logger.debug(req.getRequestURL().toString() + " 페이지 요청");
	    ModelAndView mv = new ModelAndView("body/" + path + "/" + url);
	    mv.addObject("idx", idx);
	    return mv;
	}
	
	@Deprecated
	@RequestMapping(value = "/page/{path}/{url}", method = RequestMethod.GET)
	public ModelAndView commonUrlViewDev(@RequestParam Map<String, Object> input, @PathVariable String path, @PathVariable String url, HttpServletRequest req) throws Exception {
		// 로그인 페이지
		logger.debug(req.getRequestURL().toString()+" 페이지 요청");
		ModelAndView mv = new ModelAndView("body/" + path + "/" + url);
		return mv;
	}
	
}
