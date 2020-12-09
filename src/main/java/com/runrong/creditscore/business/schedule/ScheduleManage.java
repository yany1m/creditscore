package com.runrong.creditscore.business.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class ScheduleManage {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleManage.class);
	
	
	
	/**
	 *每天24点
	 */
	@Scheduled(cron = "0 0 0 * * ?")
	public void clearTimesMap(){
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowTime = new Date(System.currentTimeMillis());
		String time=sd.format(nowTime);
		LOGGER.info("timesMap start clear! time:{}",time);
		
	}
}
