package com.reports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreport {
	static ExtentReports ext;
	static Map<Integer,ExtentTest>  extenttestmap= new HashMap();
	
	public static ExtentReports getreport() {
		if(ext ==null) {
		ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
		html.config().setDocumentTitle("Framework");
		html.config().setReportName("Cucumberreport");
		html.config().setTheme(Theme.DARK);
		
		ext = new ExtentReports();
		ext.attachReporter(html);
		
		}
		 return ext;
	}
	public  synchronized static ExtentTest getTest() {
		return (ExtentTest )extenttestmap.get((int)(long)(Thread.currentThread().getId()));
		
	}
	
	
	public synchronized static ExtentTest StartTest(String testname,String desc) {
		ExtentTest test = getreport().createTest(testname,desc);
		extenttestmap.put((int)(long)(Thread.currentThread().getId()),test);
		return test;
		
	}

}
