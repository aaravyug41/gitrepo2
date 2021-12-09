package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/test/resources/parallel"},
                  glue = {"parallel","hooks"},
                  tags = "@tag",
                  plugin = {"pretty",
                		 "json:target/cucumber.json"},
		publish =true
		)
public class runner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
