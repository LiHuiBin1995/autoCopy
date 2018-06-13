package com.sklm.lhb.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class UI extends JFrame implements ActionListener {

	private JFrame frame; 
	private JPanel jp;
	private JLabel sourceFile;
	public static JTextField sourceFilePath;
	private JLabel toFile;
	public static JTextField toFilePath;
	private JButton okBtn;
	private JButton cancelBtn;
	private JButton chooseSourceFile;
	private JButton toNewFilePath;
	public JFileChooser sourceChoose;
	private JTextArea message;
	private JLabel timeInterval;
	private JLabel label;
	private JLabel timeIntervalNote;
	public static JTextField timeIntervalValue;
	private JScrollPane verticalBar;
	
	public JLabel deleteFileInterval;
	public static JTextField deleteFileInterval_TextField;
	public JLabel saveFileTypeLabel;
	
	private GridLayout gy;
	private FlowLayout fl;
	public UI(){
		frame = new JFrame();
		
		jp = new JPanel();
		gy = new GridLayout(3, 3);
		fl = new FlowLayout();
		sourceFile = new JLabel("源文件：");
		sourceFile.setSize(60, 30);
		sourceFilePath = new JTextField();
		sourceFilePath.setSize(154, 20);
		chooseSourceFile = new JButton("选择源文件");
		chooseSourceFile.addActionListener(this);
		toFile = new JLabel("拷贝到：");
		toFilePath = new JTextField();
		toFilePath.setSize(200, 20);
		toNewFilePath = new JButton("拷贝到");
		toNewFilePath.addActionListener(this);
		okBtn = new JButton("确定");
		okBtn.addActionListener(this);
		cancelBtn = new JButton("取消");
		cancelBtn.addActionListener(this);
		timeInterval = new JLabel("文件拷贝间隔(天):");
		timeIntervalValue = new JTextField(24);
		timeIntervalValue.setText("1");
		deleteFileInterval = new JLabel("文件保留时长(天):");
		deleteFileInterval_TextField = new JTextField();
		deleteFileInterval_TextField.setText("7");
		deleteFileInterval_TextField.setSize(200, 20);
		saveFileTypeLabel = new JLabel("保留时间必须是正整数");
		saveFileTypeLabel.setFont(new Font("宋体", 0, 12));
		saveFileTypeLabel.setForeground(Color.red);
		
		label = new JLabel("信息输入:");
		message = new JTextArea("文本框中不能为空...");
		message.setFont(new Font("宋体",0,15));
		verticalBar = new JScrollPane(message);
		timeIntervalNote = new JLabel("时间间隔必须是正整数");
		timeIntervalNote.setFont(new Font("宋体", 0, 12));
		timeIntervalNote.setForeground(Color.red);
		
	
		this.setLayout(null);
		
		sourceFile.setBounds(10, 9, 80, 20);
		sourceFilePath.setBounds(95, 5, 200, 30);
		chooseSourceFile.setBounds(300, 5, 150, 30);
		
		toFile.setBounds(10, 59, 80, 20);
		toFilePath.setBounds(95, 55, 200, 30);
		toNewFilePath.setBounds(300, 55, 150, 30);
		
		timeInterval.setBounds(10, 109, 120, 20);
		timeIntervalValue.setBounds(130, 105, 185, 30);
		timeIntervalNote.setBounds(320, 109, 150, 20);
		
		deleteFileInterval.setBounds(10, 159, 120, 20);
		deleteFileInterval_TextField.setBounds(130, 159, 185, 30);
		saveFileTypeLabel.setBounds(320, 161, 150, 20);
		label.setBounds(10,209,80,20);
		verticalBar.setBounds(10, 230, 440, 50);
		okBtn.setBounds(10, 285, 150, 30);
		cancelBtn.setBounds(300, 285, 150, 30);
		
	

		this.add(sourceFile);
		this.add(sourceFilePath);
		this.add(chooseSourceFile);
		this.add(toFile);
		this.add(toFilePath);
		this.add(toNewFilePath);
		this.add(timeInterval);
		this.add(timeIntervalValue);
		this.add(timeIntervalNote);
		this.add(deleteFileInterval);
		this.add(deleteFileInterval_TextField);
		this.add(saveFileTypeLabel);
		this.add(label);
		this.add(verticalBar);
		this.add(okBtn);
		this.add(cancelBtn);
		
		//this.add(jsp);
		
		frame.add(jp);
		this.setTitle("文件自动拷贝系统");
		this.setSize(477, 367);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("选择源文件")) {
			sourceChoose = new JFileChooser();
			sourceChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选择目录
			sourceChoose.setDialogTitle("拷贝到...");
		    String path = null;
		    File file = null;
		    boolean hasSubDir = false;
		    int returnValue = 0;
		    try {
				returnValue = sourceChoose.showSaveDialog(null);
			} catch (HeadlessException e2) {
				message.setText("Open File Dialog ERROR!");
			}
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				//获得文件
				file = sourceChoose.getSelectedFile();
				path = file.getPath();
				sourceFilePath.setText(path);
				
				
			}
			
		}
		if(e.getActionCommand().equals("拷贝到")) {
			sourceChoose = new JFileChooser();
			sourceChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//只能选择目录
			sourceChoose.setDialogTitle("拷贝到...");
		    String path = null;
		    File file = null;
		    boolean hasSubDir = false;
		    int returnValue = 0;
		    try {
				returnValue = sourceChoose.showSaveDialog(null);
			} catch (HeadlessException e2) {
				message.setText("Open File Dialog ERROR!");
			}
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				//获得文件
				file = sourceChoose.getSelectedFile();
				path = file.getPath();
				toFilePath.setText(path);		
				
			}
			
			
			
		}
		
		if(e.getActionCommand().equals("确定")) {
			okBtn.setEnabled(false);
			chooseSourceFile.setEnabled(false);
			toNewFilePath.setEnabled(false);
			sourceFilePath.setEnabled(false);
			toFilePath.setEnabled(false);
			timeIntervalValue.setEnabled(false);
			deleteFileInterval_TextField.setEnabled(false);
			Date date = new Date();
			SimpleDateFormat firstStartDate = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String startDate = firstStartDate.format(date);
			
			if(!(sourceFilePath.getText().equals("")) && !(toFilePath.getText().equals("")) && !(timeIntervalValue.equals(""))) {
				
				DeleteFile df = new DeleteFile();
				
				DateInfo.timeIntervalValue = Long.parseLong(timeIntervalValue.getText());
				message.setText("");//清空文本区域
				message.setText("开始复制...\n"
						+ "文件源位置:"+sourceFilePath.getText()+"\n"
						+ "文件复制到:"+toFilePath.getText()+"\n"
						+ "文件自动复制的时间间隔:"+timeIntervalValue.getText()+"\n"
						+ "系统启动时间:" + startDate+"\n"
						);
				
				int i=2;
				do {
					DateInfo di = new DateInfo();
					--i;
				}while(i>0);
			}
			
			
		}	
		
        if(e.getActionCommand().equals("取消")) {
			
        	System.exit(0);
			
		}	
		
	}

	
	

}
