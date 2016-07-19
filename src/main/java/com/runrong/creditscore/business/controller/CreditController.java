package com.runrong.creditscore.business.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.runrong.creditscore.business.dao.BehaviorPreferenceDao;
import com.runrong.creditscore.business.service.AssetsInfoService;
import com.runrong.creditscore.business.service.BehaviorPreferenceService;
import com.runrong.creditscore.business.service.CreditHistoryService;
import com.runrong.creditscore.business.service.IdentityInfoService;
import com.runrong.creditscore.business.service.PerformanceAbilityService;
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
	@Autowired
	IdentityInfoService identityInfoService;
	@Autowired
	PerformanceAbilityService performanceAbilityService;
	@Autowired
	CreditHistoryService creditHistoryService;
	@Autowired
	BehaviorPreferenceService behaviorPreferenceService;
	
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
		
		List<Map> list=new ArrayList<Map>();
		
		list.add(identityInfoService.CountScore(accountId));
		list.add(assetsInfoService.CountScore(accountId));
		list.add(performanceAbilityService.CountScore(accountId));
		list.add(creditHistoryService.CountScore(accountId));
		list.add(behaviorPreferenceService.CountScore(accountId));
		
		return ResultModel.successModel(list);
	}
	
}
