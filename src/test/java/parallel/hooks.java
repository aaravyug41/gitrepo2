package parallel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.baseqa;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {

	WebDriver driver; 
	
	@Before 
	public void bf() throws IOException {
		FileInputStream src = new FileInputStream("src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(src);
		baseqa bq = new baseqa();
	   driver = bq.init(prop.getProperty("browser"));
		
	}
	
	
	@After
	public void af(Scenario sc) throws InterruptedException, IOException {
		if(sc.isFailed()) {
			TakesScreenshot src = (TakesScreenshot)driver;
			byte[] a = src.getScreenshotAs(OutputType.BYTES);
			//sc.embed(a,"image/png");
			sc.attach(a, "image/png", sc.getName());
		}
		
		
		String[] cmd = {"cmd.exe", "/C", "Start","generatereport.bat"};
		Runtime.getRuntime().exec(cmd).waitFor();
		
		driver.quit();
		
		
	}
}
