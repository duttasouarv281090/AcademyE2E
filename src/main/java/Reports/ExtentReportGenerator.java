package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import HelperClass.ResourceHelper;

public class ExtentReportGenerator {
	static ExtentReports extent;
	public static ExtentReports getExtentReport(String testName)
	{
		String path=ResourceHelper.getResourcePath("//ReportsDocs//"+testName+"//index.html");
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Case Results");
		reporter.config().setReportName("WEB Automation");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sourav");
		return extent;
		
		
		
	}

}
