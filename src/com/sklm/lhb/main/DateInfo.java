package com.sklm.lhb.main;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.DestroyFailedException;

public class DateInfo{

	public static String today;
	public static String tmp;
    public static long timeIntervalValue;
	private File sourceFile;
	private File newFile;
	public static String startDate=null;
	
	public DateInfo() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
		SimpleDateFormat firstStartDate = new SimpleDateFormat("YYYYMMddHHmmss");
		startDate = firstStartDate.format(date);
		this.today = dateFormat.format(date);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				Date date = new Date();
				SimpleDateFormat firstStartDate = new SimpleDateFormat("YYYYMMddHHmmss");
				startDate = firstStartDate.format(date);
				File srcFile = new File(UI.sourceFilePath.getText());
				
				File destFile = new File(UI.toFilePath.getText()+"/"+startDate);
				//System.out.println(destFile.getAbsolutePath()+ "," + destFile.getName());
				//System.out.println(srcFile.getAbsolutePath()+ "," + srcFile.getName());
				CopyFile copyFile = new CopyFile();
				try {
					copyFile.copyFolder(srcFile, destFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}, date, 1000*60*60*24*timeIntervalValue);
		//System.out.println(today);
	}
	


}
