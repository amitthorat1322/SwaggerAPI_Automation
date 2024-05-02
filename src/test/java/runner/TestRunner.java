package runner;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"/src/test/resources/features/"},
        glue = {"steps"},
        		dryRun=false,
        plugin = {"pretty","rerun:test-output/scenarios_Failed.txt","html:target/Cr.html",
        			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:\\"
        		
        		 }
        )
    
public class TestRunner {

	/*
	 * @Override
	 * extends AbstractTestNGCucumberTests
	 * @DataProvider(parallel= true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
}
