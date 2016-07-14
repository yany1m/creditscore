package com.runrong.creditscore.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.runrong.creditscore.business.service.AssetsInfoService;
import com.runrong.creditscore.common.base.ResultModel;

/**
 * 信用控制器
 * @author yanyimin
 *
 */
@Controller
public class CreditController {
	
	@Autowired
	AssetsInfoService assetsInfoService;
	
	/**
	 * 得到该用户的信用分数
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCreditScore")
	@ResponseBody
	public ResultModel getCreditScore(HttpServletRequest request){
		
		//token(包含经过加密的accountId、timestamp)
		int accountId=Integer.valueOf(request.getParameter("accountId"));
//		String token=request.getParameter("token");
//			
		return ResultModel.successModel(assetsInfoService.resolveUserCarInfo(accountId));
	}
	
}
