package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport_Utility {
	
	public static final ExtentReports extentReports = new ExtentReports();   //object creation
	public synchronized static ExtentReports createExtentReports() // syn using to avoid thread safety
	{    
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); // extent - folder, inside file created		
		reporter.config().setReportName("GroceryApplication"); //projectname
        extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organization", "Obsqura"); 
		extentReports.setSystemInfo("Name", "Afshan");
		return extentReports;   
	}

}
