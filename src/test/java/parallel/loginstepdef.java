package parallel;

import com.base.baseqa;
import com.page.loginpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class loginstepdef {
	
	loginpage lp = new loginpage(baseqa.getdriver());

	
	@Given("I want to write a step with precondition")
	public void i_want_to() {
		lp.login();
	}
	
	@When("some other precondition")
	public void and_some_cond() {
		lp.verifytitle();
	}
	
	 
}
