package com.sklm.lhb.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class CopyFile {

	public static String today=null;
	public static String yesterday = null;
	public CopyFile() {
		/*Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd");
		this.today = dateFormat.format(date);*/
	}
	public void copyFolder(File srcFile,File destFile) throws IOException{
		if(srcFile.isDirectory()) {
			//System.out.println("准备拷贝");
			File newFolder = new File(destFile,srcFile.getName());
			newFolder.mkdirs();
			File[] fileArray = srcFile.listFiles();
			for(File file : fileArray) {
				copyFolder(file, newFolder);
			}
		}else {
			File newFile = new File(destFile,srcFile.getName());
			copyFile(srcFile, newFile);
		}
	}
	
	private void copyFile(File srcFile,File newFile) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
        byte[] bt = new byte[1024];
        int len = 0;
        while((len = bis.read(bt)) != -1) {
        	bos.write(bt,0,len);
        	
        }
        if(bos != null) {
        	bos.close();
        }
        if(bis != null) {
        	bis.close();
        }
        
	
	}
	public static void flagTime() {
		CopyFile.yesterday = CopyFile.today;
	}
}
