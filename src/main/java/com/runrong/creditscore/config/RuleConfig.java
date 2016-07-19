package com.runrong.creditscore.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.runrong.creditscore.common.dictionary.Constant;
import com.runrong.creditscore.common.util.ReadFileUtil;

/**
 * 计算规则定义
 * @author yanyimin
 *
 */
public class RuleConfig {
	
	//身份信息
	public static Map<String,Object> identityMap=new HashMap<String,Object>();
	//资产信息
	public static Map<String,Object> assetsMap=new HashMap<String,Object>();
	//履约能力
	public static Map<String,Object> performanceAbilityMap=new HashMap<String,Object>();
	//信用历史
	public static Map<String,Object> creidtHistoryMap=new HashMap<String,Object>();
	//行为偏好
	public static Map<String,Object> behaviorPerferenceMap=new HashMap<String,Object>();
	
	public static void init() throws IOException {
		getRule();
	}
	
	public static void getRule() throws IOException{
		
		InputStream in;
		File file =new File("./config/CalculationRule.json");
		if(file.exists()){
			in=new FileInputStream(file);
		}else{
			in=RuleConfig.class.getClassLoader().getResourceAsStream("config/CalculationRule.json");
		}	
		
		String JsonContext=ReadFileUtil.ReadFile(in);
		//将Json转化为Map
		Map<String,Object> jsonMap = JSON.parseObject(JsonContext);
		//解析Map
		List<Map> list = (List<Map>)jsonMap.get("body");  
		
		for(Map map:list){
			if(map.get("module").equals(Constant.IDENTITY_INFO)){
				identityMap=map;			
			};
			if(map.get("module").equals(Constant.ASSETS_INFO)){
				assetsMap=map;
			};
			if(map.get("module").equals(Constant.PERFORMANCE_ABILITY)){
				performanceAbilityMap=map;
			};
			if(map.get("module").equals(Constant.CREDIT_HISTORY)){
				creidtHistoryMap=map;
			};
			if(map.get("module").equals(Constant.BEHAVIOR_PREFERNCE)){
				behaviorPerferenceMap=map;
			};
		}
		  in.close();
	}
	
	
}
