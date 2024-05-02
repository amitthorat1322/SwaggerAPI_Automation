package runner;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"@test-output/scenarios_Failed.txt"},
        glue = {"steps"},
        tags = "@tag2",
        plugin = {"pretty","rerun:test-output/scenarios_Failed.txt"}
        )
    
public class FailedTestRunner2 extends AbstractTestNGCucumberTests{

	/*
	 * @Override
	 * 
	 * @DataProvider(parallel= true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
}
