package com.runrong.creditscore.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.runrong.creditscore.common.base.ResultModel;

@Controller
public class TestController {
	
	@RequestMapping("/test")
	@ResponseBody
	public ResultModel test(HttpServletRequest request){
		
		
		return ResultModel.successModel("信用评分");
	}
}
